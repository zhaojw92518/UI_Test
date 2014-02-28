import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;


public class CShowNode extends JPanel {
	public static final int 
		//node_width = 200, 
		node_heigth = 200,
		title_heigth = 20,//标题部分高度
		letter_width = 8,//每个字母的宽度
		reserve_letter = 2;//保留字符长度，防止格不够宽
	
	private JTable table = null;
	private JScrollPane table_scroll_pane = null;
	private JLabel title_label = null;
	private CShowTableModel cur_table_model = null;
	
	public int node_width = 0; 
	
	private int get_paint_width(int in_data){
		return (in_data + reserve_letter) * letter_width;
	}
	
	public CShowNode(LinkedList<String[]> in_data, String in_title){
		super();
		this.setLayout(null);
		
		title_label = new JLabel(in_title);
		title_label.setBounds(0, 0, node_width, title_heigth);
		
		node_width = get_paint_width(in_title.length());
		this.add(title_label);
		
		if(in_data != null){//如果没有符号表数据，则本节点表示的是条件分支节点
			//读入绘制数据
			cur_table_model = new CShowTableModel(in_data);
			table = new JTable(cur_table_model);
			
			//根据字符串长度确定每一列的宽度，每个字符5像素宽
			int 	column_a_paint_width = get_paint_width(cur_table_model.column_a_max_length),
					column_b_paint_width = get_paint_width(cur_table_model.column_b_max_length);
			
			TableColumn temp_column = table.getColumnModel().getColumn(0);
			temp_column.setMinWidth(column_a_paint_width);
			temp_column = table.getColumnModel().getColumn(1);
			temp_column.setMinWidth(column_b_paint_width);
			
			if(column_a_paint_width + column_b_paint_width > node_width){
				node_width = column_a_paint_width + column_b_paint_width;
			}
			
			//table.setBounds(0, 0, 400, 400);
			//table.setPreferredSize(new Dimension(400, 400));
			table_scroll_pane = new JScrollPane(
					table,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
			table_scroll_pane.setBounds(0, 
					title_heigth, 
					node_width, 
					node_heigth - title_heigth);
			this.add(table_scroll_pane);
		}
		
		this.setBorder(new EtchedBorder());
		this.setVisible(true);
	}
	
	public void setLocation(int x, int y){
		this.setBounds(x, y, node_width, node_heigth);
	}
	
	class CShowTableModel extends AbstractTableModel{
		private LinkedList<String[]> table_data = new LinkedList<String[]>();
		
		public int column_a_max_length = 0, column_b_max_length = 0;
		
		public CShowTableModel(LinkedList<String[]> in_data){
			for(String[] cur_str_array: in_data){
				String[] strs = {
						cur_str_array[0],
						cur_str_array[1]};
				table_data.add(strs);
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
		}
		
		@Override
        public int getRowCount()
        {
            return table_data.size() - 1;
        }
        
        @Override
        public int getColumnCount()            
        {
            return 2;
        }
        
        @Override
        public Object getValueAt(int row, int column)
        {        
            return table_data.get(row + 1)[column];
        }
        
        //Used by the JTable object to set the column names
        @Override
        public String getColumnName(int column) {
            return table_data.getFirst()[column];
        }
        
        //Used by the JTable object to render different
        //functionality based on the data type
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        @Override
        public boolean isCellEditable(int row, int column)
        {
        	return false;
        }
	}
}
