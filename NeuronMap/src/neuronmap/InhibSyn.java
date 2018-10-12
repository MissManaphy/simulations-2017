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
public class InhibSyn extends Synapse implements Serializable {

    public InhibSyn(double strength, Neuron source, Neuron connection) {
        super.setType(false);
        super.setSignalStrength(-strength);
        super.setSource(source);
        super.setConnection(connection);
    }
    
    @Override
    public void strengthenConnection(double x)
    {
        if (signalStrength > -20.0) {
            signalStrength -= x;
            signalStrength = format(signalStrength);
        }
        if (signalStrength < -20) {
            signalStrength = -20.0;
        }
    }
    
//    public double format(double x)
//    {
//        DecimalFormat df = new DecimalFormat("#.###");
//        df.setRoundingMode(RoundingMode.CEILING);
//        double formatted = Double.parseDouble(df.format(sStrength));
//        return formatted;
//    }
    
    @Override
    public void weakenConnection(double x)
    {
        if (signalStrength < 0) {
            signalStrength += x;
            signalStrength = format(signalStrength);
        }
        if (signalStrength > 0) {
            signalStrength = 0;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (source.fireable()) {
            g.setColor(Color.red);

        } else {
            g.setColor(Color.RED);
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
