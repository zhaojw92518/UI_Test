import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class CTestFrame extends JFrame{
	/*private JLabel btLog;
	private JTextField tfUser;
	private JPasswordField tfPwd;
	private JCheckBox pwdKeep;
	private JComboBox adminType;
	private CTestPanel test_panel;

	public CTestFrame() {
		super("�̶��ʲ�����ϵͳ");
		super.setSize(380, 292);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centered(this);
		JScrollPane scroll_pane = new JScrollPane(this);
		//btLog = new JLabel("��     ¼");
		//btLog.setBounds(new Rectangle(93, 220, 180, 30));//�����ֱ�������x��y������
		this.setLayout(new FlowLayout());//���ò��ֹ�����Ϊ��
		/*this.add(btLog);
		tfUser = new JTextField();
		tfUser.setBounds(new Rectangle(73, 115, 220, 25));
		this.add(tfUser);
		tfPwd = new JPasswordField();
		tfPwd.setBounds(new Rectangle(73, 150, 220, 25));
		this.add(tfPwd);
		pwdKeep = new JCheckBox("��ס����");
		pwdKeep.setBounds(new Rectangle(68, 185, 110, 25));
		this.add(pwdKeep);
		adminType = new JComboBox(new String[] { "��ְͨԱ", "����Ա", "�߼�����Ա" });
		adminType.setBounds(new Rectangle(183, 185, 100, 25));
		this.add(adminType);
		
		test_panel = new CTestPanel();
		this.add(test_panel);

	}
	//���־��з���
	public void centered(Container container) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int w = container.getWidth();
		int h = container.getHeight();
		container.setBounds((screenSize.width - w) / 2,
				(screenSize.height - h) / 2, w, h);
	}*/

    private JPanel pane = new JPanel();
    private JPanel pane1 = new JPanel();
    
    public CTestFrame() {

        super("Verificari");
        setBounds(0, 0, 1000, 1000);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pane.setLayout(null);
        pane1.setLayout(null);
        
        //here i define borders for all the panels
        Border eBorder1 = BorderFactory.createEtchedBorder();
        pane1.setBorder(BorderFactory.createTitledBorder(eBorder1, "11111111"));

        this.pane.setBounds(0, 0, 2000, 2000);
		this.pane.setPreferredSize(new Dimension(2000, 2000));

		final JScrollPane scrollp = new JScrollPane(this.pane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollp.setBounds(0, 0, 1000, 1000);
        
        //here i set the bounds of all the components
        pane1.setBounds(10, 13, 200, 60);

        //here i add all the elements to the panel
        pane.add(pane1);

        this.add(scrollp);
    	
        setVisible(true);
    }
}
