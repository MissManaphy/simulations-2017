package vehicles;

/*
 * AbstractVehicle.java
 *
 * Created on September 10, 2003, 1:38 PM
 */

import java.awt.*;
import java.awt.geom.Point2D;
/** The abstract class every Vehicle inherits from.
 *
 *  */
public abstract class AbstractVehicle {
    
    /** Where is the Vehicle */    
    protected Point2D.Double location;        
    
    /** Which direction is it pointed (in radians) */    
    protected double orientation;    
    
    /** Not used currently */    
    protected double vX;
    protected double vY;
    
    /** The list of Sensors the vehicle has */    
    protected SensorList mySensors;   
   
    
    /** How big is the vehicle; used for display and sensor location. */    
    protected int size;
    final static int MAX_SIZE=20;
    /** Creates a new instance of AbstractVehicle */
    public AbstractVehicle() {
        mySensors = new SensorList(); 
        size = MAX_SIZE + (int) ((Math.random()-0.9)*MAX_SIZE);
    }
        
    /** Adds a sensor to this vehicle
     * @param s The sensor to add
     */    
    public void addSensor(AbstractSensor s) {
        mySensors.add(s);
    }
    
    /** Get sensor readings, calculate and return the resulting wheel drives.
     * @param theWorld To ask for sensor readings.
     * @return The output to the wheel motors.
     */    
    abstract public AbstractDriveOutput step(AbstractWorld theWorld);
       
    abstract public void paint(Graphics g);
    
    /** Accessor
     * @return The orientation!
     */    
    public double getOrientation() {return orientation;}
    
    /** Accessors
     * @return the location!
     */    
    public Point2D.Double getLocation() {return location;}
    public double getX() {return location.getX();}
    public double getY() {return location.getY();}
    
    public double getvX() {return vX;}
    public double getvY() {return vY;}
    
    public void setvX(double newvX) {vX = newvX;}
    public void setvY(double newvY) {vY = newvY;}
    
    /** Accessor
     * @param nuOrientation The new orientation
     */    
    public void setOrientation(double nuOrientation) {orientation = nuOrientation;}
    /** Accessor
     * @param nuLocation The new location
     */    
    public void setLocation(Point2D.Double nuLocation) {location = nuLocation;}
    
    /** Accessor
     * @return The size
     */    
    public int getSize() {return size;}
}