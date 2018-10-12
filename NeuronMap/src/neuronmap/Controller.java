package neuronmap;

/*
 * Controller.java
 *
 * Created on September 11, 2003, 11:13 AM
 * Modified most recently 2/20/18 to clean things up and add comments
 */

import java.awt.*;

/** Runs the World, Threaded so the animation works. */
public class Controller extends Thread {
    
    NPanel thePanel;   // the View!
    int stepsToTake;
    NeuronMap theMap;  // the Model!
    int delay = 500; 

    public Controller(NPanel p) {
        thePanel = p;
        theMap = new NeuronMap();
    }
    
    /** Paint the World (by passing the buck to theWorld)
     * @param g The screen
     */    
    public void paint(Graphics g) {
        theMap.paint(g);
    }
    
    /** Add one to the number of steps to take. */    
    public void incSteps() {stepsToTake++;}
    
    /** Forever loop, controlled by the variable stepsToTake */    
    public void run() {
        System.out.println("running");
        for (;;) {
            if (stepsToTake > 0) {      // if we should take a step, do so
                stepsToTake--;
                step();
            }
            delay(delay);                  // always delay, to avoid spin-lock
         }
   }
    
    /** Does one step -- step, repaint, pause */    
    private void step() {
        if (thePanel.trait1val && stepsToTake%2 == 0) {
            Neuron conn1 = theMap.theNeuronList.get(0);
            conn1.delay(1.0);
        }
        if (thePanel.trait2val&& stepsToTake%2 == 0) {
            Neuron conn2 = theMap.theNeuronList.get(1);
            conn2.delay(1.0);
        }
        if (thePanel.trait3val&& stepsToTake%2 == 0) {
            Neuron conn3 = theMap.theNeuronList.get(2);
            conn3.delay(1.0);
        }
        if (thePanel.trait4val&& stepsToTake%2 == 0) {
            Neuron conn4 = theMap.theNeuronList.get(3);
            conn4.delay(1.0);
        }
        theMap.step();
        thePanel.repaint();
     }
    
    /** Waits a bit
     * @param t num milliseconds to pause
     *
     */    
    
    public void setDelay(int de)
    {
        delay = de;
    }
    private void delay(int t) {
        try {
            sleep(t);  
        } catch (Exception e) {}
    }

    public NPanel getPanel() {
        return thePanel;
    }

    void stopIt() {
        stepsToTake = 0;
        for (Neuron neuron : theMap.theNeuronList) {
            neuron.inputTotal = 0; 
            
        }
    }
    
    


}
