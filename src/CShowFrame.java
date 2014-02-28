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
	
	private void generate_framework(CPaintData in_paint_data){
		show_node = new CShowNode(in_paint_data.infos, "Title");
		show_node.setLocation(50, 50);
		backgroup_panel.add(show_node);
	}
}
