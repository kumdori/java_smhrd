package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import car.DAO;
import car.DTO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;

public class ManagerSelectAll {

	private JFrame frame;
	private JTable table_ll;
	JScrollPane scrollPane_ll;
	DefaultTableModel model;
	JPanel panel;
	JButton btn_CarNum;
	JButton btn_date;
	private DAO dao = new DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerSelectAll window = new ManagerSelectAll();
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
	public ManagerSelectAll() {
		initialize();

		System.out.println("버튼 클릭 됐음");

		ArrayList<DTO> dtoList = new ArrayList<DTO>();
		dtoList = dao.selectAll();
		
		String[] column = { "차번호", "입차시간", "출차시간", "요금" };
		String[][] row = new String[dtoList.size()][column.length];

		System.out.println("차번호\t입차시간\t출차시간\t요금");

		for (int i = 0; i < dtoList.size(); i++) {
			row[i][0] = dtoList.get(i).getCar_num();
			row[i][1] = dtoList.get(i).getIn_time();
			row[i][2] = dtoList.get(i).getOut_time();
			row[i][3] = dtoList.get(i).getFare_sum()+"";
		}

//		model.setRowCount(0);
		model = new DefaultTableModel(row, column);

		table_ll.setModel(model);
		scrollPane_ll.setViewportView(table_ll);
		panel.add(scrollPane_ll, "Center");
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

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.WHITE);
		panel.setBounds(48, 126, 589, 407);
		frame.getContentPane().add(panel);
//		panel.setLayout(null);

//		table = new JTable();
//		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
//		table.setBounds(22, 51, 555, 346);
//		panel.add(table);

		panel.setLayout(new CardLayout(0, 0));
		scrollPane_ll = new JScrollPane();
		panel.add(scrollPane_ll, "name_379849190340500");
		table_ll = new JTable();
		scrollPane_ll.setViewportView(table_ll);

		// 상단 메뉴

				// 회원 등록 버튼
				JButton btn_addMember = new JButton("");
				btn_addMember.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\addMember.jpg"));
				btn_addMember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManagerAdd ma = new ManagerAdd();
						ma.main(null);
						frame.dispose();
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
						ManagerSearch ms = new ManagerSearch();
						ms.main(null);
						frame.dispose();
					}
				});
				btn_search.setBorderPainted(false);
				btn_search.setBounds(146, 71, 110, 54);
				frame.getContentPane().add(btn_search);

				// 전체 조회 버튼
				JButton btn_selectAll = new JButton("");
				btn_selectAll.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\selectAll.jpg"));
				btn_selectAll.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				btn_selectAll.setBorderPainted(false);
				btn_selectAll.setBounds(251, 71, 110, 54);
				frame.getContentPane().add(btn_selectAll);

				// 회원 조회 버튼
				JButton btn_selectMember = new JButton("");
				btn_selectMember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManagerManSearch mms = new ManagerManSearch();
						mms.main(null);
						frame.dispose();
					}
				});
				btn_selectMember.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\selectMember.jpg"));
				btn_selectMember.setBorderPainted(false);
				btn_selectMember.setBounds(363, 71, 97, 54);
				frame.getContentPane().add(btn_selectMember);

				// 주차장 현황 버튼
				JButton btn_actual = new JButton("");
				btn_actual.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\actual.jpg"));
				btn_actual.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManagerView mv = new ManagerView();
						mv.main(null);
						frame.dispose();
					}
				});
				btn_actual.setBorderPainted(false);
				btn_actual.setBounds(464, 71, 128, 54);
				frame.getContentPane().add(btn_actual);
				
				JButton btn_logOut = new JButton("");
				btn_logOut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ManagerLogin ml = new ManagerLogin();
						ml.main(null);
						frame.dispose();
					}
				});
				btn_logOut.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\logout.jpg"));
				btn_logOut.setBorderPainted(false);
				btn_logOut.setBounds(561, 10, 122, 54);
				frame.getContentPane().add(btn_logOut);
	}
}
