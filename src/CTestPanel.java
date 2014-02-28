import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class CTestPanel extends JPanel{
	public CTestPanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setSize(1000, 1000);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(0, 0, 1000, 1000);
	}
}
