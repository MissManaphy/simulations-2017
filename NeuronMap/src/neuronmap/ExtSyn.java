/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronmap;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author sophiaanderson
 */
public class ExtSyn extends Synapse implements Serializable {

    public ExtSyn(double strength, Neuron source, Neuron connection) {
        super.setType(true);
        super.setSignalStrength(strength);
        super.setSource(source);
        super.setConnection(connection);

    }

    @Override
    public void strengthenConnection(double x) {
        if (signalStrength < 20) {
            signalStrength += x;
            signalStrength = format(signalStrength);
        }
        if (signalStrength > 20) {
            signalStrength = 20;
        }
        
        
    }

    @Override
    public void weakenConnection(double x) {
        if (signalStrength > 0.5) {
            signalStrength -= x;
            signalStrength = format(signalStrength);
        }
        if (signalStrength < 0.5) {
            signalStrength = 0;
        }
    }

    @Override
    public void paint(Graphics g) {
        //g.setColor(Color.GREEN);
        if (source.fireable()) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.GREEN);
        }
        int x1 = (int) source.getTail().getX();
        int y1 = (int) source.getTail().getY();
        int x2 = (int) connection.getCenter().getX();
        int y2 = (int) connection.getCenter().getY();

        int midX = Math.abs(x2 - x1) / 2;
        int midY = Math.abs(y2 - y1) / 2;
        g.drawLine(x1, y1, x2, y2);
        g.setColor(Color.BLACK);
        if (y2 > y1 && x2 > x1) {
            g.drawString(Double.toString(getSignalStrength()), x1 + midX, y1 + midY);
        } else if (y2 < y1 && x2 > x1) {
            g.drawString(Double.toString(getSignalStrength()), x1 + midX, y1 - midY);
        } else if (y2 > y1 && x2 < x1) {
            g.drawString(Double.toString(getSignalStrength()), x1 - midX, y1 + midY);
        } else {
            g.drawString(Double.toString(getSignalStrength()), x1 - midX, y1 - midY);
        }
    }

}
