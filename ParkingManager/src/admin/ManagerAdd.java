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

import car.DAO;
import car.DTO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class ManagerAdd {

	private JFrame frame;
	private JTextField txt_CarNum;
	private JTextField txt_PhoneNum;
	private JTextField txt_id;
	private DAO dao = new DAO();
	private DTO dto = new DTO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerAdd window = new ManagerAdd();
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
	public ManagerAdd() {
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

// 회원 등록 메인 화면

		// 차번호 입력
		JLabel lbl_CarNum = new JLabel("\uCC28\uB7C9 \uBC88\uD638");
		lbl_CarNum.setForeground(Color.GRAY);
		lbl_CarNum.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 28));
		lbl_CarNum.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_CarNum.setBounds(82, 38, 165, 62);
		panel.add(lbl_CarNum);
		txt_CarNum = new JTextField();
		txt_CarNum.setBounds(82, 97, 165, 46);
		panel.add(txt_CarNum);
		txt_CarNum.setColumns(10);
		// 전화번호 입력
		JLabel lbl_PhoneNum = new JLabel("\uC5F0\uB77D\uCC98");
		lbl_PhoneNum.setForeground(Color.GRAY);
		lbl_PhoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_PhoneNum.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 28));
		lbl_PhoneNum.setBounds(82, 145, 165, 62);
		panel.add(lbl_PhoneNum);
		txt_PhoneNum = new JTextField();
		txt_PhoneNum.setColumns(10);
		txt_PhoneNum.setBounds(82, 204, 165, 46);
		panel.add(txt_PhoneNum);
		// ID 입력
		JLabel lbl_id = new JLabel("\uD68C\uC6D0 ID");
		lbl_id.setForeground(Color.GRAY);
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_id.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 28));
		lbl_id.setBounds(82, 249, 165, 62);
		panel.add(lbl_id);
		txt_id = new JTextField();
		txt_id.setColumns(10);
		txt_id.setBounds(82, 308, 165, 46);
		panel.add(txt_id);

		// 등록 확인 버튼 OK
		JButton btn_ok = new JButton("\uB4F1\uB85D");
		btn_ok.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\ok.jpg"));
		btn_ok.setBackground(Color.GREEN);
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(txt_CarNum.getText()+"\t"+txt_PhoneNum.getText()+"\t"+txt_id.getText());

				dto.setCar_num(txt_CarNum.getText());
				dto.setPhone(txt_PhoneNum.getText());
				dto.setId(txt_id.getText());
				dao.insert(dto);

				dao.insert_id(dto);

				dao.st_ed_update(txt_id.getText());

			}
		});
		btn_ok.setBorderPainted(false);
		btn_ok.setBounds(334, 141, 215, 79);
		panel.add(btn_ok);

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
