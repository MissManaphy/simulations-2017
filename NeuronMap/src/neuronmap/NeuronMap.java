/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronmap;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 *
 * @author sophiaanderson
 */
public class NeuronMap implements Serializable {

    /**
     * List of neurons
     */
    protected NeuronList theNeuronList;
    protected boolean debugging = false;

    /**
     * Creates a new instance of ProtoWorld
     */
    public NeuronMap() {
        theNeuronList = new NeuronList();
        //these four will always be connected to the switches
        addNeuron(new Neuron(new Point2D.Double(135, 165)));
        addNeuron(new Neuron(new Point2D.Double(135, 315)));
        addNeuron(new Neuron(new Point2D.Double(135, 465)));
        addNeuron(new Neuron(new Point2D.Double(135, 615)));

        //these two are always the outputs
        addNeuron(new Neuron(new Point2D.Double(820, 240)));
        addNeuron(new Neuron(new Point2D.Double(820, 540)));


//BELOW IS THE TEST CODE MAP!!! DON'T FUCK WITH IT
//        for (int a = 0; a < 10; a++) {
//            addNeuron(new Neuron(new Point2D.Double(375, 95 + 60 * a)));
//        }//for
//
//        for (int b = 0; b < 10; b++) {
//            addNeuron(new Neuron(new Point2D.Double(615, 95 + 60 * b)));
//        }//for
//        for (int c = 0; c < 4; c++) {
//            Neuron test = theNeuronList.get(c);
//            for (int d = 4; d < 14; d++) {
//                Neuron next = theNeuronList.get(d);
//                int testnum = (int) (10 * Math.random());
//                if (testnum % 2 == 0) {
//                    test.addSynapse(new ExtSyn(3.0 * Math.random(), test, next));
//                } else {
//                    test.addSynapse(new InhibSyn(3.0 * Math.random(), test, next));
//                }//else
//            }//for
//        }//for
//
//        for (int e = 6; e < 16; e++) {
//            Neuron test = theNeuronList.get(e);
//            for (int f = 14; f < 24; f++) {
//                Neuron next = theNeuronList.get(f);
//                int testnum = (int) (10 * Math.random());
//                if (testnum % 2 == 0) {
//                    test.addSynapse(new ExtSyn(3.0 * Math.random(), test, next));
//                } else {
//                    test.addSynapse(new InhibSyn(3.0 * Math.random(), test, next));
//                } //else
//            }//for
//        }//for
//
//        for (int g = 16; g < 26; g++) {
//            Neuron test = theNeuronList.get(g);
//            for (int h = 24; h < 26; h++) {
//                Neuron next = theNeuronList.get(h);
//                int testnum = (int) (10 * Math.random());
//                if (testnum % 2 == 0) {
//                    test.addSynapse(new ExtSyn(3.0 * Math.random(), test, next));
//                } else {
//                    test.addSynapse(new InhibSyn(3.0 * Math.random(), test, next));
//                } //else
//            }//for
//        }//for

    }

    public void addNeuron(Neuron nuNeuron) {
        theNeuronList.add(nuNeuron);
    }

    /**
     * Paints the world! Paints to the offscreen image, and then draws that (for
     * smoother graphics)
     *
     * @param g - the Graphics context...
     */
    public void paint(Graphics g) {
        for (Neuron neuron : theNeuronList) {
            neuron.paint(g);
        }

    }

    Neuron checkClick(int x, int y) {
        Neuron clicked = null;

        for (Neuron neuron : theNeuronList) {
            double current = neuron.getSize() / 2;

            double xdist = Math.pow((neuron.getX() - x), 2);
            double ydist = Math.pow((neuron.getY() - y), 2);
            double totalDist = Math.sqrt(xdist + ydist);

            if ((totalDist < neuron.getSize()) && (totalDist < current)) {
                clicked = neuron; //theoretically gets the neuron that was clicked the closest to
            }
        }
        return clicked;
    }

    public void step() {
        for (Neuron neuron : theNeuronList) {
            fireCheck(neuron);
        }
        for (Neuron neuron : theNeuronList) {
            delayToInput(neuron);
        }

    }

    private void fireCheck(Neuron n) {
        if (n.fireable()) {
            if (debugging) {
                System.out.println("I can fire!");
            }
            n.sendSignals();
            System.out.println(n.inputTotal);
        }
        else
        {
            for (Synapse synapse : n.mySynapses) {
                synapse.strengthenConnection(synapse.getSignalStrength()/10);
            }
        }
    }

    private void delayToInput(Neuron neuron) {
        neuron.inputTotal = 0;
        neuron.aggregator(neuron.delay);
        neuron.delay = 0;
    }

    void addInhib(Neuron up, Neuron down, double strength) {
        theNeuronList.get(theNeuronList.indexOf(up)).addSynapse(new InhibSyn(strength, up, down));
    }

    void addExcit(Neuron up, Neuron down, double strength) {
        theNeuronList.get(theNeuronList.indexOf(up)).addSynapse(new ExtSyn(strength, up, down));
    }

}
