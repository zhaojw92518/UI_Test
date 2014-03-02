import java.awt.Graphics;

import javax.swing.JPanel;


public class CLinePanel extends JPanel {
	private int x1, y1, x2, y2;
	
	public CLinePanel(int in_x1, int in_y1, int in_x2, int in_y2) {
		x1 = in_x1;
		y1 = in_y1;
		x2 = in_x2;
		y2 = in_y2;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(x1, y1, x2, y2);
	}
}
