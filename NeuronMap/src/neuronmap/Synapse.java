/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronmap;

import java.awt.Graphics;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author sophiaanderson
 */
public abstract class Synapse implements Serializable{
    
    /**
     * Synapse will have a location in space, maybe?
     */

    protected Neuron source;
    protected Neuron connection;
    
    protected boolean type;
    protected double signalStrength;
    protected boolean fired; 
            
    
    public Neuron getConnection() {
        return connection;
    }

    public void setConnection(Neuron n) {
        connection = n;
    }
    
    public boolean getFired() {
        return fired;
    }

    public void setFired(boolean f) {
        fired = f;
    }
    
    public Neuron getSource() {
        return source;
    }

    public void setSource(Neuron n) {
        source = n;
    }
    
    public void setType(boolean signal)
    {
        type = signal;
    }
    
    public boolean getType()
    {
        return type;
    }
    
    public void setSignalStrength(double signal)
    {
        signalStrength = signal;
    }
    
    public double getSignalStrength()
    {
        return signalStrength;
    }
    
    public void weakenConnection(double x)
    {}
    public void strengthenConnection(double x)
    {}
    
    public double format(double x)
    {
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
        double formatted = Double.parseDouble(df.format(x));
        System.out.println(formatted);
        return formatted;
    }
            
            
    
    /**
     * Displays the Source
     */
    abstract public void paint(Graphics g);
    
}
