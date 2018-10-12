package lab.pkg3.pendulum;



import java.awt.Graphics;


public class Pendulum {

    protected int xPivot;
    protected int yPivot;
    protected double theta;
    protected double vTheta;
    protected double length;
    double force;
    

    boolean selected;
    final static int SIZE = 10;
    
    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    

    public Pendulum() {
    }   //empty default constructor

    public Pendulum(int x, int y, double theta, double vTheta, double length) {   //initializing constructor
        this();   // invoke the default constructor
        this.xPivot = x;
        this.yPivot = y;
        this.theta = theta;
        this.vTheta = vTheta;
        this.length = length;
    }

    Pendulum(int x, int y, int mouseX, int mouseY) {
        this();   // invoke the default constructor
        this.xPivot = x;
        this.yPivot = y;
        vTheta = 0;
        length = Math.hypot(x-mouseX, y-mouseY);
        theta = Math.atan2(mouseX-x, mouseY-y);
    }

    void paint(Graphics g) {
        int xEnd = xEndDisplay();
        int yEnd = yEndDisplay();
        g.drawLine(xPivot, yPivot, xEnd, yEnd);
        g.fillOval(xEnd-SIZE/2, yEnd-SIZE/2, SIZE, SIZE);
    }

    int xEndDisplay () {
        return (int)(xPivot+length*Math.cos(theta+ Math.PI*3/2));
    }
    
    int yEndDisplay () {
        return (int)(yPivot-length*Math.sin(theta+ Math.PI*3/2));
    }
    
    int xEnd () {
        return (int)(xPivot+length*Math.sin(theta));
    }
    
    int yEnd () {
        return (int)(yPivot-length*Math.cos(theta));
    }
    
    double G = 10;
    double timestep = .001; 
//    double vel = 0;
//    double friction = 0.1;
    
    void step() {
        vTheta -= timestep*(force+Math.sin(theta)*G)/length;
//        v = length*vTheta;
//        friction = (1/(Math.pow(v, 2)));
//        System.out.println("friction = " + friction);
//        
        //theta += vTheta + friction;
        theta += vTheta;
    }
    
    ///1/v^2 <- friction? v = l*vtheta

    public int getX() {
        return xPivot;
    }

    public int getY() {
        return yPivot;
    }

    public double getTheta() {
        return theta;
    }

    public double getVTheta() {
        return vTheta;
    }

    public double getLength() {
        return length;
    }

    public void setX(int x) {
        this.xPivot = x;
    }

    public void setY(int y) {
        this.yPivot = y;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public void setVTheta(double vTheta) {
        this.vTheta = vTheta;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String toString() {
        String returnMe = "Pend: ";
        returnMe += "\tx=" + getX();
        returnMe += " y=" + getY();
        returnMe += " theta=" + getTheta();
        returnMe += " vTheta=" + getVTheta();
        returnMe += " length=" + getLength();
        return returnMe;
    } // toString()

    void setForce(double f) {
        force = f;
    }

    boolean inTheBob(int mouseX, int mouseY) {
        int dx = xEndDisplay() - mouseX;
        int dy = yEndDisplay() - mouseY;
        return Math.hypot(dx, dy) < SIZE/2;
    }

    void drag(int mouseX, int mouseY) {
        theta = Math.atan2(mouseX-xPivot, mouseY-yPivot);
    }

    Pendulum getLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Pendulum getRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}  // Pendulum



