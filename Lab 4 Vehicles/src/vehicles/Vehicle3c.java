/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicles;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 *
 * @author sophiaanderson
 */
public class Vehicle3c extends LoveVehicle {
    
    public Vehicle3c(Point2D.Double location, double orientation) {
        super(location, orientation);
    }
    
    public Vehicle3c(Point2D.Double location, double orientation, AbstractSensor... sensors) {
        this(location, orientation);
        for (AbstractSensor nextX : sensors) {
            addSensor(nextX);
            //System.out.println("nextX = " + nextX);
        }
    }
    
    @Override
    public AbstractDriveOutput step(AbstractWorld theWorld) {
        double rightOutput = 0;
        double leftOutput = 0;
        
        for (AbstractSensor nextSensor : mySensors) {
            //System.out.println("nextSensor.getType() = " + nextSensor.getType());
            if (!nextSensor.getCrossed()) {
                rightOutput += theWorld.getStimulusStrength(rightSensorLocation(), nextSensor.getType());
                leftOutput += theWorld.getStimulusStrength(leftSensorLocation(), nextSensor.getType());
            } else {
                rightOutput += theWorld.getStimulusStrength(leftSensorLocation(), nextSensor.getType());
                leftOutput += theWorld.getStimulusStrength(rightSensorLocation(), nextSensor.getType());
            }
            
        }
        
        return new LoveDriveOutput(leftOutput, rightOutput);
    }
    
    private Point2D.Double rightSensorLocation() {
        double dx = getSize() * Math.cos(getOrientation() - Math.PI / 4);
        double dy = -getSize() * Math.sin(getOrientation() - Math.PI / 4);
        return new Point2D.Double(getX() + dx * 2, getY() + dy * 2);
    }

    /**
     * Calculate where the left sensor is.
     *
     * @return The location of the left sensor
     */
    private Point2D.Double leftSensorLocation() {
        double dx = getSize() * Math.cos(getOrientation() + Math.PI / 4);
        double dy = -getSize() * Math.sin(getOrientation() + Math.PI / 4);
        return new Point2D.Double(getX() + dx * 2, getY() + dy * 2);
    }
    
}
