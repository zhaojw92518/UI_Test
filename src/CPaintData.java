import java.util.LinkedList;

public class CPaintData {
	public int canvas_width, canvas_height;
	public LinkedList<String[]> infos = new LinkedList<String[]>();
	
	public void add_info(String in_str_a, String in_str_b){
		String[] temp_array = {in_str_a, in_str_b};
		infos.add(temp_array);
	}
}
