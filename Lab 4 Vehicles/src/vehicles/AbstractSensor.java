package vehicles;

/** The abstract class every Sensor inherits from. */
public abstract class AbstractSensor {
    
    protected boolean crossed;
    protected int type;
    
    public AbstractSensor(boolean crossed)
    {
        setCrossed(crossed);
    }
    
    public boolean getCrossed() {return crossed;}
    public void setCrossed(boolean c) {crossed = c;}
    
    public int getType() {return type;}
    public void setType(int t) {type = t;}
    abstract public String mySource();
}
