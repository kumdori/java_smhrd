import java.awt.CardLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

public class PhoneTable {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneTable window = new PhoneTable();
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
	public PhoneTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 209, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 424, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		
		
		PhoneDAO dao = new PhoneDAO();
		ArrayList<PhoneDTO> list = dao.selectAll();
		String[] column = {"이름", "전화번호", "나이"};
		String[][] row = new String[list.size()][column.length];
		
		
		for (int i=0; i<list.size(); i++) {
			row[i][0]=list.get(i).getName();
			row[i][1]=list.get(i).getPhoneNum();
			row[i][2]=list.get(i).getAge()+"";
		}
		
		DefaultTableModel model = new DefaultTableModel(row, column);
		
		
		table = new JTable(model);
		
		JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll, "name_1290588145744400");
	}
}
