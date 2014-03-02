import javax.swing.UIManager;

public class UI_Test {

	public static void main(String[] args) {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		CPaintData test_data = new CPaintData();
		//test_data.canvas_width = 2000;
		//test_data.canvas_height = 2000;
		//test_data.check_tree_node(0);
		System.out.println(test_data.get_tree_depth());
		test_data.generate_canvas_size();
		System.out.println(test_data.canvas_width);
		System.out.println(test_data.canvas_height);
		test_data.generate_node_location();
		CShowFrame test_frame = new CShowFrame(test_data);
		test_frame.repaint();
		//System.out.println("hello");
	}
}
