import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;


public class CLinePanel extends JPanel {
	private LinkedList<CLineData> line_list = new LinkedList<CLineData>();
	
	class CLineData{
		public int x1, y1, x2, y2;
		
		public CLineData(int in_x1, int in_y1, int in_x2, int in_y2){
			x1 = in_x1;
			x2 = in_x2;
			y1 = in_y1;
			y2 = in_y2;
		}
	}
	
	public void add_line(int in_x1, int in_y1, int in_x2, int in_y2){
		line_list.add(new CLineData(in_x1, in_y1, in_x2, in_y2));
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for(CLineData cur_line_data: line_list){
			g.drawLine(cur_line_data.x1, cur_line_data.y1, cur_line_data.x2, cur_line_data.y2);
		}
	}
}
