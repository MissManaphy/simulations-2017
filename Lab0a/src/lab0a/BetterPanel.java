package lab0a;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

/**
 *
 * @author levenick Jan 18, 2018 3:25:55 PM
 */
public class BetterPanel extends javax.swing.JPanel {

    public BetterPanel() {
        initComponents();
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.yellow, 5),
                "Some Title", TitledBorder.CENTER, 0));
        setLayout(null);
        setVisible(true);
    }

    int left, top, rows, right, bottom, cols;

    public void paintComponent(Graphics g) {
        if (g == null || list == null) {
            return;
        }
        //g.fillOval(100, 100, 100, 100);
        //super.paintComponent(g);
        // here's how I started paintComponent...
        Rectangle r = this.getVisibleRect();
        left = r.x + 20;
        top = r.y + 20;
        rows = (list.length / cols) + 1;
        System.out.println("rows = " + rows);

        right = r.width - left;
        bottom = r.height - top;

        drawGrid(g);
        drawValues(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
int xText, yText;

    private void drawValues(Graphics g) {
        if (list == null) {
            System.out.println("hey! the list is null");
            return;
        }
        
        int end = list.length;
        int place = 0;
        String nextS = list[place];
        
        //System.out.println("nextS = " + nextS);
        yText = left+20;
        for(int y = 0; y < rows; y++)
        {
            xText = top+20;
            for (int z = 0; z < cols; z++)
            {
                if(place < end)
                {
                    nextS = list[place];
                    place++;
                }
                else nextS = "";
                g.drawString(nextS, xText, yText);
                xText += ((right-left)/cols);
            }
            yText += ((bottom-top)/rows);
        }
    }

    private void drawGrid(Graphics g) {
        
        for (int d = 0; d <= rows; d++)
        {
            g.drawLine(left, top + ((bottom-top)/rows)*d , right, top + ((bottom-top)/rows)*d);
             
        }
        
        for (int v = 0; v <= rows+1; v++)
        {
            g.drawLine(left + ((right-left)/cols)*v, top , left + ((right-left)/cols)*v, bottom);
             
        }

    }

    String[] list;

    void go(int cols, String text) {
//        System.out.println("text = " + text);
//        System.out.println("cols = " + cols);
        this.cols = cols;
        list = text.split("\\s+");
        for (String s : list) {
            System.out.println("s = " + s);
        }
    }

}
