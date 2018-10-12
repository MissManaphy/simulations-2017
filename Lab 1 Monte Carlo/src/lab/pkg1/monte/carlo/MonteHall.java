/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg1.monte.carlo;

/**
 *
 * @author sophiaanderson
 */
public class MonteHall extends javax.swing.JFrame {

    /**
     * Creates new form MonteCarlo
     */
    static int simulationRuns;
    static int playerDoor;
    static int revealDoor;
    static int prizeDoor;
    static boolean doors[] = {false, false, false};
    static boolean single;
    
    boolean choice; 

    static int wins;
    static boolean chatter;
    static boolean play;

    static Contestant person;

    public MonteHall() {
        initComponents();
//        fillbox();
//        setTitle("Monte Carlo Game");
//
//        setSize(542, 410); //sets it to "this" without an object name
//        setVisible(true);
//        numberField.setVisible(false);
//        door1.setVisible(false);
//        door2.setVisible(false);
//        door3.setVisible(false);
//        toSwitch.setVisible(false);
//        toStay.setVisible(false);
        reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        theTA = new javax.swing.JTextArea();
        title = new javax.swing.JLabel();
        door1 = new javax.swing.JButton();
        door2 = new javax.swing.JButton();
        door3 = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        singleRun = new javax.swing.JButton();
        multiRun = new javax.swing.JButton();
        toSwitch = new javax.swing.JButton();
        toStay = new javax.swing.JButton();
        numberField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        theTA.setColumns(20);
        theTA.setRows(5);
        jScrollPane1.setViewportView(theTA);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 210, 520, 170);

        title.setText("Monte Carlo Door Game");
        getContentPane().add(title);
        title.setBounds(200, 16, 150, 20);

        door1.setText("Door 1");
        door1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                door1MousePressed(evt);
            }
        });
        getContentPane().add(door1);
        door1.setBounds(230, 60, 87, 29);

        door2.setText("Door 2");
        door2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                door2MousePressed(evt);
            }
        });
        getContentPane().add(door2);
        door2.setBounds(230, 90, 87, 29);

        door3.setText("Door 3");
        door3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                door3MousePressed(evt);
            }
        });
        getContentPane().add(door3);
        door3.setBounds(230, 120, 87, 29);

        reset.setText("Reset");
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                resetMousePressed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(450, 10, 60, 30);

        singleRun.setText("Single Run");
        singleRun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                singleRunMousePressed(evt);
            }
        });
        getContentPane().add(singleRun);
        singleRun.setBounds(10, 10, 100, 30);

        multiRun.setText("Multi Run");
        multiRun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                multiRunMousePressed(evt);
            }
        });
        getContentPane().add(multiRun);
        multiRun.setBounds(10, 50, 100, 29);

        toSwitch.setText("Switch");
        toSwitch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toSwitchMousePressed(evt);
            }
        });
        getContentPane().add(toSwitch);
        toSwitch.setBounds(130, 170, 85, 29);

        toStay.setText("Stay");
        toStay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toStayMousePressed(evt);
            }
        });
        getContentPane().add(toStay);
        toStay.setBounds(320, 170, 75, 29);

        numberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberFieldActionPerformed(evt);
            }
        });
        getContentPane().add(numberField);
        numberField.setBounds(20, 90, 80, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void door1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_door1MousePressed
        playerDoor = 0;
        revealDoor();
    }//GEN-LAST:event_door1MousePressed

    private void door2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_door2MousePressed
        playerDoor = 1;
        revealDoor();
    }//GEN-LAST:event_door2MousePressed

    private void door3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_door3MousePressed
        playerDoor = 2;
        revealDoor();
    }//GEN-LAST:event_door3MousePressed

    private void toSwitchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toSwitchMousePressed
        choice = true;
        person = new Switcher();
        toStay.setEnabled(false);
        toSwitch.setEnabled(false);
        door1.setEnabled(false);
        door2.setEnabled(false);
        door3.setEnabled(false);
        endGame();
    }//GEN-LAST:event_toSwitchMousePressed

    private void toStayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toStayMousePressed
        choice = false;
        person = new Stayer();
        toStay.setEnabled(false);
        toSwitch.setEnabled(false);
        door1.setEnabled(false);
        door2.setEnabled(false);
        door3.setEnabled(false);
        endGame();
    }//GEN-LAST:event_toStayMousePressed

    private void resetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMousePressed
        reset();
    }//GEN-LAST:event_resetMousePressed

    private void singleRunMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singleRunMousePressed
        single = true;
        multiRun.setVisible(false);
        singleRun.setEnabled(false);

        playGame();
    }//GEN-LAST:event_singleRunMousePressed

    private void multiRunMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiRunMousePressed
        single = false;
        singleRun.setVisible(false);
        numberField.setVisible(true);
        theTA.setText("Enter a number of runs to play");
    }//GEN-LAST:event_multiRunMousePressed

    private void numberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberFieldActionPerformed

        if (sanitize(numberField.getText())) {
            numberField.setVisible(false);
            multiRun.setEnabled(false);
        } else {
            numberField.requestFocus();
            numberField.selectAll();
        }
    }//GEN-LAST:event_numberFieldActionPerformed

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
            java.util.logging.Logger.getLogger(MonteHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonteHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonteHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonteHall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonteHall().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton door1;
    private javax.swing.JButton door2;
    private javax.swing.JButton door3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton multiRun;
    private javax.swing.JTextField numberField;
    private javax.swing.JButton reset;
    private javax.swing.JButton singleRun;
    private javax.swing.JTextArea theTA;
    private javax.swing.JLabel title;
    private javax.swing.JButton toStay;
    private javax.swing.JButton toSwitch;
    // End of variables declaration//GEN-END:variables

    private void fillbox() {
        theTA.removeAll();
    }
    // initalized global variables

    private void welcomeMessage() {
        theTA.setText("Welcome to this Monte Hall simulation!\n"
                + "I'd like to introduce you to some statistical theory\n"
                + "You know when you come across those 3 door dillemas\n"
                + "Where there's a prize behind one, but you don't know where it is?\n"
                + "Which one should you choose? Should you switch from your first \ndoor choice when given the opporutinity?"
                + " Well, here's where you can \ntest this model "
                + "without any concern about losing out \non a fabulous prize.\n\n");

    }

    private void prizeRandomizer() {
        int random;
        random = (int) Math.floor(Math.random() * 100);
        prizeDoor = random % 3;
        doors[prizeDoor] = true;

    }

    private void doorReset() {
        doors[prizeDoor] = false;

    }

    private void playGame() {
        welcomeMessage();
        prizeRandomizer();
        chooseDoor();

    }

    private void chooseContestant() {
        theTA.setText("Would you like your contestant to constantly \n"
                + "SWITCH (1) or STAY (2) with their guesses?");
        toStay.setVisible(true);
        toSwitch.setVisible(true);
    }

    private boolean sanitize(String number) {
        String numbers[] = number.split("(?:[^0-9])+", 1);

        try {
            if (Integer.parseInt(numbers[0]) > 0) {
                simulationRuns = Integer.parseInt(numbers[0]);
                chooseContestant();
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("You didn't enter any readable numbers.\n");
        } catch (Exception e) {
            System.out.println("Something went wrong. Try again.");
        }
        return false;
    }

    private void chooseDoor() {
        theTA.append("\nWhat door do you want to choose? 1, 2, or 3?");

        door1.setVisible(true);
        door2.setVisible(true);
        door3.setVisible(true);
    }

    private void revealDoor() {
        do {
            revealDoor = (int) Math.floor(Math.random() * 9) % 3;
        } while ((revealDoor == playerDoor) | (doors[revealDoor] == true));

        switch (revealDoor) {
            case 0: {
                door1.setEnabled(false);
                break;
            }
            case 1: {
                door2.setEnabled(false);
                break;
            }
            case 2: {
                door3.setEnabled(false);
                break;
            }
        }

        theTA.setText("Now look! There's nothing behind door " + (revealDoor + 1)
                + ". Do you want to switch or stay?");
        toStay.setVisible(true);
        toSwitch.setVisible(true);
    }

    private void endGame() {
        if (single) {
            endGameSingle();
        } else {
            endGameMulti();
        }
    }

    private void endGameSingle() {
        if (doors[playerDoor]) {
            theTA.setText("Congrats! You opened door " + (playerDoor + 1) + " and won a nice prize!\n\n"
                    + "Press the reset button to play again.");

        } else {
            theTA.setText("Too bad! You opened door " + (playerDoor + 1) + " and are staring into the void!\n\n"
                    + "Press the reset button to play again.");

        }
    }

    private void endGameMulti() {
        // if its many games, run through them all 
        for (int i = 0; i < simulationRuns; i++) {
            int door = 0;
            do {
                revealDoor = (int) Math.floor(Math.random() * 9) % 3;
            } while ((revealDoor == playerDoor) | (doors[revealDoor] == true));

            if (person.change()) {
                while (door == playerDoor | door == revealDoor) {
                    door = (int) Math.floor(Math.random() * 9) % 3;
                }
            }//if
            else {
                door = playerDoor;
            }

            if (doors[door]) {
                wins++;
            }
            doorReset();
            prizeRandomizer();
            playerDoor = person.guess();
        }//for

        theTA.setText("Congratulations! You won " + wins + "/" + simulationRuns + " times. \n"
                + "Press the reset button to play again.");

    }

    private void reset() {
        //initComponents();
        fillbox();
        setTitle("Monte Hall Game");

        setSize(542, 410); //sets it to "this" without an object name
        setVisible(true);
        numberField.setVisible(false);
        numberField.setEnabled(true);

        door1.setVisible(false);
        door1.setEnabled(true);

        door2.setVisible(false);
        door2.setEnabled(true);

        door3.setVisible(false);
        door3.setEnabled(true);

        toSwitch.setVisible(false);
        toSwitch.setEnabled(true);

        toStay.setVisible(false);
        toStay.setEnabled(true);

        theTA.setText("");

        multiRun.setVisible(true);
        multiRun.setEnabled(true);

        singleRun.setVisible(true);
        singleRun.setEnabled(true);

        simulationRuns = 0;
        playerDoor = 0;
        revealDoor = 0;
        prizeDoor = 0;
        doors[0] = false;
        doors[1] = false;
        doors[2] = false;

        single = false;

        choice = false;

        wins = 0;
        chatter = false;
        play = false;

    }
}
