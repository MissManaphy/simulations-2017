package lab.pkg3.pendulum;


import java.awt.Graphics;
import java.awt.Graphics2D;


class Controller extends Thread {
    boolean running = false;
    Model theModel;
    private final View theView;
    
    Controller(View thePanel) {
        this.theView = thePanel;
        theModel = new Model();
    }


    public void run() {
        for(;;) {
            if (running) {
                theModel.step();
                theView.repaint();
            }
            delay();
        }
    }
    
    void toggleRunning() {
        running = !running;
    }

    void paint(Graphics g) {
        theModel.paint(g);
//        Graphics2D g2 = (Graphics2D) g;
//        g2.translate(300, 200);
//        g2.rotate(Math.PI/2);
//        g2.translate(-300, -200);
    }

    private void delay() {
        try {
            sleep(1);
        } catch (Exception e){}
    }

    void addPend(Pendulum pendulum) {
        theModel.add(pendulum);
    }

    void selectPendulum(int mouseX, int mouseY) {
        theModel.selectPendulum(mouseX, mouseY);
    }

    void dragPend(int mouseX, int mouseY) {
        theModel.dragPend(mouseX, mouseY);
    }

    void mouseup() {
        theModel.mouseup();
    }


}