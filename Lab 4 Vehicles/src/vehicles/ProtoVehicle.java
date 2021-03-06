package vehicles;

/*
 * ProtoVehicle.java
 *
 * Created on September 11, 2003, 12:17 PM
 */
/**
 *
 * @author  levenick
 */
import java.awt.*;
import java.awt.geom.Point2D;

/** A prototype Vehicle.
 *
 * Has only light sensors.
 *
 * Turns funny.
 *
 * Primitive display.
 */
public class ProtoVehicle extends AbstractVehicle {

    /** Creates a new instance of ProtoVehicle */
    public ProtoVehicle() {
        super();
    }

    /** Create a Vehicle
     * @param location Where is the vehicle
     * @param orientation Which direction is the vehicle pointed.
     * @param crossed true if the outputs are crossed
     */
    public ProtoVehicle(Point2D.Double location, double orientation, boolean crossed) {
        this();
        this.location = location;
        this.orientation = orientation;
        LightSensor theSensor = new LightSensor(crossed);
        addSensor(theSensor);
    }

  /** Paint this vehicle.  Just a circle, a line for the direction and 2 lines for the
     * sensors.
     * @param g the screen
     */
    public void paint(Graphics g) {
        int x = (int) getX();
        int y = (int) getY();
        g.setColor(Color.black);

        g.drawOval(x - size / 2, y - size / 2, size, size);

        if (mySensors.get(0).getCrossed()) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.green);
        }
        Point2D.Double left = leftSensorLocation();
        g.drawLine(x, y, (int) left.getX(), (int) left.getY());
        Point2D.Double right = rightSensorLocation();
        g.drawLine(x, y, (int) right.getX(), (int) right.getY());
    }

    /** One time step.
     *
     * Get the sensor readings; calculate the outputs.
     * @param theWorld Where to get the sensor readings.
     * @return The output with those inputs.
     */
    @Override
    public AbstractDriveOutput step(AbstractWorld theWorld) {
        double right = theWorld.getStimulusStrength(rightSensorLocation(), 0);
        double left = theWorld.getStimulusStrength(leftSensorLocation(), 0);

        if (mySensors.size() > 1) {
            System.out.println("okay... time to generalize ProtoVehicle:step to sum all the drives!!");
            assert (false);
        }

        // only one sensor...
        for (AbstractSensor nextSensor : mySensors) {
            if (nextSensor.getCrossed()) {
                return new GenericDriveOutput(right, left);  // backwards
            }
        }
        return new GenericDriveOutput(left, right);
    }

    /** Calculate where the right sensor is.
     * @return The location of the right sensor.
     */
    private Point2D.Double rightSensorLocation() {
        double dx = getSize() * Math.cos(getOrientation() - Math.PI / 4);
        double dy = -getSize() * Math.sin(getOrientation() - Math.PI / 4);
        return new Point2D.Double(getX() + dx * 2, getY() + dy * 2);
    }

    /** Calculate where the left sensor is.
     * @return The location of the left sensor
     */
    private Point2D.Double leftSensorLocation() {
        double dx = getSize() * Math.cos(getOrientation() + Math.PI / 4);
        double dy = -getSize() * Math.sin(getOrientation() + Math.PI / 4);
        return new Point2D.Double(getX() + dx * 2, getY() + dy * 2);
    }

    /** To string
     * @return la la la
     */
    public String toString() {
        return "ProtoVehicle: location=" + getLocation() + " orientation=" + getOrientation();
    }
}