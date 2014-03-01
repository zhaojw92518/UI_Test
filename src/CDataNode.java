import java.util.LinkedList;


public class CDataNode {
	//基本数据
	public String title = null;
	public LinkedList<String[]> data_pairs = new LinkedList<String[]>();

	public void add_pair(String in_str_a, String in_str_b){
		String[] cur_pair = {in_str_a, in_str_b};
		data_pairs.add(cur_pair);
	}
	
	//绘制参数
	public int node_width = 0, 
				node_heigth = CShowNode.node_heigth, 
				column_a_paint_width = 0, 
				column_b_paint_width = 0;
	
	//该函数仅作表格部分宽度计算
	private int get_paint_width(int in_data){
		int return_result = (in_data + CShowNode.reserve_letter) * CShowNode.table_letter_width;
		if(return_result < CShowNode.column_min_width){
			return_result = CShowNode.column_min_width;
		}
		return return_result;
	}
	
	public void generate_paint_argument(){
		int column_a_max_length = 0, column_b_max_length = 0;
		for(String[] cur_str_array: data_pairs){
			//确定每列的字符串长度
			int temp_length = cur_str_array[0].length();
			if(temp_length > column_a_max_length){
				column_a_max_length = temp_length;
			}
			temp_length = cur_str_array[1].length();
			if(temp_length > column_b_max_length){
				column_b_max_length = temp_length;
			}
		}
		
		column_a_paint_width = get_paint_width(column_a_max_length);
		column_b_paint_width = get_paint_width(column_b_max_length);
		
		int table_preferred_width = column_a_paint_width + column_b_paint_width + CShowNode.scroll_width;
		int title_preferred_width = title.length() * CShowNode.title_letter_width;
		
		if(title_preferred_width > table_preferred_width){
			node_width = title_preferred_width;
		}
		else{
			node_width = table_preferred_width;
		}
	}
	
	//树形结构
	public CDataNode left_node = null, right_node = null;
}
