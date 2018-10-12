/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronmap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 *
 * @author sophiaanderson
 */
public class Neuron implements Serializable {

    /*
    What can a Neuron do
    - recieve signals every time step 
    -place it, delete it, move it
    -connections to synapses 
    - send signals from synapses 
    - get singals from synapses
     */
    /**
     * Where is the Neuron
     */
    protected Point2D.Double center;
    protected boolean debugging = false;
    protected double delay = 0;

    /**
     * The list of synapses the neuron has
     */
    protected SynapseList mySynapses;

    /**
     * The current input state of the neuron
     */
    protected double inputTotal = 0;

    /**
     * The base size for neurons
     */
    protected int size = 40;

    /**
     * The base length for the tails
     */
    protected int tail = 80;

    /**
     * The endpoint for the tails (used for drawing the other connections)
     */
    protected Point2D.Double tailEnd;

    public Neuron() {
        mySynapses = new SynapseList();
    }

    public Neuron(Point2D.Double place) {
        this();
        center = place;
        tailEnd = new Point2D.Double(center.getX() + size / 2 + tail, center.getY());
        if (debugging) {
            System.out.println("I've made a neuron!");
        }
    }

    /**
     * Adds a synaptic connection to this neuron
     *
     * @param s The synapse to add
     */
    public void addSynapse(Synapse s) {
        mySynapses.add(s);
    }

    public void deleteSynapse(Synapse s) {
        if (mySynapses.contains(s)) {
            mySynapses.remove(s);
        }
    }

    public Point2D.Double getLocation() {
        return center;
    }

    public double getX() {
        return center.getX();
    }

    public double getY() {
        return center.getY();
    }

    public double getSize() {
        return size;
    }

    public Point2D.Double getCenter() {
        return center;
    }

    public Point2D.Double getTail() {
        return tailEnd;
    }

    public void setLocation(Point2D.Double nuLocation) {
        center = nuLocation;
    }

    public void aggregator(double input) {
        inputTotal += input;
        if (debugging) {
            System.out.println("Inputs have been aggregated!");
        }
    }

    public void delay(double input) {
        delay += input;
        if (debugging) {
            System.out.println("An input has been recorded!");
        }
    }

    public boolean fireable() {
        if (debugging) {
            System.out.println("Someone checked to see if I could fire!");
        }
        if (inputTotal > 0) {

            return true;
        } else {
            return false;
        }
    }

    public void paint(Graphics g) {
        int x = (int) getX();
        int y = (int) getY();

        if (fireable()) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.BLUE);
        }

        //g.setColor(Color.BLUE);
        //System.out.println("Neuron got drawn");
        g.drawOval(x - size / 2, y - size / 2, size, size);
        g.drawLine(x + size / 2, y, (int) tailEnd.getX(), (int) tailEnd.getY());
        for (Synapse mySynapse : mySynapses) {
            mySynapse.paint(g);
        }
    }

    void sendSignals() {
        if (debugging) {
            System.out.println("We're triggering the synapses!");
        }
        for (Synapse mySynapse : mySynapses) {
            mySynapse.getConnection().delay(mySynapse.getSignalStrength());
            mySynapse.weakenConnection(mySynapse.getSignalStrength() / 5);
            mySynapse.strengthenConnection(mySynapse.getSignalStrength()/5);
        }
        inputTotal = 0;
        if (debugging) {
            System.out.println("They've interacted with their connections!");
        }
    }

}
