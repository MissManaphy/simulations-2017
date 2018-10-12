package vehicles;

/*
 * ProtoWorld.java
 *
 * Created on September 11, 2003, 11:59 AM
 */
import java.awt.*;
import java.awt.geom.Point2D;

/**
 * A prototype world for testing purposes
 *
 * @author levenick
 */
public class ProtoWorld extends AbstractWorld {

    boolean debugging = false;

    int intensity;
    double SCALE = .01;

    /**
     * Creates a new instance of ProtoWorld
     */
    public ProtoWorld() {
        for (int x = 0; x < 1000; x++) {
            Point2D.Double p = new Point2D.Double(200 + rand(300), 200 + rand(300));
            double direction = 50 - rand(100);
            
            addVehicle(new Vehicle3c(p, direction, new LightSensor(true), new HeatSensor(true)));  // all 4 at the same place! Facing the same way.
            addVehicle(new Vehicle3c(p, direction, new LightSensor(false), new HeatSensor(false)));
            addVehicle(new Vehicle3c(p, direction, new LightSensor(true), new HeatSensor(false)));
            addVehicle(new Vehicle3c(p, direction, new LightSensor(false), new HeatSensor(true)));
            
            
            
            
          /////******* vehicle for proving that heat versus light works
//            addVehicle(new Vehicle3c(new Point2D.Double(375, 500), Math.PI/2, new HeatSensor(false), new LightSensor(true)));

////            Original vehicles
//            //addVehicle(new ProtoVehicle(new Point2D.Double(400, 800), Math.PI/2, randBool()));
//            addVehicle(new ProtoVehicle(new Point2D.Double(400 + rand(50), 400 + rand(50)), Math.random() * (2 * Math.PI), randBool()));
//            addVehicle(new LoveVehicle(new Point2D.Double(400 + rand(50), 400 + rand(50)), Math.random() * (2 * Math.PI), randBool()));
        }


////*******sources for proving that heat versus light works
//        addSource(new LightSource(new Point2D.Double(250, 200), 186700));
//        addSource(new HeatSource(new Point2D.Double(500, 200), 186700));
    
     
        
        addSource(new LightSource(new Point2D.Double(50, 50), 8770));
        addSource(new LightSource(new Point2D.Double(700, 600), 6650));
//        addSource(new LightSource(new Point2D.Double(500, 500), 18670));
//        addSource(new LightSource(new Point2D.Double(567, 345), 186700)); 
        
//        addSource(new HeatSource(new Point2D.Double(500, 300), 8770));
//        addSource(new HeatSource(new Point2D.Double(300, 500), 6650));
        addSource(new HeatSource(new Point2D.Double(600, 50), 18670));
        addSource(new HeatSource(new Point2D.Double(50, 600), 186700));   // so hot!!

    }

    int rand(int max) {
        return (int) (max * Math.random());
    }

    private boolean randBool() {
        return Math.random() < 0.5;         // 9 times in 10 is true
    }

    @Override
    public void setIntensity(int intense) {
        intensity = intense;
    }

    public void sourceClick(int x, int y) {
        addSource(new LightSource(new Point2D.Double(x, y), intensity));
    }

    public void addSource(AbstractSource nuSource) {
        theSourceList.add(nuSource);
    }

    /**
     * Adds a vehicle to the world
     *
     * @param nuVehicle the vehicle to add
     */
    public void addVehicle(AbstractVehicle nuVehicle) {
        theVehicleList.add(nuVehicle);
    }

    /**
     * Returns the light stimulus strength
     *
     * @param where the point to return the brightness at
     */
//    public double getStimulusStrength(Point2D.Double where) {
//        double sum = 0;
//
//        for (AbstractSource nextHeatSource : theSourceList) {
//            double d = where.distance(nextHeatSource.getLocation());
//            sum += nextHeatSource.getIntensity() / (d * d);
//        } //for
//        
//        return sum;
//    }

    public double getStimulusStrength(Point2D.Double where, int x) {
        double sum = 0;

        switch (x) {
            case 0: // for light sources
                for (AbstractSource nextLightSource : theSourceList) {
                    if (nextLightSource.getType() == 0) {
                        double d = where.distance(nextLightSource.getLocation());
                        sum += nextLightSource.getIntensity() / (d * d);
                        //System.out.println("I got a light source!!");
                    }//if 
                } //for
                break;
            case 1: // for heat sources
                for (AbstractSource nextHeatSource : theSourceList) {
                    if (nextHeatSource.getType() == 1) {
                        double d = where.distance(nextHeatSource.getLocation());
                        sum += nextHeatSource.getIntensity() / (d * d);
                        //System.out.println("I got a heat source!");
                    }//if 
                } //for
                break;
        } //switch
        return sum;
    }

    /**
     * Simulates one step by sending step to each Vehicle (this calculates the
     * force delivered to each wheel (and is returned in theOutput).
     *
     * Then, moveIt is invoked to calculate how far, and in what direction the
     * Vehicle moves... this is because if it were in mud, or going uphill it
     * would move less than if it were in space... or so the author apparently
     * thought...
     */
    public void step() {
        for (AbstractVehicle nextVehicle : theVehicleList) {
            AbstractDriveOutput theOutput = nextVehicle.step(this);
            moveIt(nextVehicle, theOutput);
        }
    }

    private void moveIt(AbstractVehicle theVehicle, AbstractDriveOutput theOutput) {
        if (debugging) {
            System.out.println("Applying " + theOutput + " to  " + theVehicle);
        }

        ////////THE NORMAL CODE///////
        double leftOutput = theOutput.getLeftWheelOutput();
        double rightOutput = theOutput.getRightWheelOutput();

        double direction = theVehicle.getOrientation();

        double distance = (leftOutput + rightOutput) / 2;

        double dx = distance * Math.cos(direction);
        double dy = -distance * Math.sin(direction);
        double x = theVehicle.getLocation().getX();
        double y = theVehicle.getLocation().getY();

        theVehicle.setLocation(new Point2D.Double(x + dx, y + dy));

        //instead vx += vy+=
        double deltaDirection = ((rightOutput - leftOutput) / theVehicle.getSize()) * (Math.PI / 8);
        theVehicle.setOrientation(direction + deltaDirection);
        ////////THE NORMAL CODE///////
    }

    public String toString() {
        return "ProtoWorld";
    }

    /**
     * Paints the world! Paints to the offscreen image, and then draws that (for
     * smoother graphics)
     *
     * @param g - the Graphics context...
     */
    public void paint(Graphics g) {
        for (AbstractSource nextSource : theSourceList) {
            nextSource.paint(g);
        }
        for (AbstractVehicle nextVehicle : theVehicleList) {
            nextVehicle.paint(g);
        }
    }

    @Override
    void vehicleClick(int x, int y, double size, int choice) {
        switch (choice) {
            case 0: //fear
                addVehicle(new ProtoVehicle(new Point2D.Double(x, y), size, false));
                break; // not generalized for multiple sensors
            case 1: //anger
                addVehicle(new ProtoVehicle(new Point2D.Double(x, y), size, true));
                break; // not generalized for multiple sensors
            case 2: // explorer
                addVehicle(new LoveVehicle(new Point2D.Double(x, y), size, false));
                break;
            case 3: //love
                addVehicle(new LoveVehicle(new Point2D.Double(x, y), size, true));
                break;
        }
    }

}
