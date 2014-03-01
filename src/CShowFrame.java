import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CShowFrame extends JFrame{
	private JPanel backgroup_panel = new JPanel();
	
	public CShowFrame(CPaintData in_paint_data){
		super();
		setBounds(0, 0, 1280, 800);
		
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
	
	private void check_tree_node(CDataNode root_node){
		System.out.println(root_node.title);
		if(root_node.left_node != null){
			check_tree_node(root_node.left_node);
		}
		if(root_node.right_node != null){
			check_tree_node(root_node.right_node);
		}
	}
	
	private void generate_framework(CPaintData in_paint_data){
		CDataNode root_node = null;
		LinkedList<CDataNode> node_list = new LinkedList<CDataNode>();
		for(Integer i = 0; i < 15; i++){
			CDataNode data_node = new CDataNode();
			data_node.title = i.toString();
			data_node.add_pair("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "b");
			for(Integer j = 0; j < 30; j++){
				data_node.add_pair(j.toString(), j.toString());
			}
			data_node.generate_paint_argument();
			node_list.add(data_node);
		}
		root_node = node_list.pollFirst();
		while(!node_list.isEmpty()){
			add_leaf_node(root_node, node_list);
		}
		check_tree_node(root_node);
		
		//show_node = new CShowNode(data_node);
		//show_node.setLocation(50, 50);
		//backgroup_panel.add(show_node);
	}
}
