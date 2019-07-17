import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class PhoneGUI {

	private JFrame frame;
	PhoneDAO dao = new PhoneDAO();
	static PhoneGUI window;
	phoneDial dial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new PhoneGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PhoneGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 559, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 89, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 533, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_3, 239, SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_3, -10, SpringLayout.SOUTH, frame.getContentPane());
		panel_3.setBackground(Color.YELLOW);
		springLayout.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_1);
		
		JLabel label_main = new JLabel("전화목록");
		label_main.setFont(new Font("굴림", Font.BOLD, 18));
		label_main.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_main, "name_1285449629781800");
		frame.getContentPane().add(panel_3);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JButton btn_insert = new JButton("연락처 추가");
		btn_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				phoneDial dial = new phoneDial();
				dial.setVisible(true);
				window.frame.setVisible(false);
				
			}
		});
		sl_panel_3.putConstraint(SpringLayout.WEST, btn_insert, 81, SpringLayout.WEST, panel_3);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, btn_insert, -24, SpringLayout.SOUTH, panel_3);
		panel_3.add(btn_insert);
		
		JButton btn_delete = new JButton("연락처 삭제");
		sl_panel_3.putConstraint(SpringLayout.NORTH, btn_delete, 0, SpringLayout.NORTH, btn_insert);
		sl_panel_3.putConstraint(SpringLayout.WEST, btn_delete, 50, SpringLayout.EAST, btn_insert);
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		panel_3.add(btn_delete);
		
		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -6, SpringLayout.NORTH, panel_3);
		
		JButton btn_selectall = new JButton("전체 보기");
		btn_selectall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PhoneTable table = new PhoneTable();
				table.main(null);
				
				
			}
		});
		sl_panel_3.putConstraint(SpringLayout.NORTH, btn_selectall, 0, SpringLayout.NORTH, btn_insert);
		sl_panel_3.putConstraint(SpringLayout.WEST, btn_selectall, 44, SpringLayout.EAST, btn_delete);
		panel_3.add(btn_selectall);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, 533, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));
		
		DefaultListModel model = new DefaultListModel();
		ArrayList<PhoneDTO> list = dao.selectAll();
		
		for (int i=0; i<list.size(); i++) {
			model.addElement(list.get(i).getName());
		}
		
		JList jlist = new JList(model);
		panel_4.add(jlist, "name_1286799091245500");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GREEN);
		panel_2.add(panel_5);
		SpringLayout sl_panel_5 = new SpringLayout();
		panel_5.setLayout(sl_panel_5);
		
		JLabel lbl_name = new JLabel("이름:");
		sl_panel_5.putConstraint(SpringLayout.NORTH, lbl_name, 22, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, lbl_name, 25, SpringLayout.WEST, panel_5);
		panel_5.add(lbl_name);
		
		JLabel lbl_age = new JLabel("나이:");
		sl_panel_5.putConstraint(SpringLayout.NORTH, lbl_age, 56, SpringLayout.SOUTH, lbl_name);
		sl_panel_5.putConstraint(SpringLayout.WEST, lbl_age, 0, SpringLayout.WEST, lbl_name);
		panel_5.add(lbl_age);
		
		JLabel lbl_phone = new JLabel("전화번호:");
		sl_panel_5.putConstraint(SpringLayout.WEST, lbl_phone, 0, SpringLayout.WEST, lbl_name);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, lbl_phone, -48, SpringLayout.SOUTH, panel_5);
		panel_5.add(lbl_phone);
	}
}
