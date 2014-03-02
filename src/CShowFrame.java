import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CShowFrame extends JFrame{
	public static final int 
		window_edge = 40,
		node_width_edge = 20,
		node_heigth_edge = 40;
	
	private JPanel backgroup_panel = new JPanel();
	
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
	
	private CShowNode show_node = null;
	
	private void add_leaf_node(CDataNode root_node, LinkedList<CDataNode> node_list){
		if(root_node.left_node == null && root_node.right_node == null){
			root_node.left_node = node_list.pollFirst();
			root_node.right_node = node_list.pollFirst();
		}
		else{
			add_leaf_node(root_node.left_node, node_list);
			add_leaf_node(root_node.right_node, node_list);
		}
	}
	
	private LinkedList<CShowNode> node_list = new LinkedList<CShowNode>();
	private LinkedList<CLinePanel> line_list = new LinkedList<CLinePanel>();
	
	private void generate_framework(CPaintData in_paint_data){
		for(CDataNode cur_data_node: in_paint_data.data_tree){
			CShowNode cur_show_node = new CShowNode(cur_data_node);
			cur_show_node.setLocation(
					cur_data_node.paint_x, 
					cur_data_node.paint_y);
			backgroup_panel.add(cur_show_node);
			node_list.add(cur_show_node);
			/*CLinePanel cur_line = new CLinePanel(
					cur_data_node.line_x1, 
					cur_data_node.line_y1, 
					cur_data_node.line_x2, 
					cur_data_node.line_y2);
			cur_line.setBounds(0, 0, 
					in_paint_data.canvas_width, 
					in_paint_data.canvas_height);
			backgroup_panel.add(cur_line);
			line_list.add(cur_line);*/
		}
	}
}
