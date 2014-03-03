import java.util.LinkedList;

public class CPaintData {
	public int canvas_width, canvas_height;
	public LinkedList<String[]> infos = new LinkedList<String[]>();
	
	public CPaintData(){
		for(Integer i = 0; i < 15; i++){
			CDataNode data_node = new CDataNode();
			data_node.title = i.toString();
			String temp_str = "aaa";
			for(int j = 0; j < i; j++){
				temp_str += "aaa";
			}
			data_node.add_pair(temp_str, "b");
			for(Integer j = 0; j < 30; j++){
				data_node.add_pair(j.toString(), j.toString());
			}
			data_node.generate_paint_argument();
			data_tree.add(data_node);
		}
	}
	
	public void add_info(String in_str_a, String in_str_b){
		String[] temp_array = {in_str_a, in_str_b};
		infos.add(temp_array);
	}
	
	public LinkedList<CDataNode> data_tree = new LinkedList<CDataNode>();
	
	public int get_tree_depth(){
		return (int)(Math.log(data_tree.size() + 1) / Math.log(2));
	}
	
	private CDataNode get_left_node(int in_node_index){
		CDataNode return_result = null;
		int left_node_index = get_left_node_index(in_node_index);
		if(left_node_index != -1){
			return_result = data_tree.get(left_node_index);
		}
		return return_result;
	}
	
	private int get_left_node_index(int in_node_index){
		int return_result = (in_node_index + 1) * 2;
		if(return_result <= data_tree.size()){
			return_result = return_result - 1;
		}
		else{
			return_result = -1;
		}
		return return_result;
	}
	
	private CDataNode get_right_node(int in_node_index){
		CDataNode return_result = null;
		int right_node_index = get_right_node_index(in_node_index);
		if(right_node_index != -1){
			return_result = data_tree.get(right_node_index);
		}
		return return_result;
	}
	
	private int get_right_node_index(int in_node_index){
		int return_result = (in_node_index + 1) * 2 + 1;
		if(return_result <= data_tree.size()){
			return_result = return_result - 1;
		}
		else{
			return_result = -1;
		}
		return return_result;
	}
	
	public void check_tree_node(int in_index){
		if(!(in_index > data_tree.size() - 1)){
			System.out.println(data_tree.get(in_index).title);
			int left_node_index = get_left_node_index(in_index);
			if(left_node_index != -1){
				check_tree_node(left_node_index);
			}
			int right_node_index = get_right_node_index(in_index);
			if(right_node_index != -1){
				check_tree_node(right_node_index);
			}
		}
	}
	
	public void generate_node_location(){
		generate_leaf_location();
		if(!data_tree.isEmpty()){
			generate_other_location(0);
		}
	}
	
	//生成除了最深一层的位置参数
	private void generate_other_location(int in_index){
		int 	left_node_index = get_left_node_index(in_index),
				right_node_index = get_right_node_index(in_index);
		if(left_node_index != -1 && right_node_index != -1){
			CDataNode left_node = data_tree.get(left_node_index),
					right_node = data_tree.get(right_node_index),
					cur_node = data_tree.get(in_index);
			
			if(left_node.paint_x == CDataNode.INIT_VALUE){
				generate_other_location(left_node_index);
			}
			if(right_node.paint_x == CDataNode.INIT_VALUE){
				generate_other_location(right_node_index);
			}
			cur_node.paint_x = 
					(right_node.paint_x + left_node.paint_x +
					left_node.node_width) / 2 - 
					cur_node.node_width / 2 ;
			cur_node.paint_y = left_node.paint_y - CShowNode.node_heigth - 
					CShowFrame.node_heigth_edge;
			left_node.line_x1 = right_node.line_x1 = 
					cur_node.paint_x + cur_node.node_width / 2;
			left_node.line_y1 = right_node.line_y1 = 
					cur_node.paint_y + CShowNode.node_heigth;
			left_node.line_x2 = left_node.paint_x + left_node.node_width / 2;
			left_node.line_y2 = left_node.paint_y;
			right_node.line_x2 = right_node.paint_x + right_node.node_width / 2;
			right_node.line_y2 = right_node.paint_y;
		}
	}
	
	//生成最深一层的位置参数
	private void generate_leaf_location(){
		int cur_location_argument = CShowFrame.window_edge;
		int tree_depth = get_tree_depth(),
			deepest_level_size = (int)Math.pow(2, (tree_depth - 1));
		for(int i = 0; i < deepest_level_size; i++){
			CDataNode cur_node = 
			data_tree.get(data_tree.size() - deepest_level_size + i);
			
			cur_node.paint_x = cur_location_argument;
			cur_node.paint_y = canvas_height - CShowFrame.window_edge -
					CShowNode.node_heigth;
			
			cur_location_argument += cur_node.node_width + 
					CShowFrame.node_width_edge;
		}
	}
	
	public void generate_canvas_size(){
		int tree_depth = get_tree_depth();
		canvas_height = CShowNode.node_heigth * tree_depth + 
				CShowFrame.node_heigth_edge * (tree_depth - 1) + 
				CShowFrame.window_edge * 2;
		int deepest_level_size = (int)Math.pow(2, (tree_depth - 1));
		for(int i = 0; i < deepest_level_size; i++){
			canvas_width += data_tree.get(data_tree.size() - 1 - i).node_width;
		}
		canvas_width += CShowFrame.node_width_edge * (deepest_level_size - 1);
		canvas_width += CShowFrame.window_edge * 2;
	}
}
