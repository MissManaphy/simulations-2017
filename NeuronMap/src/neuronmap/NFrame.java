/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronmap;

import java.io.Serializable;
/**
 *
 * @author sophiaanderson
 */
public class NFrame extends javax.swing.JFrame implements Serializable {

    private final NPanel thePanel;

    /**
     * Creates new form NFrame
     */
    public NFrame() {
        initComponents();
        setTitle("Neuron Map");
        thePanel = new NPanel();
        add(thePanel);
        setBounds(100,0,1100,800);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        saveFile = new javax.swing.JMenuItem();
        loadFile = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        addNeuron = new javax.swing.JMenuItem();
        delNeuron = new javax.swing.JMenuItem();
        addPos = new javax.swing.JMenuItem();
        addNeg = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        saveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_MASK));
        saveFile.setText("Save");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        jMenu1.add(saveFile);

        loadFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.META_MASK));
        loadFile.setText("Load");
        loadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileActionPerformed(evt);
            }
        });
        jMenu1.add(loadFile);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        addNeuron.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.META_MASK));
        addNeuron.setText("Add Neuron");
        addNeuron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNeuronActionPerformed(evt);
            }
        });
        jMenu2.add(addNeuron);

        delNeuron.setText("Remove Neuron");
        delNeuron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delNeuronActionPerformed(evt);
            }
        });
        jMenu2.add(delNeuron);

        addPos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.META_MASK));
        addPos.setText("Add + Syn");
        addPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPosActionPerformed(evt);
            }
        });
        jMenu2.add(addPos);

        addNeg.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.META_MASK));
        addNeg.setText("Add - Syn");
        addNeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNegActionPerformed(evt);
            }
        });
        jMenu2.add(addNeg);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNeuronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNeuronActionPerformed
        NPanel.addaNeuron(true);
        NPanel.addAExcit(false);
        NPanel.addAInhib(false);
        NPanel.removeaNeuron(false);
    }//GEN-LAST:event_addNeuronActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        NPanel.saveFile();
        repaint();
    }//GEN-LAST:event_saveFileActionPerformed

    private void loadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileActionPerformed
        NPanel.loadFile();
        repaint();
    }//GEN-LAST:event_loadFileActionPerformed

    private void addNegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNegActionPerformed
        NPanel.addaNeuron(false);
        NPanel.addAExcit(false);
        NPanel.addAInhib(true);
        NPanel.removeaNeuron(false);
    }//GEN-LAST:event_addNegActionPerformed

    private void addPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPosActionPerformed
        NPanel.addaNeuron(false);
        NPanel.addAExcit(true);
        NPanel.addAInhib(false);
        NPanel.removeaNeuron(false);
    }//GEN-LAST:event_addPosActionPerformed

    private void delNeuronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delNeuronActionPerformed
        NPanel.addaNeuron(false);
        NPanel.addAExcit(false);
        NPanel.addAInhib(false);
        NPanel.removeaNeuron(true);
    }//GEN-LAST:event_delNeuronActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addNeg;
    private javax.swing.JMenuItem addNeuron;
    private javax.swing.JMenuItem addPos;
    private javax.swing.JMenuItem delNeuron;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem loadFile;
    private javax.swing.JMenuItem saveFile;
    // End of variables declaration//GEN-END:variables
}
