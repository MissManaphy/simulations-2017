package vehicles;

/*
 * Heatsource.java
 */

import java.awt.geom.Point2D;
import java.awt.*;

/**
 * The source of heat
 */
public class HeatSource extends AbstractSource {
    int width=16;
    int offset = width/2;
    
    /** Creates a new instance of HeatSource */
    public HeatSource() {
    }
    
    public HeatSource(Point2D.Double location, double strength) {
        setIntensity(strength);
        setLocation(location);
        setType(1);
    }
    
    /** 
     * Draws a little rectangle to stand for a heater.
     */
    public void paint(Graphics g) {
        int x = (int)getLocation().getX();
        int y = (int)getLocation().getY();
        g.setColor(new Color(200, 150, 200));
        g.fillRect(x-offset, y-offset, width, width);
    }
    
}
