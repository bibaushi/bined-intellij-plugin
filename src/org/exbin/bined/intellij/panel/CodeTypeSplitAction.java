/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.bined.intellij.panel;

import com.intellij.icons.AllIcons;
import com.intellij.ide.HelpTooltip;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.ActionButtonLook;
import com.intellij.openapi.actionSystem.ex.ActionUtil;
import com.intellij.openapi.actionSystem.ex.AnActionListener;
import com.intellij.openapi.actionSystem.ex.CustomComponentAction;
import com.intellij.openapi.actionSystem.impl.ActionButton;
import com.intellij.openapi.actionSystem.impl.ActionManagerImpl;
import com.intellij.openapi.actionSystem.impl.MenuItemPresentationFactory;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.ui.JBInsets;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.intellij.openapi.actionSystem.ActionToolbar.DEFAULT_MINIMUM_BUTTON_SIZE;

/**
 * Split button action derived from {com.intellij.openapi.actionSystem.SplitButtonAction}.
 *
 * @author ExBin Project (http://exbin.org)
 * @version 0.2.2 2020/01/25
 */
public class CodeTypeSplitAction extends AnAction implements CustomComponentAction {

    private final ActionGroup myActionGroup;
    private int selectedIndex = -1;
    private CodeTypeSplitAction.SplitButton splitButton = null;

    public CodeTypeSplitAction(@NotNull ActionGroup actionGroup) {
        myActionGroup = actionGroup;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
    }

    @Override
    public boolean isDumbAware() {
        return myActionGroup.isDumbAware();
    }

    @Override
    @NotNull
    public JComponent createCustomComponent(@NotNull Presentation presentation, @NotNull String place) {
        splitButton = new CodeTypeSplitAction.SplitButton(this, presentation, place, myActionGroup);
        splitButton.setSelectedIndex(selectedIndex);
        return splitButton;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
        if (splitButton != null) {
            splitButton.setSelectedIndex(selectedIndex);
        }
    }

    private static class SplitButton extends ActionButton implements AnActionListener {
        private enum MousePressType {
            Action, Popup, None
        }

        private static final Icon ARROW_DOWN = AllIcons.General.ButtonDropTriangle;

        private final ActionGroup myActionGroup;
        private int selectedIndex = 0;
        private boolean actionEnabled = true;
        private CodeTypeSplitAction.SplitButton.MousePressType mousePressType = CodeTypeSplitAction.SplitButton.MousePressType.None;
        private Disposable myDisposable;

        private SplitButton(AnAction action, Presentation presentation, String place, ActionGroup actionGroup) {
            super(action, presentation, place, DEFAULT_MINIMUM_BUTTON_SIZE);
            myActionGroup = actionGroup;

            AnAction[] actions = myActionGroup.getChildren(null);
            if (actions.length > 0) {
                AnAction selectedAction = actions[0];
                copyPresentation(selectedAction.getTemplatePresentation());
            }
        }

        private void copyPresentation(Presentation presentation) {
            myPresentation.copyFrom(presentation);
            actionEnabled = presentation.isEnabled();
            myPresentation.setEnabled(true);
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = super.getPreferredSize();
            size.width += ARROW_DOWN.getIconWidth() + scale(7);
            return size;
        }

        private boolean selectedActionEnabled() {
            return selectedIndex >= 0 && actionEnabled;
        }

        @Override
        public void paintComponent(Graphics g) {
            ActionButtonLook look = getButtonLook();
            if (selectedActionEnabled() || !UIUtil.isUnderDarcula()) {
                int state = getPopState();
                if (state == PUSHED) state = POPPED;
                look.paintBackground(g, this, state);
            }

            Rectangle baseRect = new Rectangle(getSize());
            JBInsets.removeFrom(baseRect, getInsets());

            if (getPopState() == PUSHED && mousePressType != CodeTypeSplitAction.SplitButton.MousePressType.None && selectedActionEnabled() || isToggleActionPushed()) {
                int arrowWidth = ARROW_DOWN.getIconWidth() + scale(7);

                Shape clip = g.getClip();
                Area buttonClip = new Area(clip);
                Rectangle execButtonRect = new Rectangle(baseRect.x, baseRect.y, baseRect.width - arrowWidth, baseRect.height);
                if (mousePressType == CodeTypeSplitAction.SplitButton.MousePressType.Action || isToggleActionPushed()) {
                    buttonClip.intersect(new Area(execButtonRect));
                } else if (mousePressType == CodeTypeSplitAction.SplitButton.MousePressType.Popup) {
                    Rectangle arrowButtonRect = new Rectangle(execButtonRect.x + execButtonRect.width, baseRect.y, arrowWidth, baseRect.height);
                    buttonClip.intersect(new Area(arrowButtonRect));
                }

                g.setClip(buttonClip);
                look.paintBackground(g, this, PUSHED);
                g.setClip(clip);
            }

            int x = baseRect.x + baseRect.width - scale(3) - ARROW_DOWN.getIconWidth();
            int y = baseRect.y + (baseRect.height - ARROW_DOWN.getIconHeight()) / 2 + scale(1);
            look.paintIconAt(g, ARROW_DOWN, x, y);

            x -= scale(4);
            if (getPopState() == POPPED || getPopState() == PUSHED) {
                g.setColor(JBUI.CurrentTheme.ActionButton.hoverSeparatorColor());
                g.fillRect(x, baseRect.y, scale(1), baseRect.height);
            }

            Icon actionIcon = getIcon();
            if (!selectedActionEnabled()) {
                Icon disabledIcon = myPresentation.getDisabledIcon();
                actionIcon = disabledIcon != null ? disabledIcon : IconLoader.getDisabledIcon(actionIcon);
                if (actionIcon == null) {
                    actionIcon = getFallbackIcon(false);
                }
            }

            x = baseRect.x + (x - actionIcon.getIconWidth()) / 2;
            y = baseRect.y + (baseRect.height - actionIcon.getIconHeight()) / 2;
            look.paintIconAt(g, actionIcon, x, y);
        }

        private boolean isToggleActionPushed() {
            if (selectedIndex == -1)
                return false;

            AnAction[] actions = myActionGroup.getChildren(null);
            return actions[selectedIndex] instanceof Toggleable &&
                    myPresentation.getClientProperty(Toggleable.SELECTED_PROPERTY) == Boolean.TRUE;
        }

        @Override
        protected void onMousePressed(@NotNull MouseEvent e) {
            Rectangle baseRect = new Rectangle(getSize());
            JBInsets.removeFrom(baseRect, getInsets());
            int arrowWidth = ARROW_DOWN.getIconWidth() + scale(7);

            Rectangle execButtonRect = new Rectangle(baseRect.x, baseRect.y, baseRect.width - arrowWidth, baseRect.height);
            Rectangle arrowButtonRect = new Rectangle(execButtonRect.x + execButtonRect.width, baseRect.y, arrowWidth, baseRect.height);

            Point p = e.getPoint();
            mousePressType = execButtonRect.contains(p) ? CodeTypeSplitAction.SplitButton.MousePressType.Action :
                    arrowButtonRect.contains(p) ? CodeTypeSplitAction.SplitButton.MousePressType.Popup :
                            CodeTypeSplitAction.SplitButton.MousePressType.None;
        }

        @Override
        protected void actionPerformed(AnActionEvent event) {
            HelpTooltip.hide(this);

            if (mousePressType == CodeTypeSplitAction.SplitButton.MousePressType.Popup) {
                showPopupMenu(event, myActionGroup);
            } else if (selectedActionEnabled()) {
                AnActionEvent newEvent = AnActionEvent.createFromInputEvent(event.getInputEvent(), myPlace, event.getPresentation(), getDataContext());
                AnAction[] actions = myActionGroup.getChildren(null);
                if (selectedIndex >= actions.length -1) {
                    selectedIndex = 0;
                } else {
                    selectedIndex++;
                }
                AnAction action = actions[selectedIndex];
                myPresentation.setIcon(action.getTemplatePresentation().getIcon());
                myPresentation.setText(action.getTemplatePresentation().getText());
                ActionUtil.performActionDumbAware(action, newEvent);
            }
        }

        public void setSelectedIndex(int selectedIndex) {
            this.selectedIndex = selectedIndex;
            AnAction[] actions = myActionGroup.getChildren(null);
            AnAction action = actions[selectedIndex];
            myPresentation.setIcon(action.getTemplatePresentation().getIcon());
            myPresentation.setText(action.getTemplatePresentation().getText());
        }

        @Override
        protected void showPopupMenu(AnActionEvent event, ActionGroup actionGroup) {
            ActionManagerImpl am = (ActionManagerImpl) ActionManager.getInstance();
            ActionPopupMenu popupMenu = am.createActionPopupMenu(event.getPlace(), actionGroup, new MenuItemPresentationFactory() {
                @Override
                protected void processPresentation(Presentation presentation) {
                    if (presentation != null &&
                            StringUtil.defaultIfEmpty(presentation.getText(), "").equals(myPresentation.getText()) &&
                            StringUtil.defaultIfEmpty(presentation.getDescription(), "").equals(myPresentation.getDescription())) {
                        presentation.setEnabled(selectedActionEnabled());
                        //presentation.putClientProperty(Toggleable.SELECTED_PROPERTY, myPresentation.getClientProperty(Toggleable.SELECTED_PROPERTY));
                    }
                }
            });
            popupMenu.setTargetComponent(this);

            JPopupMenu menu = popupMenu.getComponent();
            if (event.isFromActionToolbar()) {
                menu.show(this, DEFAULT_MINIMUM_BUTTON_SIZE.width + getInsets().left, getHeight());
            } else {
                menu.show(this, getWidth(), 0);
            }

            HelpTooltip.setMasterPopupOpenCondition(this, () -> !menu.isVisible());
        }

        @Override
        public void addNotify() {
            super.addNotify();
            myDisposable = Disposer.newDisposable();
            ApplicationManager.getApplication().getMessageBus().connect(myDisposable).subscribe(AnActionListener.TOPIC, this);
        }

        @Override
        public void removeNotify() {
            super.removeNotify();
            if (myDisposable != null) {
                Disposer.dispose(myDisposable);
                myDisposable = null;
            }
        }

        @Override
        public void afterActionPerformed(@NotNull AnAction action, @NotNull DataContext
                dataContext, @NotNull AnActionEvent event) {
//            if (selectedAction != action && myAction != action) {
//                selectedAction = action;
//                copyPresentation(selectedAction.getTemplatePresentation());
//
//                if(selectedAction instanceof Toggleable) {
//                    myPresentation.putClientProperty(Toggleable.SELECTED_PROPERTY, event.getPresentation().getClientProperty(Toggleable.SELECTED_PROPERTY));
//                }
//            }
//            else if (myPresentation != event.getPresentation()) {
//                copyPresentation(event.getPresentation());
//            }
//            else if (!myPresentation.isEnabled()) {
//                actionEnabled = false;
//                myPresentation.setEnabled(true);
//            }
            repaint();
        }
    }

    /**
     * Best effort attempt to detect scale...
     */
    public static int scale(int i) {
        try {
            return JBUI.scale(i);
        } catch (Exception ex) {
            Logger.getLogger(CodeTypeSplitAction.class.getName()).log(Level.SEVERE, "Unable to use JBUI class", ex);
        }
        return i;
    }
}
