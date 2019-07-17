package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import car.DAO;
import car.DTO;
import java.awt.CardLayout;

public class A {

	private JFrame frame;
	private JTextField txt_CarNum;
	private JTextField txt_date;
	private JTable table_list;
	private DAO dao = new DAO();
	private DTO dto = new DTO();
	private DefaultTableModel model;
	private JScrollPane scroll;
	private JPanel panel_list;
	JButton btn_CarNum;
	private JTable table_ll;
	JScrollPane scrollPane_ll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A window = new A();
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
	public A() {
		initialize();
		btn_CarNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("버튼 클릭 됐음"+txt_CarNum.getText());
				
				ArrayList<DTO> dtoList = new ArrayList<DTO>();  
				dtoList = dao.check_car(txt_CarNum.getText());
				String[] column = {"차번호", "위치", "입차시간", "출차시간", "요금"};
				String[][] row = new String[dtoList.size()][column.length];
				
				System.out.println("차번호\t위치\t입차시간\t출차시간\t요금");
				
				for (int i=0; i<dtoList.size(); i++) {
					row[i][0]=dtoList.get(i).getCar_num();
					row[i][1]=dtoList.get(i).getPosition()+"";
					row[i][2]=dtoList.get(i).getIn_time();
					row[i][3]=dtoList.get(i).getOut_time();
					row[i][4]=dtoList.get(i).getFare_sum()+"";
					
					System.out.print(row[i][0]+"\t");
					System.out.print(row[i][1]+"\t");
					System.out.print(row[i][2]+"\t");
					System.out.print(row[i][3]+"\t");
					System.out.print(row[i][4]+"\t");
					
				}
				
				model = new DefaultTableModel(row, column);

				table_ll.setModel(model);
//				table_.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//				table_.setBounds(12, 155, 565, 242);
				scrollPane_ll.setViewportView(table_ll);
				panel_list.add(scrollPane_ll, "Center");
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 711, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.WHITE);
		panel.setBounds(48, 126, 589, 157);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbl_CarNum = new JLabel("\uCC28\uBC88\uD638 \uAC80\uC0C9");
		lbl_CarNum.setForeground(Color.GRAY);
		lbl_CarNum.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 24));
		lbl_CarNum.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CarNum.setBounds(27, 20, 165, 62);
		panel.add(lbl_CarNum);

		txt_CarNum = new JTextField();
		txt_CarNum.setBounds(182, 38, 165, 31);
		panel.add(txt_CarNum);
		txt_CarNum.setColumns(10);

		JLabel lbl_date = new JLabel("\uB0A0\uC9DC \uAC80\uC0C9");
		lbl_date.setForeground(Color.GRAY);
		lbl_date.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 24));
		lbl_date.setBounds(27, 74, 165, 62);
		panel.add(lbl_date);

		txt_date = new JTextField();
		txt_date.setColumns(10);
		txt_date.setBounds(182, 92, 165, 31);
		panel.add(txt_date);
		
		
		panel_list = new JPanel();
		panel_list.setBounds(53, 318, 564, 207);
		frame.getContentPane().add(panel_list);
		panel_list.setLayout(new CardLayout(0, 0));
		scrollPane_ll = new JScrollPane();
		panel_list.add(scrollPane_ll, "name_379849190340500");
		table_ll = new JTable();
		scrollPane_ll.setViewportView(table_ll);
		
		
		btn_CarNum = new JButton("");
		panel.add(btn_CarNum);
		btn_CarNum.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\find.jpg"));
		btn_CarNum.setBorderPainted(false);
		btn_CarNum.setBounds(359, 38, 28, 30);

		
		
		JButton btn_date = new JButton("");
		btn_date.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\find.jpg"));
		btn_date.setBorderPainted(false);
		btn_date.setBounds(359, 92, 28, 30);
		panel.add(btn_date);
		
		

		
// 상단 메뉴

		// 회원 등록 버튼
		JButton btn_addMember = new JButton("");
		btn_addMember.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\addMember.jpg"));
		btn_addMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btn_addMember.setBorderPainted(false);
		btn_addMember.setBounds(38, 71, 110, 54);
		frame.getContentPane().add(btn_addMember);

		// 조건 검색 버튼
		JButton btn_search = new JButton("");
		btn_search.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\search.jpg"));
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btn_search.setBorderPainted(false);
		btn_search.setBounds(146, 71, 110, 54);
		frame.getContentPane().add(btn_search);

		// 전체 조회 버튼
		JButton btn_selectAll = new JButton("");
		btn_selectAll.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\selectAll.jpg"));
		btn_selectAll.setBorderPainted(false);
		btn_selectAll.setBounds(251, 71, 110, 54);
		frame.getContentPane().add(btn_selectAll);

		// 회원 조회 버튼
		JButton btn_selectMember = new JButton("");
		btn_selectMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btn_selectMember.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\selectMember.jpg"));
		btn_selectMember.setBorderPainted(false);
		btn_selectMember.setBounds(363, 71, 97, 54);
		frame.getContentPane().add(btn_selectMember);

		// 주차장 현황 버튼
		JButton btn_actual = new JButton("");
		btn_actual.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\actual.jpg"));
		btn_actual.setBorderPainted(false);
		btn_actual.setBounds(464, 71, 128, 54);
		frame.getContentPane().add(btn_actual);
		
		

		
//		JButton btn_search = new JButton("");
//		btn_search.setIcon(new ImageIcon("C:\\Users\\smhrd17\\Desktop\\\uADF8\uB9BC6.jpg"));
//		btn_search.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				
//			}
//		});
//		btn_search.setBorderPainted(false);
//		btn_search.setBounds(146, 71, 110, 54);
//		frame.getContentPane().add(btn_search);
//		
//		JButton btn_add = new JButton("");
//		btn_add.setIcon(new ImageIcon("C:\\Users\\smhrd17\\Desktop\\\uADF8\uB9BC5.jpg"));
//		btn_add.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				
//			}
//		});
//		btn_add.setBorderPainted(false);
//		btn_add.setBounds(38, 71, 110, 54);
//		frame.getContentPane().add(btn_add);
//		
//		JButton btn_searchMember = new JButton("");
//		btn_searchMember.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				
//				
//			}
//		});
//		btn_searchMember.setIcon(new ImageIcon("C:\\Users\\smhrd17\\Desktop\\\uADF8\uB9BC8.jpg"));
//		btn_searchMember.setBorderPainted(false);
//		btn_searchMember.setBounds(363, 71, 97, 54);
//		frame.getContentPane().add(btn_searchMember);
//		
//		JButton btn_select = new JButton("");
//		btn_select.setIcon(new ImageIcon("C:\\Users\\smhrd17\\Desktop\\\uADF8\uB9BC7.jpg"));
//		btn_select.setBorderPainted(false);
//		btn_select.setBounds(251, 71, 110, 54);
//		frame.getContentPane().add(btn_select);
//		
//		JButton btn_actual = new JButton("");
//		btn_actual.setIcon(new ImageIcon("C:\\Users\\smhrd17\\Desktop\\\uADF8\uB9BC9.jpg"));
//		btn_actual.setBorderPainted(false);
//		btn_actual.setBounds(464, 71, 128, 54);
//		frame.getContentPane().add(btn_actual);
		
//		String[][] r = {};
//		String[] c ={"차번호", "위치", "입차시간", "출차시간", "요금"};
//		model = new DefaultTableModel(r, c);
//
//		table_list = new JTable(model);
//		
//		scroll = new JScrollPane();
//		scroll.setViewportView(table_list);
//		panel_list.add(scroll, "Center");
		
		
	}
}
