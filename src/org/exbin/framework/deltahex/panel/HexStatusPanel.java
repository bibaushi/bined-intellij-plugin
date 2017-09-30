/*
 * Copyright (C) ExBin Project
 *
 * This application or library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * This application or library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along this application.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.exbin.framework.deltahex.panel;

import org.exbin.deltahex.EditationMode;
import org.exbin.framework.deltahex.HexStatusApi;
import org.exbin.framework.editor.text.TextEncodingStatusApi;
import org.exbin.framework.gui.utils.LanguageUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;

/**
 * Hexadecimal editor status panel.
 *
 * @version 0.2.0 2017/01/05
 * @author ExBin Project (http://exbin.org)
 */
public class HexStatusPanel extends javax.swing.JPanel implements HexStatusApi, TextEncodingStatusApi {

    public static final String INSERT_EDITATION_MODE_LABEL = "INS";
    public static final String OVERWRITE_EDITATION_MODE_LABEL = "OVR";

    private EditationMode editationMode;
    private StatusControlHandler statusControlHandle;
    private final java.util.ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(HexStatusPanel.class);

    public HexStatusPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        positionPopupMenu = new javax.swing.JPopupMenu();
        positionCopyMenuItem = new javax.swing.JMenuItem();
        positionGoToMenuItem = new javax.swing.JMenuItem();
        documentSizePopupMenu = new javax.swing.JPopupMenu();
        documentSizeCopyMenuItem = new javax.swing.JMenuItem();
        memoryModePopupMenu = new javax.swing.JPopupMenu();
        deltaMemoryModeRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        ramMemoryModeRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        memoryModeButtonGroup = new javax.swing.ButtonGroup();
        memoryModeLabel = new javax.swing.JLabel();
        documentSizeLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        editationModeLabel = new javax.swing.JLabel();
        encodingLabel = new javax.swing.JLabel();

        positionPopupMenu.setName("positionPopupMenu"); // NOI18N

        positionCopyMenuItem.setText(resourceBundle.getString("positionCopyMenuItem.text")); // NOI18N
        positionCopyMenuItem.setName("positionCopyMenuItem"); // NOI18N
        positionCopyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionCopyMenuItemActionPerformed(evt);
            }
        });
        positionPopupMenu.add(positionCopyMenuItem);

        positionGoToMenuItem.setText(resourceBundle.getString("positionGoToMenuItem.text")); // NOI18N
        positionGoToMenuItem.setName("positionGoToMenuItem"); // NOI18N
        positionGoToMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionGoToMenuItemActionPerformed(evt);
            }
        });
        positionPopupMenu.add(positionGoToMenuItem);

        documentSizePopupMenu.setName("documentSizePopupMenu"); // NOI18N

        documentSizeCopyMenuItem.setText(resourceBundle.getString("documentSizeCopyMenuItem.text")); // NOI18N
        documentSizeCopyMenuItem.setName("documentSizeCopyMenuItem"); // NOI18N
        documentSizeCopyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentSizeCopyMenuItemActionPerformed(evt);
            }
        });
        documentSizePopupMenu.add(documentSizeCopyMenuItem);

        memoryModePopupMenu.setName("memoryModePopupMenu"); // NOI18N

        memoryModeButtonGroup.add(deltaMemoryModeRadioButtonMenuItem);
        deltaMemoryModeRadioButtonMenuItem.setSelected(true);
        deltaMemoryModeRadioButtonMenuItem.setText(resourceBundle.getString("HexStatusPanel.deltaMemoryModeRadioButtonMenuItem.text")); // NOI18N
        deltaMemoryModeRadioButtonMenuItem.setName("deltaMemoryModeRadioButtonMenuItem"); // NOI18N
        deltaMemoryModeRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deltaMemoryModeRadioButtonMenuItemActionPerformed(evt);
            }
        });
        memoryModePopupMenu.add(deltaMemoryModeRadioButtonMenuItem);

        memoryModeButtonGroup.add(ramMemoryModeRadioButtonMenuItem);
        ramMemoryModeRadioButtonMenuItem.setText(resourceBundle.getString("HexStatusPanel.ramMemoryModeRadioButtonMenuItem.text")); // NOI18N
        ramMemoryModeRadioButtonMenuItem.setName("ramMemoryModeRadioButtonMenuItem"); // NOI18N
        ramMemoryModeRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramMemoryModeRadioButtonMenuItemActionPerformed(evt);
            }
        });
        memoryModePopupMenu.add(ramMemoryModeRadioButtonMenuItem);

        setName("Form"); // NOI18N

        memoryModeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        memoryModeLabel.setText(resourceBundle.getString("memoryModeLabel.text")); // NOI18N
        memoryModeLabel.setToolTipText(resourceBundle.getString("memoryModeLabel.toolTipText")); // NOI18N
        memoryModeLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        memoryModeLabel.setComponentPopupMenu(memoryModePopupMenu);
        memoryModeLabel.setName("memoryModeLabel"); // NOI18N

        documentSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        documentSizeLabel.setText("0 (0)");
        documentSizeLabel.setToolTipText(resourceBundle.getString("documentSizeLabel.toolTipText")); // NOI18N
        documentSizeLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        documentSizeLabel.setComponentPopupMenu(documentSizePopupMenu);
        documentSizeLabel.setName("documentSizeLabel"); // NOI18N

        positionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        positionLabel.setText("0:0");
        positionLabel.setToolTipText(resourceBundle.getString("positionLabel.toolTipText")); // NOI18N
        positionLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        positionLabel.setComponentPopupMenu(positionPopupMenu);
        positionLabel.setName("positionLabel"); // NOI18N
        positionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                positionLabelMouseClicked(evt);
            }
        });

        editationModeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editationModeLabel.setText("OVR");
        editationModeLabel.setToolTipText(resourceBundle.getString("editationModeLabel.toolTipText")); // NOI18N
        editationModeLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        editationModeLabel.setName("editationModeLabel"); // NOI18N
        editationModeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editationModeLabelMouseClicked(evt);
            }
        });

        encodingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        encodingLabel.setText(resourceBundle.getString("encodingLabel.text")); // NOI18N
        encodingLabel.setToolTipText(resourceBundle.getString("encodingLabel.toolTipText")); // NOI18N
        encodingLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        encodingLabel.setName("encodingLabel"); // NOI18N
        encodingLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                encodingLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                encodingLabelMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                encodingLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(encodingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(documentSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(positionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(memoryModeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(editationModeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editationModeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(documentSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(memoryModeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(positionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(encodingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editationModeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editationModeLabelMouseClicked
        if (statusControlHandle != null && evt.getButton() == MouseEvent.BUTTON1) {
            if (editationMode == EditationMode.INSERT) {
                statusControlHandle.changeEditationMode(EditationMode.OVERWRITE);
            } else if (editationMode == EditationMode.OVERWRITE) {
                statusControlHandle.changeEditationMode(EditationMode.INSERT);
            }
        }
    }//GEN-LAST:event_editationModeLabelMouseClicked

    private void positionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_positionLabelMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() > 1) {
            statusControlHandle.changeCursorPosition();
        }
    }//GEN-LAST:event_positionLabelMouseClicked

    private void positionGoToMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionGoToMenuItemActionPerformed
        statusControlHandle.changeCursorPosition();
    }//GEN-LAST:event_positionGoToMenuItemActionPerformed

    private void positionCopyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionCopyMenuItemActionPerformed
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(positionLabel.getText()), null);
        } catch (IllegalStateException ex) {
            // ignore issues with clipboard
        }
    }//GEN-LAST:event_positionCopyMenuItemActionPerformed

    private void documentSizeCopyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentSizeCopyMenuItemActionPerformed
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(documentSizeLabel.getText()), null);
        } catch (IllegalStateException ex) {
            // ignore issues with clipboard
        }

    }//GEN-LAST:event_documentSizeCopyMenuItemActionPerformed

    private void encodingLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encodingLabelMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            statusControlHandle.cycleEncodings();
        } else {
            handleEncodingPopup(evt);
        }
    }//GEN-LAST:event_encodingLabelMouseClicked

    private void encodingLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encodingLabelMousePressed
        handleEncodingPopup(evt);
    }//GEN-LAST:event_encodingLabelMousePressed

    private void encodingLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_encodingLabelMouseReleased
        handleEncodingPopup(evt);
    }//GEN-LAST:event_encodingLabelMouseReleased

    private void deltaMemoryModeRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deltaMemoryModeRadioButtonMenuItemActionPerformed
        statusControlHandle.changeMemoryMode(MemoryMode.DELTA_MODE);
    }//GEN-LAST:event_deltaMemoryModeRadioButtonMenuItemActionPerformed

    private void ramMemoryModeRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramMemoryModeRadioButtonMenuItemActionPerformed
        statusControlHandle.changeMemoryMode(MemoryMode.RAM_MEMORY);
    }//GEN-LAST:event_ramMemoryModeRadioButtonMenuItemActionPerformed

    private void handleEncodingPopup(java.awt.event.MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            statusControlHandle.popupEncodingsMenu(evt);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem deltaMemoryModeRadioButtonMenuItem;
    private javax.swing.JMenuItem documentSizeCopyMenuItem;
    private javax.swing.JLabel documentSizeLabel;
    private javax.swing.JPopupMenu documentSizePopupMenu;
    private javax.swing.JLabel editationModeLabel;
    private javax.swing.JLabel encodingLabel;
    private javax.swing.ButtonGroup memoryModeButtonGroup;
    private javax.swing.JLabel memoryModeLabel;
    private javax.swing.JPopupMenu memoryModePopupMenu;
    private javax.swing.JMenuItem positionCopyMenuItem;
    private javax.swing.JMenuItem positionGoToMenuItem;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JPopupMenu positionPopupMenu;
    private javax.swing.JRadioButtonMenuItem ramMemoryModeRadioButtonMenuItem;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setCursorPosition(String cursorPosition) {
        if (cursorPosition == null || cursorPosition.isEmpty()) {
            positionLabel.setText("-");
        } else {
            positionLabel.setText(cursorPosition);
        }
    }

    @Override
    public void setCurrentDocumentSize(String documentSize) {
        if (documentSize == null) {
            documentSizeLabel.setText("0 (0)");
        } else {
            documentSizeLabel.setText(documentSize);
        }
    }

    @Override
    public String getEncoding() {
        return encodingLabel.getText();
    }

    @Override
    public void setEncoding(String encodingName) {
        encodingLabel.setText(encodingName + " \u25BE");
    }

    @Override
    public void setEditationMode(EditationMode editationMode) {
        this.editationMode = editationMode;
        switch (editationMode) {
            case INSERT: {
                editationModeLabel.setText(INSERT_EDITATION_MODE_LABEL);
                break;
            }
            case OVERWRITE: {
                editationModeLabel.setText(OVERWRITE_EDITATION_MODE_LABEL);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected editation mode " + editationMode.name());
        }
    }

    @Override
    public void setControlHandler(StatusControlHandler editationModeChange) {
        this.statusControlHandle = editationModeChange;
    }

    @Override
    public void setMemoryMode(HexStatusApi.MemoryMode memoryMode) {
        memoryModeLabel.setText(memoryMode.getDisplayChar());
        boolean enabled = memoryMode != MemoryMode.READ_ONLY;
        deltaMemoryModeRadioButtonMenuItem.setEnabled(enabled);
        ramMemoryModeRadioButtonMenuItem.setEnabled(enabled);
        if (memoryMode == MemoryMode.RAM_MEMORY) {
            ramMemoryModeRadioButtonMenuItem.setSelected(true);
        } else {
            deltaMemoryModeRadioButtonMenuItem.setSelected(true);
        }
    }
}
