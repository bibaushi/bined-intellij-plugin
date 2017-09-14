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
package org.exbin.deltahex.intellij.panel;

import org.exbin.deltahex.*;
import org.exbin.deltahex.operation.BinaryDataCommand;
import org.exbin.deltahex.operation.BinaryDataOperationException;
import org.exbin.deltahex.operation.swing.CodeAreaUndoHandler;
import org.exbin.deltahex.operation.swing.command.InsertDataCommand;
import org.exbin.deltahex.operation.swing.command.ModifyDataCommand;
import org.exbin.deltahex.operation.undo.BinaryDataUndoUpdateListener;
import org.exbin.deltahex.swing.CodeArea;
import org.exbin.utils.binary_data.ByteArrayEditableData;

import javax.swing.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Values side panel.
 *
 * @author ExBin Project (http://exbin.org)
 * @version 0.1.5 2017/09/14
 */
public class ValuesPanel extends javax.swing.JPanel {

    private CodeArea codeArea;
    private CodeAreaUndoHandler undoHandler;
    private long dataPosition;
    private DataChangedListener dataChangedListener;
    private CaretMovedListener caretMovedListener;
    private BinaryDataUndoUpdateListener undoUpdateListener;

    private final byte[] valuesCache = new byte[8];
    private ValuesUpdater valuesUpdater = new ValuesUpdater();

    public ValuesPanel() {
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

        endianButtonGroup = new javax.swing.ButtonGroup();
        integerSignButtonGroup = new javax.swing.ButtonGroup();
        binaryLabel = new javax.swing.JLabel();
        binaryCheckBox0 = new javax.swing.JCheckBox();
        binaryCheckBox1 = new javax.swing.JCheckBox();
        binaryCheckBox2 = new javax.swing.JCheckBox();
        binaryCheckBox3 = new javax.swing.JCheckBox();
        binaryCheckBox4 = new javax.swing.JCheckBox();
        binaryCheckBox5 = new javax.swing.JCheckBox();
        binaryCheckBox6 = new javax.swing.JCheckBox();
        binaryCheckBox7 = new javax.swing.JCheckBox();
        byteLabel = new javax.swing.JLabel();
        byteTextField = new javax.swing.JTextField();
        wordLabel = new javax.swing.JLabel();
        wordTextField = new javax.swing.JTextField();
        intLabel = new javax.swing.JLabel();
        intTextField = new javax.swing.JTextField();
        longLabel = new javax.swing.JLabel();
        longTextField = new javax.swing.JTextField();
        floatLabel = new javax.swing.JLabel();
        floatTextField = new javax.swing.JTextField();
        doubleLabel = new javax.swing.JLabel();
        doubleTextField = new javax.swing.JTextField();
        characterLabel = new javax.swing.JLabel();
        characterTextField = new javax.swing.JTextField();
        bigEndianRadioButton = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        signedRadioButton = new javax.swing.JRadioButton();
        signedRadioButton1 = new javax.swing.JRadioButton();
        littleEndianRadioButton = new javax.swing.JRadioButton();

        binaryLabel.setText("Binary");

        binaryCheckBox0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binaryCheckBox0ActionPerformed(evt);
            }
        });

        binaryCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binaryCheckBox1ActionPerformed(evt);
            }
        });

        binaryCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binaryCheckBox2ActionPerformed(evt);
            }
        });

        binaryCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binaryCheckBox3ActionPerformed(evt);
            }
        });

        binaryCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binaryCheckBox4ActionPerformed(evt);
            }
        });

        binaryCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binaryCheckBox5ActionPerformed(evt);
            }
        });

        binaryCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binaryCheckBox6ActionPerformed(evt);
            }
        });

        binaryCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binaryCheckBox7ActionPerformed(evt);
            }
        });

        byteLabel.setText("Byte");

        byteTextField.setEditable(false);

        wordLabel.setText("Word");

        wordTextField.setEditable(false);

        intLabel.setText("Integer");

        intTextField.setEditable(false);

        longLabel.setText("Long");

        longTextField.setEditable(false);

        floatLabel.setText("Float");

        floatTextField.setEditable(false);

        doubleLabel.setText("Double");

        doubleTextField.setEditable(false);

        characterLabel.setText("Character");

        characterTextField.setEditable(false);

        endianButtonGroup.add(bigEndianRadioButton);
        bigEndianRadioButton.setSelected(true);
        bigEndianRadioButton.setText("BE");
        bigEndianRadioButton.setToolTipText("Big Endian");
        bigEndianRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bigEndianRadioButtonStateChanged(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        integerSignButtonGroup.add(signedRadioButton);
        signedRadioButton.setSelected(true);
        signedRadioButton.setText("Sig");
        signedRadioButton.setToolTipText("Signed Integers");
        signedRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                signedRadioButtonStateChanged(evt);
            }
        });

        integerSignButtonGroup.add(signedRadioButton1);
        signedRadioButton1.setText("Uns");
        signedRadioButton1.setToolTipText("Unsigned Integers");
        signedRadioButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                signedRadioButton1StateChanged(evt);
            }
        });

        endianButtonGroup.add(littleEndianRadioButton);
        littleEndianRadioButton.setText("LE");
        littleEndianRadioButton.setToolTipText("Little Endian");
        littleEndianRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                littleEndianRadioButtonStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(bigEndianRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(littleEndianRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(signedRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(signedRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(characterLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(characterTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(byteLabel)
                                                                        .addComponent(wordLabel)
                                                                        .addComponent(intLabel)
                                                                        .addComponent(longLabel)
                                                                        .addComponent(binaryLabel)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(binaryCheckBox0)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(binaryCheckBox1)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(binaryCheckBox2)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(binaryCheckBox3)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(binaryCheckBox4)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(binaryCheckBox5)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(binaryCheckBox6)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(binaryCheckBox7))
                                                                        .addComponent(floatLabel)
                                                                        .addComponent(doubleLabel))
                                                                .addGap(0, 2, Short.MAX_VALUE))
                                                        .addComponent(byteTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(wordTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(intTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(longTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(floatTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(doubleTextField, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(binaryLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(binaryCheckBox0)
                                        .addComponent(binaryCheckBox1)
                                        .addComponent(binaryCheckBox2)
                                        .addComponent(binaryCheckBox3)
                                        .addComponent(binaryCheckBox4)
                                        .addComponent(binaryCheckBox5)
                                        .addComponent(binaryCheckBox6)
                                        .addComponent(binaryCheckBox7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(byteLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(byteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(intLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(intTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(longLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(longTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(floatLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(floatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doubleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doubleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(characterLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(characterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(bigEndianRadioButton)
                                                                .addComponent(littleEndianRadioButton))
                                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(signedRadioButton)
                                                .addComponent(signedRadioButton1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void littleEndianRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_littleEndianRadioButtonStateChanged
        updateValues();
    }//GEN-LAST:event_littleEndianRadioButtonStateChanged

    private void bigEndianRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bigEndianRadioButtonStateChanged
        updateValues();
    }//GEN-LAST:event_bigEndianRadioButtonStateChanged

    private void signedRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_signedRadioButtonStateChanged
        updateValues();
    }//GEN-LAST:event_signedRadioButtonStateChanged

    private void signedRadioButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_signedRadioButton1StateChanged
        updateValues();
    }//GEN-LAST:event_signedRadioButton1StateChanged

    private void binaryCheckBox0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binaryCheckBox0ActionPerformed
        if (!valuesUpdater.isUpdateInProgress() && ((valuesCache[0] & 0x80) > 0 != binaryCheckBox0.isSelected())) {
            valuesCache[0] = (byte) (valuesCache[0] ^ 0x80);
            modifyValues(1);
        }
    }//GEN-LAST:event_binaryCheckBox0ActionPerformed

    private void binaryCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binaryCheckBox1ActionPerformed
        if (!valuesUpdater.isUpdateInProgress() && ((valuesCache[0] & 0x40) > 0 != binaryCheckBox1.isSelected())) {
            valuesCache[0] = (byte) (valuesCache[0] ^ 0x40);
            modifyValues(1);
        }
    }//GEN-LAST:event_binaryCheckBox1ActionPerformed

    private void binaryCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binaryCheckBox2ActionPerformed
        if (!valuesUpdater.isUpdateInProgress() && ((valuesCache[0] & 0x20) > 0 != binaryCheckBox2.isSelected())) {
            valuesCache[0] = (byte) (valuesCache[0] ^ 0x20);
            modifyValues(1);
        }
    }//GEN-LAST:event_binaryCheckBox2ActionPerformed

    private void binaryCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binaryCheckBox3ActionPerformed
        if (!valuesUpdater.isUpdateInProgress() && ((valuesCache[0] & 0x10) > 0 != binaryCheckBox3.isSelected())) {
            valuesCache[0] = (byte) (valuesCache[0] ^ 0x10);
            modifyValues(1);
        }
    }//GEN-LAST:event_binaryCheckBox3ActionPerformed

    private void binaryCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binaryCheckBox4ActionPerformed
        if (!valuesUpdater.isUpdateInProgress() && ((valuesCache[0] & 0x8) > 0 != binaryCheckBox4.isSelected())) {
            valuesCache[0] = (byte) (valuesCache[0] ^ 0x8);
            modifyValues(1);
        }
    }//GEN-LAST:event_binaryCheckBox4ActionPerformed

    private void binaryCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binaryCheckBox5ActionPerformed
        if (!valuesUpdater.isUpdateInProgress() && ((valuesCache[0] & 0x4) > 0 != binaryCheckBox5.isSelected())) {
            valuesCache[0] = (byte) (valuesCache[0] ^ 0x4);
            modifyValues(1);
        }
    }//GEN-LAST:event_binaryCheckBox5ActionPerformed

    private void binaryCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binaryCheckBox6ActionPerformed
        if (!valuesUpdater.isUpdateInProgress() && ((valuesCache[0] & 0x2) > 0 != binaryCheckBox6.isSelected())) {
            valuesCache[0] = (byte) (valuesCache[0] ^ 0x2);
            modifyValues(1);
        }
    }//GEN-LAST:event_binaryCheckBox6ActionPerformed

    private void binaryCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binaryCheckBox7ActionPerformed
        if (!valuesUpdater.isUpdateInProgress() && ((valuesCache[0] & 0x1) > 0 != binaryCheckBox7.isSelected())) {
            valuesCache[0] = (byte) (valuesCache[0] ^ 0x1);
            modifyValues(1);
        }
    }//GEN-LAST:event_binaryCheckBox7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bigEndianRadioButton;
    private javax.swing.JCheckBox binaryCheckBox0;
    private javax.swing.JCheckBox binaryCheckBox1;
    private javax.swing.JCheckBox binaryCheckBox2;
    private javax.swing.JCheckBox binaryCheckBox3;
    private javax.swing.JCheckBox binaryCheckBox4;
    private javax.swing.JCheckBox binaryCheckBox5;
    private javax.swing.JCheckBox binaryCheckBox6;
    private javax.swing.JCheckBox binaryCheckBox7;
    private javax.swing.JLabel binaryLabel;
    private javax.swing.JLabel byteLabel;
    private javax.swing.JTextField byteTextField;
    private javax.swing.JLabel characterLabel;
    private javax.swing.JTextField characterTextField;
    private javax.swing.JLabel doubleLabel;
    private javax.swing.JTextField doubleTextField;
    private javax.swing.ButtonGroup endianButtonGroup;
    private javax.swing.JLabel floatLabel;
    private javax.swing.JTextField floatTextField;
    private javax.swing.JLabel intLabel;
    private javax.swing.JTextField intTextField;
    private javax.swing.ButtonGroup integerSignButtonGroup;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton littleEndianRadioButton;
    private javax.swing.JLabel longLabel;
    private javax.swing.JTextField longTextField;
    private javax.swing.JRadioButton signedRadioButton;
    private javax.swing.JRadioButton signedRadioButton1;
    private javax.swing.JLabel wordLabel;
    private javax.swing.JTextField wordTextField;
    // End of variables declaration//GEN-END:variables

    public void setCodeArea(CodeArea codeArea, CodeAreaUndoHandler undoHandler) {
        this.codeArea = codeArea;
        this.undoHandler = undoHandler;
    }

    public void enableUpdate() {
        dataChangedListener = new DataChangedListener() {
            @Override
            public void dataChanged() {
                updateEditationMode();
                updateValues();
            }
        };
        codeArea.addDataChangedListener(dataChangedListener);
        caretMovedListener = new CaretMovedListener() {
            @Override
            public void caretMoved(CaretPosition caretPosition, Section section) {
                updateValues();
            }
        };
        codeArea.addCaretMovedListener(caretMovedListener);
        undoUpdateListener = new BinaryDataUndoUpdateListener() {
            @Override
            public void undoCommandPositionChanged() {
                updateValues();
            }

            @Override
            public void undoCommandAdded(BinaryDataCommand command) {
                updateValues();
            }
        };
        undoHandler.addUndoUpdateListener(undoUpdateListener);
    }

    public void disableUpdate() {
        codeArea.removeDataChangedListener(dataChangedListener);
        codeArea.removeCaretMovedListener(caretMovedListener);
        undoHandler.addUndoUpdateListener(undoUpdateListener);
    }

    public void updateEditationMode() {
        boolean editable = codeArea.getEditationAllowed() == EditationAllowed.ALLOWED;
        binaryCheckBox0.setEnabled(editable);
        binaryCheckBox1.setEnabled(editable);
        binaryCheckBox2.setEnabled(editable);
        binaryCheckBox3.setEnabled(editable);
        binaryCheckBox4.setEnabled(editable);
        binaryCheckBox5.setEnabled(editable);
        binaryCheckBox6.setEnabled(editable);
        binaryCheckBox7.setEnabled(editable);
    }

    public void updateValues() {
        CaretPosition caretPosition = codeArea.getCaretPosition();
        dataPosition = caretPosition.getDataPosition();
        long dataSize = codeArea.getDataSize();

        if (dataPosition < dataSize) {
            int availableData = dataSize - dataPosition > 7 ? 8 : (int) (dataSize - dataPosition);
            codeArea.getData().copyToArray(dataPosition, valuesCache, 0, availableData);
            if (availableData < 8) {
                Arrays.fill(valuesCache, availableData, 8, (byte) 0);
            }
        }

        valuesUpdater.schedule();
    }

    private void modifyValues(int bytesCount) {
        // ((EditableBinaryData) codeArea.getData()).replace(dataPosition, valuesCache, 0, bytesCount);
        ByteArrayEditableData byteArrayData = new ByteArrayEditableData();
        byteArrayData.insert(0, valuesCache, 0, bytesCount);
        long oldDataPosition = dataPosition;
        if (dataPosition == codeArea.getDataSize()) {
            InsertDataCommand insertCommand = new InsertDataCommand(codeArea, dataPosition, byteArrayData);
            try {
                undoHandler.execute(insertCommand);
            } catch (BinaryDataOperationException ex) {
                ex.printStackTrace();
            }
        } else {
            ModifyDataCommand modifyCommand = new ModifyDataCommand(codeArea, dataPosition, byteArrayData);
            try {
                undoHandler.execute(modifyCommand);
            } catch (BinaryDataOperationException ex) {
                ex.printStackTrace();
            }
        }
        codeArea.setCaretPosition(oldDataPosition);
        codeArea.repaint();
    }

    public enum ValueType {
        BINARY,
        BYTE,
        WORD,
        INTEGER,
        LONG,
        FLOAT,
        DOUBLE,
        CHARACTER
    }


    private class ValuesUpdater {

        private boolean updateInProgress = false;
        private boolean updateTerminated = false;
        private boolean scheduleUpdate = false;
        private boolean clearFields = true;

        private boolean signed;
        private boolean littleEndian;
        private byte[] values;

        private synchronized void schedule() {
            if (updateInProgress) {
                updateTerminated = true;
            }
            if (!scheduleUpdate) {
                scheduleUpdate = true;
                scheduleNextStep(ValueType.values()[0]);
            }
        }

        private void scheduleNextStep(ValueType valueType) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    updateValue(valueType);
                }
            });
        }

        public boolean isUpdateInProgress() {
            return updateInProgress;
        }

        private void updateValue(ValueType valueType) {
            if (valueType.ordinal() == 0) {
                long dataSize = codeArea.getDataSize();
                clearFields = dataPosition >= dataSize;
                littleEndian = littleEndianRadioButton.isSelected();
                signed = signedRadioButton.isSelected();
                values = valuesCache;
                updateStarted();
            }

            if (updateTerminated) {
                stopUpdate();
                return;
            }

            if (clearFields) {
                clearField(valueType);
            } else {
                updateField(valueType);
            }

            ValueType[] values = ValueType.values();
            ValueType lastValue = values[values.length - 1];
            if (valueType == lastValue) {
                stopUpdate();
            } else {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ValueType nextValue = values[valueType.ordinal() + 1];
                        updateValue(nextValue);
                    }
                });
            }
        }

        private void updateField(ValueType valueType) {
            switch (valueType) {
                case BINARY: {
                    binaryCheckBox0.setSelected((values[0] & 0x80) > 0);
                    binaryCheckBox1.setSelected((values[0] & 0x40) > 0);
                    binaryCheckBox2.setSelected((values[0] & 0x20) > 0);
                    binaryCheckBox3.setSelected((values[0] & 0x10) > 0);
                    binaryCheckBox4.setSelected((values[0] & 0x8) > 0);
                    binaryCheckBox5.setSelected((values[0] & 0x4) > 0);
                    binaryCheckBox6.setSelected((values[0] & 0x2) > 0);
                    binaryCheckBox7.setSelected((values[0] & 0x1) > 0);
                    break;
                }
                case BYTE: {
                    byteTextField.setText(String.valueOf(signed ? values[0] : values[0] & 0xff));
                    break;
                }
                case WORD: {
                    int wordValue = signed
                            ? (littleEndian
                            ? (values[0] & 0xff) | (values[1] << 8)
                            : (values[1] & 0xff) | (values[0] << 8))
                            : (littleEndian
                            ? (values[0] & 0xff) | ((values[1] & 0xff) << 8)
                            : (values[1] & 0xff) | ((values[0] & 0xff) << 8));
                    wordTextField.setText(String.valueOf(wordValue));
                    break;
                }
                case INTEGER: {
                    long intValue = signed
                            ? (littleEndian
                            ? (values[0] & 0xffl) | ((values[1] & 0xffl) << 8) | ((values[2] & 0xffl) << 16) | (values[3] << 24)
                            : (values[3] & 0xffl) | ((values[2] & 0xffl) << 8) | ((values[1] & 0xffl) << 16) | (values[0] << 24))
                            : (littleEndian
                            ? (values[0] & 0xffl) | ((values[1] & 0xffl) << 8) | ((values[2] & 0xffl) << 16) | ((values[3] & 0xffl) << 24)
                            : (values[3] & 0xffl) | ((values[2] & 0xffl) << 8) | ((values[1] & 0xffl) << 16) | ((values[0] & 0xffl) << 24));
                    intTextField.setText(String.valueOf(intValue));
                    break;
                }
                case LONG: {
                    long longValue = signed
                            ? (littleEndian
                            ? (values[0] & 0xffl) | ((values[1] & 0xffl) << 8) | ((values[2] & 0xffl) << 16) | ((values[3] & 0xffl) << 24)
                            | ((values[4] & 0xffl) << 32) | ((values[5] & 0xffl) << 40) | ((values[6] & 0xffl) << 48) | (values[7] << 56)
                            : (values[7] & 0xffl) | ((values[6] & 0xffl) << 8) | ((values[5] & 0xffl) << 16) | ((values[4] & 0xffl) << 24)
                            | ((values[3] & 0xffl) << 32) | ((values[2] & 0xffl) << 40) | ((values[1] & 0xffl) << 48) | (values[0] << 56))
                            : (littleEndian
                            ? (values[0] & 0xffl) | ((values[1] & 0xffl) << 8) | ((values[2] & 0xffl) << 16) | ((values[3] & 0xffl) << 24)
                            | ((values[4] & 0xffl) << 32) | ((values[5] & 0xffl) << 40) | ((values[6] & 0xffl) << 48)
                            : (values[7] & 0xffl) | ((values[6] & 0xffl) << 8) | ((values[5] & 0xffl) << 16) | ((values[4] & 0xffl) << 24)
                            | ((values[3] & 0xffl) << 32) | ((values[2] & 0xffl) << 40) | ((values[1] & 0xffl) << 48));
                    if (!signed) {
                        BigInteger bigInt1 = BigInteger.valueOf(values[littleEndian ? 7 : 0] & 0xffl);
                        BigInteger bigInt2 = bigInt1.shiftLeft(56);
                        BigInteger bigInt3 = bigInt2.add(BigInteger.valueOf(longValue));
                        longTextField.setText(bigInt3.toString());
                    } else {
                        longTextField.setText(String.valueOf(longValue));
                    }
                    break;
                }
                case FLOAT: {
                    ByteBuffer buffer = ByteBuffer.wrap(values);
                    floatTextField.setText(String.valueOf(buffer.getFloat()));
                    break;
                }
                case DOUBLE: {
                    ByteBuffer buffer = ByteBuffer.wrap(values);
                    doubleTextField.setText(String.valueOf(buffer.getDouble()));
                    break;
                }
                case CHARACTER: {
                    String strValue = new String(values, codeArea.getCharset());
                    if (strValue.length() > 0) {
                        characterTextField.setText(strValue.substring(0, 1));
                    } else {
                        characterTextField.setText("");
                    }
                    break;
                }
            }
        }

        private void clearField(ValueType valueType) {
            switch (valueType) {
                case BINARY: {
                    binaryCheckBox0.setSelected(false);
                    binaryCheckBox1.setSelected(false);
                    binaryCheckBox2.setSelected(false);
                    binaryCheckBox3.setSelected(false);
                    binaryCheckBox4.setSelected(false);
                    binaryCheckBox5.setSelected(false);
                    binaryCheckBox6.setSelected(false);
                    binaryCheckBox7.setSelected(false);
                    break;
                }
                case BYTE: {
                    byteTextField.setText("");
                    break;
                }
                case WORD: {
                    wordTextField.setText("");
                    break;
                }
                case INTEGER: {
                    intTextField.setText("");
                    break;
                }
                case LONG: {
                    longTextField.setText("");
                    break;
                }
                case FLOAT: {
                    floatTextField.setText("");
                    break;
                }
                case DOUBLE: {
                    doubleTextField.setText("");
                    break;
                }
                case CHARACTER: {
                    characterTextField.setText("");
                    break;
                }
            }
        }

        private synchronized void updateStarted() {
            updateInProgress = true;
            scheduleUpdate = false;
        }

        private synchronized void stopUpdate() {
            updateInProgress = false;
            updateTerminated = false;
        }
    }
}
