package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
//import javax.swing.JLabel;
//import javax.swing.SwingConstants;
//import java.awt.Font;
//import javax.swing.JTextField;
//import javax.swing.JTable;

public class ManagerView {

	private JFrame frame;
	public static int selectFloor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerView window = new ManagerView();
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
	public ManagerView() {
		initialize();
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
		panel.setBounds(48, 126, 589, 407);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

// 메인 메뉴 층별 선택 버튼 1~4

		// 1층 버튼
		JButton btn_floor1 = new JButton("");
		btn_floor1.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\floor1.jpg"));
		btn_floor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerFV fv = new ManagerFV();
				selectFloor = 1;
				fv.main(null);
			}
		});
		btn_floor1.setBorderPainted(false);
		btn_floor1.setBounds(62, 59, 192, 107);
		panel.add(btn_floor1);
		// 2층 버튼
		JButton btn_floor2 = new JButton("");
		btn_floor2.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\floor2.jpg"));
		btn_floor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerFV fv = new ManagerFV();
				selectFloor = 2;
				fv.main(null);
			}
		});
		btn_floor2.setBorderPainted(false);
		btn_floor2.setBounds(322, 59, 192, 107);
		panel.add(btn_floor2);
		// 3층 버튼
		JButton btn_floor3 = new JButton("");
		btn_floor3.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\floor3.jpg"));
		btn_floor3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerFV fv = new ManagerFV();
				selectFloor = 3;
				fv.main(null);
			}
		});
		btn_floor3.setBorderPainted(false);
		btn_floor3.setBounds(62, 221, 192, 107);
		panel.add(btn_floor3);
		// 4층 버튼
		JButton btn_floor4 = new JButton("");
		btn_floor4.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\floor4.jpg"));
		btn_floor4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerFV fv = new ManagerFV();
				selectFloor = 4;
				fv.main(null);
			}
		});
		btn_floor4.setBorderPainted(false);
		btn_floor4.setBounds(322, 221, 192, 107);
		panel.add(btn_floor4);

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
						ManagerSelectAll msa = new ManagerSelectAll();
						msa.main(null);
						frame.dispose();
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