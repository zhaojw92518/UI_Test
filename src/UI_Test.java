import javax.swing.UIManager;


public class UI_Test {

	public static void main(String[] args) {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		CPaintData test_data = new CPaintData();
		test_data.canvas_width = 2000;
		test_data.canvas_height = 2000;
		test_data.add_info("a", "b");
		test_data.add_info("aa", "bbb");
		test_data.add_info("TT", "b");
		test_data.add_info("TT", "b");
		test_data.add_info("a", "b");
		test_data.add_info("a", "b");
		test_data.add_info("a", "b");
		test_data.add_info("a", "b");
		test_data.add_info("a", "b");
		test_data.add_info("a", "b");
		test_data.add_info("a", "b");
		test_data.add_info("a", "b");
		CShowFrame test_frame = new CShowFrame(test_data);
		test_frame.repaint();
		System.out.println("hello");
	}
}
