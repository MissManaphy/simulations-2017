package vehicles;


/** The abstract class all DriveOutputs inherit from.
 */
public class AbstractDriveOutput {
    static final int MAX_OUTPUT = 15;
    
    /** Creates a new instance of AbstractDriveOutput */
    public AbstractDriveOutput() {
    }
    /** left wheel output */    
    protected double leftWheelOutput;
    /** right wheel... */    
    protected double rightWheelOutput;

    /** accessor
     * @return accessor
     */    
    public double getLeftWheelOutput() {return leftWheelOutput;}
    /** accessor
     * @return accessor
     */    
    public double getRightWheelOutput() {return rightWheelOutput;}

    /** accessor, not!  caps the output to the most torque the motor can provide
     * @param nuLeftWheelOutput the, uh, new left wheel output?
     */    
    public void setLeftWheelOutput(double nuLeftWheelOutput) {
        if (nuLeftWheelOutput>MAX_OUTPUT)
            leftWheelOutput = MAX_OUTPUT;
        else if (nuLeftWheelOutput<0)
            leftWheelOutput = 0;
        else leftWheelOutput = nuLeftWheelOutput;
    }
    /** accessor, not! caps the output
     * @param nuRightWheelOutput take a guess
     */    
    public void setRightWheelOutput(double nuRightWheelOutput) {
        if (nuRightWheelOutput>MAX_OUTPUT)
             rightWheelOutput = MAX_OUTPUT;
        else if (nuRightWheelOutput<0)
            rightWheelOutput = 0;
        else rightWheelOutput = nuRightWheelOutput;
    }
    
    /** to string?
     * @return Returns...
     */    
    public String toString() {
        String returnMe = "I am a DO: ";
        returnMe += "\tleft=" + leftWheelOutput;
        returnMe += "\tright=" + rightWheelOutput;
        return returnMe;
    } // toString()
    
}