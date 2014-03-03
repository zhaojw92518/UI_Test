import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class CShowFrame extends JFrame{
	public static final int 
		window_edge = 40,
		node_width_edge = 20,
		node_heigth_edge = 80;
	
	private CLinePanel backgroup_panel = new CLinePanel();
	
	public CShowFrame(CPaintData in_paint_data){
		super();
		setBounds(0, 0, 848, 480);
		
		backgroup_panel.setLayout(null);
		backgroup_panel.setBounds(0, 0, 
				in_paint_data.canvas_width, 
				in_paint_data.canvas_height);
		backgroup_panel.setPreferredSize(new Dimension(
				in_paint_data.canvas_width,
				in_paint_data.canvas_height));
		JScrollPane scroll_pane = new JScrollPane(
				backgroup_panel,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(scroll_pane);
		generate_framework(in_paint_data);		
		setVisible(true);
	}
	
	private LinkedList<CShowNode> node_list = new LinkedList<CShowNode>();
	
	private void generate_framework(CPaintData in_paint_data){
		for(CDataNode cur_data_node: in_paint_data.data_tree){
			CShowNode cur_show_node = new CShowNode(cur_data_node);
			cur_show_node.setLocation(
					cur_data_node.paint_x, 
					cur_data_node.paint_y);
			backgroup_panel.add(cur_show_node);
			node_list.add(cur_show_node);
			backgroup_panel.add_line(
					cur_data_node.line_x1, 
					cur_data_node.line_y1, 
					cur_data_node.line_x2, 
					cur_data_node.line_y2);
		}
	}
}
