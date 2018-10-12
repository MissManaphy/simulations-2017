/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3.pendulum;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author sophiaanderson
 */

public class Model {

    public static final double M = 10000000;
    PendulumList list;
    private Pendulum selectedPend;
    double forces[];

    Model() {
        list = new PendulumList();
    }
    
//    void step() {
//        for (int i = 0; i < list.size(); i++) {
//            Pendulum next = list.get(i);
//            next.setForce(calcForce(next, next.getLeft()) - calcForce(next, next.getRight()));
//        }
//
//        for (Pendulum nextP : list) {
//            nextP.step();
//        }
//    }

    void step() {
        forces  = new double[list.size()*2];

        int z = 1;
        for (int i = 1; i<forces.length-1; i+=2)
        {
            //= forces[i+1]
            forces[i]  = calcForce(list.get(z), list.get(z-1));
            forces[i+1] = calcForce(list.get(z-1), list.get(z));
            
//            System.out.println("forces[i] = " + forces[i]);
//            System.out.println("forces[i+1] = " + forces[i+1]);

            z++;
        }
        
        forces[0] = forces[forces.length-1] = 0;
        
        z = 0;
        for (Pendulum pendulum : list) {
            pendulum.setForce(forces[z+1] - forces[z]);
            //pendulum.setForce(pendulum.force + forces[z+1] + forces[z]);
            z+=2;
        }
        
        for (Pendulum nextP : list) {
            nextP.step();
        }
    }

    double calcForce(Pendulum p1, Pendulum p2) {
        if (p1 == null | p2 == null) {
            return 0;
        }
        return M / distanceThing(p1, p2);
    }

    double distanceThing(Pendulum p1, Pendulum p2) {
        double d = Math.hypot(p1.xEnd() - p2.xEnd(), p1.yEnd() - p2.yEnd());
        //System.out.println("d = " + d);
        return d * d * d * d;
    }

    private void paintPends(Graphics g) {
        for (Pendulum nextPendulum : list) {
            if (nextPendulum.isSelected()) {
                g.setColor(Color.red);
            }
            nextPendulum.paint(g);
            g.setColor(Color.black);
        }
    }

    void paint(Graphics g) {
        paintPends(g);
    }

    void add(Pendulum pendulum) {
        list.add(pendulum);
    }
    
    void selectPendulum(int mouseX, int mouseY) {
        for (Pendulum nextPend : list) {
            if (nextPend.inTheBob(mouseX, mouseY)) {
                nextPend.setSelected(true);
                selectedPend = nextPend;
            }
        }
    }

    void dragPend(int mouseX, int mouseY) {
        selectedPend.drag(mouseX, mouseY);
    }

    void mouseup() {
        selectedPend.setSelected(false);
        selectedPend = null;
    }

}
