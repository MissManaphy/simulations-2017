/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg2.lotka.volterra;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author sophiaanderson
 */
public class LVFrame extends javax.swing.JFrame {

    static double aMax = 0.01;
    static double aMin = 0.0001;

    static double bMax = 0.1;
    static double bMin = 0.0001;

    static double alphaMax = 0.00001;
    static double alphaMin = 0.000001;

    static double betaMax = 0.00001;
    static double betaMin = 0.0000001;

    static int herbMax = 1000;
    static int herbMin = 1;

    static int predMax = 100;
    static int predMin = 1;

    static double B = 0.0;
    static double A = 0.0;
    static double alpha = 0.0;
    static double beta = 0.0;
    static int herb = 0;
    static int pred = 0;

    //with added scavengers
//    static int scav = 0;
//    static double C = 0.0;
//    static double omega = 0.0;
//    
//    static int scavMin = 0;
//    static int scavMax = 0;
//    
//    static double cMax = 0.2;
//    static double cMin = 0.0001;
//    
//    static double omegaMax = 0.2;
//    static double omegaMin = 0.0001;
    static DataList list = new DataList();

    private LTGraphFrame otherFrame;
    private LTPhaseGraphFrame phaseFrame;

    /**
     * Creates new form LVFrame
     *
     */
    public LVFrame() {
        initComponents();
        setTitle("LV Simulation");

        setSize(320, 300); //sets it to "this" without an object name
        setVisible(true);
        makeTheOtherFrame();

        setSliders();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        aSlider = new javax.swing.JSlider();
        bSlider = new javax.swing.JSlider();
        alphaSlider = new javax.swing.JSlider();
        betaSlider = new javax.swing.JSlider();
        herbSlider = new javax.swing.JSlider();
        predSlider = new javax.swing.JSlider();
        aText = new javax.swing.JTextField();
        bText = new javax.swing.JTextField();
        alphaText = new javax.swing.JTextField();
        betaText = new javax.swing.JTextField();
        herbText = new javax.swing.JTextField();
        predText = new javax.swing.JTextField();
        aLabel = new javax.swing.JLabel();
        bLabel = new javax.swing.JLabel();
        alphaLabel = new javax.swing.JLabel();
        betaLabel = new javax.swing.JLabel();
        herbLabel = new javax.swing.JLabel();
        predLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("Generate");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 10, 99, 29);

        aSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                aSliderStateChanged(evt);
            }
        });
        aSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                aSliderMouseDragged(evt);
            }
        });
        aSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                aSliderMouseReleased(evt);
            }
        });
        getContentPane().add(aSlider);
        aSlider.setBounds(110, 40, 190, 29);

        bSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bSliderStateChanged(evt);
            }
        });
        getContentPane().add(bSlider);
        bSlider.setBounds(110, 80, 190, 29);

        alphaSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                alphaSliderStateChanged(evt);
            }
        });
        getContentPane().add(alphaSlider);
        alphaSlider.setBounds(110, 120, 190, 29);

        betaSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                betaSliderStateChanged(evt);
            }
        });
        getContentPane().add(betaSlider);
        betaSlider.setBounds(110, 160, 190, 29);

        herbSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                herbSliderStateChanged(evt);
            }
        });
        getContentPane().add(herbSlider);
        herbSlider.setBounds(110, 200, 190, 29);

        predSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                predSliderStateChanged(evt);
            }
        });
        getContentPane().add(predSlider);
        predSlider.setBounds(110, 240, 190, 29);

        aText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aTextActionPerformed(evt);
            }
        });
        getContentPane().add(aText);
        aText.setBounds(30, 40, 70, 26);

        bText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTextActionPerformed(evt);
            }
        });
        getContentPane().add(bText);
        bText.setBounds(30, 80, 70, 26);

        alphaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alphaTextActionPerformed(evt);
            }
        });
        getContentPane().add(alphaText);
        alphaText.setBounds(30, 120, 70, 26);

        betaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betaTextActionPerformed(evt);
            }
        });
        getContentPane().add(betaText);
        betaText.setBounds(30, 160, 70, 26);

        herbText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                herbTextActionPerformed(evt);
            }
        });
        getContentPane().add(herbText);
        herbText.setBounds(30, 200, 70, 26);

        predText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predTextActionPerformed(evt);
            }
        });
        getContentPane().add(predText);
        predText.setBounds(30, 240, 70, 26);

        aLabel.setText("A");
        getContentPane().add(aLabel);
        aLabel.setBounds(10, 50, 10, 16);

        bLabel.setText("B");
        getContentPane().add(bLabel);
        bLabel.setBounds(10, 90, 10, 16);

        alphaLabel.setText("α");
        getContentPane().add(alphaLabel);
        alphaLabel.setBounds(10, 130, 10, 16);

        betaLabel.setText("β");
        getContentPane().add(betaLabel);
        betaLabel.setBounds(10, 170, 10, 16);

        herbLabel.setText("H");
        getContentPane().add(herbLabel);
        herbLabel.setBounds(10, 210, 10, 16);

        predLabel.setText("P");
        getContentPane().add(predLabel);
        predLabel.setBounds(10, 250, 10, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void herbTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_herbTextActionPerformed
        try {
            if (Integer.parseInt(herbText.getText()) >= herbMin && Integer.parseInt(herbText.getText()) <= herbMax) {
                herb = Integer.parseInt(herbText.getText());
                herbSlider.setValue((int) (Math.round((herb / herbMax) * 100)));
                herbText.setText("" + herb);
            } else {
                herbText.requestFocus();
                herbText.selectAll();
            }
        } catch (Exception e) {
            herbText.requestFocus();
            herbText.selectAll();
        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_herbTextActionPerformed

    private void aTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aTextActionPerformed
        try {
            if (Integer.parseInt(aText.getText()) >= aMin && Integer.parseInt(aText.getText()) <= aMax) {
                A = Double.parseDouble(aText.getText());
                aSlider.setValue((int) (Math.round((A / aMax) * 100)));
                aText.setText("" + A);
            } else {
                aText.requestFocus();
                aText.selectAll();
            }
        } catch (Exception e) {
            aText.requestFocus();
            aText.selectAll();
        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_aTextActionPerformed

    private void bTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTextActionPerformed
        try {
            if (Integer.parseInt(bText.getText()) >= bMin && Integer.parseInt(bText.getText()) <= bMax) {
                B = Double.parseDouble(bText.getText());
                bSlider.setValue((int) (Math.round((B / bMax) * 100)));
                bText.setText("" + B);
            } else {
                bText.requestFocus();
                bText.selectAll();
            }
        } catch (Exception e) {
            bText.requestFocus();
            bText.selectAll();
        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_bTextActionPerformed

    private void alphaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alphaTextActionPerformed
        try {
            if (Integer.parseInt(alphaText.getText()) >= alphaMin && Integer.parseInt(alphaText.getText()) <= alphaMax) {
                alpha = Double.parseDouble(alphaText.getText());
                alphaSlider.setValue((int) (Math.round((alpha / alphaMax) * 100)));
                alphaText.setText("" + alpha);
            } else {
                alphaText.requestFocus();
                alphaText.selectAll();
            }
        } catch (Exception e) {
            alphaText.requestFocus();
            alphaText.selectAll();
        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_alphaTextActionPerformed

    private void betaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betaTextActionPerformed
        try {
            if (Integer.parseInt(betaText.getText()) >= betaMin && Integer.parseInt(betaText.getText()) <= betaMax) {
                beta = Double.parseDouble(betaText.getText());
                betaSlider.setValue((int) (Math.round((beta / betaMax) * 100)));
                betaText.setText("" + B);
            } else {
                betaText.requestFocus();
                betaText.selectAll();
            }
        } catch (Exception e) {
            betaText.requestFocus();
            betaText.selectAll();
        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_betaTextActionPerformed

    private void predTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predTextActionPerformed
        try {
            if (Integer.parseInt(predText.getText()) >= predMin && Integer.parseInt(predText.getText()) <= predMax) {
                pred = Integer.parseInt(predText.getText());
                predSlider.setValue((int) (Math.round((pred / predMax) * 100)));
                predText.setText("" + B);
            } else {
                predText.requestFocus();
                predText.selectAll();
            }
        } catch (Exception e) {
            predText.requestFocus();
            predText.selectAll();
        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_predTextActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        setVars();
        graph();
        otherFrame.setVisible(true);
        otherFrame.repaint();
        phaseFrame.setVisible(true);
        phaseFrame.repaint();
    }//GEN-LAST:event_jButton1MousePressed

    private void aSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aSliderMouseDragged
        //MISTAKE ADD
    }//GEN-LAST:event_aSliderMouseDragged

    private void aSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aSliderMouseReleased
        //MISTAKE ADD
    }//GEN-LAST:event_aSliderMouseReleased

    private void aSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_aSliderStateChanged
        if (aSlider.getValueIsAdjusting()) {
            A = ((aMax - aMin) * (aSlider.getValue() / 100.0));
            //aText.setText("" + A);
            aText.setText(String.format("%10.6f", A));
        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_aSliderStateChanged

    private void bSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bSliderStateChanged
        if (bSlider.getValueIsAdjusting()) {
            B = ((bMax - bMin) * (bSlider.getValue() / 100.0));
            //bText.setText("" + B);
            bText.setText(String.format("%10.6f", B));
        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_bSliderStateChanged

    private void alphaSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_alphaSliderStateChanged
        if (alphaSlider.getValueIsAdjusting()) {
            alpha = ((alphaMax - alphaMin) * (alphaSlider.getValue() / 100.0));
            //alphaText.setText("" + alpha);
            alphaText.setText(String.format("%10.6f", alpha));
        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_alphaSliderStateChanged

    private void betaSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_betaSliderStateChanged
        if (betaSlider.getValueIsAdjusting()) {
            beta = ((betaMax - betaMin) * (betaSlider.getValue() / 100.0));
            //betaText.setText("" + beta);
            betaText.setText(String.format("%10.6f", beta));
        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_betaSliderStateChanged

    private void herbSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_herbSliderStateChanged
        if (herbSlider.getValueIsAdjusting()) {
            herb = (int) Math.round((herbSlider.getValue() / 100.0) * (herbMax - herbMin));
            herbText.setText("" + herb);
        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_herbSliderStateChanged

    private void predSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_predSliderStateChanged
        if (predSlider.getValueIsAdjusting()) {
            pred = (int) Math.round((predSlider.getValue() / 100.0) * (predMax - predMin));
            predText.setText("" + pred);

        }
        graph();
        otherFrame.repaint();
        phaseFrame.repaint();
    }//GEN-LAST:event_predSliderStateChanged

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
            java.util.logging.Logger.getLogger(LVFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LVFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LVFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LVFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LVFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aLabel;
    private javax.swing.JSlider aSlider;
    private javax.swing.JTextField aText;
    private javax.swing.JLabel alphaLabel;
    private javax.swing.JSlider alphaSlider;
    private javax.swing.JTextField alphaText;
    private javax.swing.JLabel bLabel;
    private javax.swing.JSlider bSlider;
    private javax.swing.JTextField bText;
    private javax.swing.JLabel betaLabel;
    private javax.swing.JSlider betaSlider;
    private javax.swing.JTextField betaText;
    private javax.swing.JLabel herbLabel;
    private javax.swing.JSlider herbSlider;
    private javax.swing.JTextField herbText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel predLabel;
    private javax.swing.JSlider predSlider;
    private javax.swing.JTextField predText;
    // End of variables declaration//GEN-END:variables

    private void setSliders() {
        aSlider.setMinimum(0);
        aSlider.setMaximum(100);
        aSlider.setMinorTickSpacing(10);
        aSlider.setPaintTicks(true);

        bSlider.setMinimum(0);
        bSlider.setMaximum(100);
        bSlider.setMinorTickSpacing(10);
        bSlider.setPaintTicks(true);

        alphaSlider.setMinimum(0);
        alphaSlider.setMaximum(100);
        alphaSlider.setMinorTickSpacing(10);
        alphaSlider.setPaintTicks(true);

        betaSlider.setMinimum(0);
        betaSlider.setMaximum(100);
        betaSlider.setMinorTickSpacing(10);
        betaSlider.setPaintTicks(true);

        herbSlider.setMinimum(1);
        herbSlider.setMaximum(100);
        herbSlider.setMinorTickSpacing(10);
        herbSlider.setPaintTicks(true);

        predSlider.setMinimum(1);
        predSlider.setMaximum(100);
        predSlider.setMinorTickSpacing(10);
        predSlider.setPaintTicks(true);

    }

    //dH = aH - αHP 
    //dP = βHP - bP
    public void graph() {
        list.clear();
        setVars();

        int hp = 0;
        double fear = 0.0;
        double desperation = 0.0;
        //
        //int 

        int t = 0;
//        System.out.println("before the while loop!");
//        System.out.print("h = " + herb);
//        System.out.println("  p = " + pred);

        while (herb > 0 && pred > 0 && t++ < 10000) {
//            System.out.println("inside while loop!");
//            System.out.print("h = " + herb);
//            System.out.println("  p = " + pred);

            hp = herb * pred;
//            System.out.println("hp = " + hp);
            fear = 0.0;
            if (herb / (pred * 5) < 1) {
                fear = 1 - (1 / ((pred * 5) / herb));
            }
            if ((pred*5)/herb < 1) {
                desperation = 1 - (1/(herb/(pred*5)));
            }
//             //the fewer herbivores there are, the more scared they are, less show up
//                System.out.println("A = " + A);
//                System.out.println("herb = " + herb);
//                System.out.println("alpha = " + alpha);
//                System.out.println("pred = " + pred);
//                System.out.println("beta = " + beta);
//                System.out.println("B = " + B);
//                System.out.println("A*herb - alpha*hp = " + (A*herb - alpha*hp));

            herb += A * herb - alpha * hp * (1 - fear);
            pred += beta * hp - B*pred*(1-desperation);

//            System.out.print("h = " + herb);
//            System.out.println("  p = " + pred);

            list.add(new DataPair(herb, pred));
        }

    }

    private void makeTheOtherFrame() {
        otherFrame = new LTGraphFrame();
        phaseFrame = new LTPhaseGraphFrame();
    }

    private void setVars() {
        A = ((aMax - aMin) * (aSlider.getValue() / 100.0));
        B = ((bMax - bMin) * (bSlider.getValue() / 100.0));
        alpha = ((alphaMax - alphaMin) * (alphaSlider.getValue() / 100.0));
        beta = ((betaMax - betaMin) * (betaSlider.getValue() / 100.0));
        herb = (int) Math.round((herbSlider.getValue() / 100.0) * (herbMax - herbMin));
        pred = (int) Math.round((predSlider.getValue() / 100.0) * (predMax - predMin));
    }

}
