package vehicles;

/*
 * GenericDriveOutput.java
 *
 * Created on September 5, 2003, 10:54 AM
 */

/**
 *  A vanilla drive output
 *  Just copies the inputs to the outputs
 *  If you were implementing, say, the Love vehicle, you would subtract the inputs from 
 *  the default drive values here!
 */
public class LoveDriveOutput extends AbstractDriveOutput {
    //double maxDrive = 10;
    

    public static int getMAX_OUTPUT() {
        return MAX_OUTPUT;
    }
    
    
    /** Creates a new instance of MyDriveOutput */
    public LoveDriveOutput() {
    }
    
    public LoveDriveOutput(double left, double right) {
        this.setLeftWheelOutput(getMAX_OUTPUT() - left);
        this.setRightWheelOutput(getMAX_OUTPUT() - right);

        
    }
    
    public String toString() {
        return "myD" + super.toString();
    }
}
