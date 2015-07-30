import java.awt.*;

import javax.swing.*;


/**
 * 
 * This class is used to draw lines onto the JPanel
 * 
 * Each path connecting a village is a line.
 * 
 * This class is only the visual representation of that.
 * 
 * @author Nick
 *
 */

public class Line extends JComponent {
	
	int x1, x2, y1, y2;
	
	public Line(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	// Draw the line
	public void paint(Graphics g) {
		
		final int OFFSET = 25; // to draw in middle of button
		
        System.out.println(this.x1 + ", " + this.y1 + "--" + this.x2 + ", " + this.y2);

        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.CYAN);
        
        BasicStroke smoothStroke = new BasicStroke(25, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
//        smoothStroke.
        g2.setStroke(smoothStroke);
        
        
        // draw a thick blue line
        g2.drawLine(x1 + OFFSET, y1 + OFFSET, x2 + OFFSET, y2 + OFFSET);
        
        
        // make a thin border around it
        g2.setColor(Color.black);
        BasicStroke thinStroke = new BasicStroke((float) 4.5);
        g2.setStroke(thinStroke);
        
        
        final int BORDEROFFSET = 10;
        
        // draw a line above and below to make it appear like a border
        g2.drawLine(x1 - BORDEROFFSET + OFFSET, y1 - BORDEROFFSET + OFFSET, x2 - BORDEROFFSET + OFFSET, y2 - BORDEROFFSET + OFFSET);
        g2.drawLine(x1 + BORDEROFFSET + OFFSET, y1 + BORDEROFFSET + OFFSET, x2 + BORDEROFFSET + OFFSET, y2 + BORDEROFFSET + OFFSET);
        
//        System.out.println(this.x1 + ", " + this.y1 + "--" + this.x2 + ", " + this.y2);
    }

}
