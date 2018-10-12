package vehicles;

/*
 * LightSensor.java
 *
 * Created on September 11, 2003, 12:15 PM
 */

/**
 * A light sensor!
 */
 
public class LightSensor extends AbstractSensor {

    public LightSensor(boolean crossed) {
        super(crossed);
        super.setType(0);
    }

    @Override
    public String mySource() {
        return "light";
    }
    
}
