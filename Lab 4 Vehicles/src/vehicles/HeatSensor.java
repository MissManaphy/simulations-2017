package vehicles;

/*
 * LightSensor.java
 *
 * Created on September 11, 2003, 12:15 PM
 */

/**
 * A light sensor!
 */
 
public class HeatSensor extends AbstractSensor {

    public HeatSensor(boolean crossed) {
        super(crossed);
        super.setType(1);
    }

    @Override
    public String mySource() {
        return "heat";
    }
    
}
