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
		column_min_width = 100,
		node_heigth = 200,
		title_heigth = 20,//���ⲿ�ָ߶�
		title_letter_width = 8,//����ÿ����ĸ�Ŀ��
		table_letter_width = 8,//���ÿ����ĸ�Ŀ��
		reserve_letter = 0,//�����ַ����ȣ���ֹ�񲻹���
		scroll_width = 20;//���������
	
	private JTable table = null;
	private JScrollPane table_scroll_pane = null;
	private JLabel title_label = null;
	private CShowTableModel cur_table_model = null;
	
	private CDataNode data_node = null;
	
	public CShowNode(CDataNode in_data_node){
		super();
		data_node = in_data_node;
		
		this.setLayout(null);
		
		title_label = new JLabel(in_data_node.title);

		this.add(title_label);
		
		if(!in_data_node.data_pairs.isEmpty()){//���û�з��ű����ݣ��򱾽ڵ��ʾ����������֧�ڵ�
			//�����������
			cur_table_model = new CShowTableModel(in_data_node.data_pairs);
			table = new JTable(cur_table_model);
			
			//table.setBounds(0, 0, 400, 400);
			//table.setPreferredSize(new Dimension(400, 400));
			
			TableColumn temp_column = table.getColumnModel().getColumn(0);
			temp_column.setMinWidth(in_data_node.column_a_paint_width);
			temp_column = table.getColumnModel().getColumn(1);
			temp_column.setMinWidth(in_data_node.column_b_paint_width);

			
			table_scroll_pane = new JScrollPane(
					table,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
			table_scroll_pane.setBounds(0, 
					title_heigth, 
					data_node.node_width, 
					data_node.node_heigth - title_heigth);
			this.add(table_scroll_pane);
		}
		
		title_label.setBounds(0, 0, data_node.node_width, title_heigth);
		
		this.setBorder(new EtchedBorder());
		this.setVisible(true);
	}
	
	public void setLocation(int x, int y){
		this.setBounds(x, y, data_node.node_width, data_node.node_heigth);
	}
	
	class CShowTableModel extends AbstractTableModel{
		private LinkedList<String[]> table_data = new LinkedList<String[]>();
		
		public CShowTableModel(LinkedList<String[]> in_data){
			for(String[] cur_str_array: in_data){
				String[] strs = {
						cur_str_array[0],
						cur_str_array[1]};
				table_data.add(strs);
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
