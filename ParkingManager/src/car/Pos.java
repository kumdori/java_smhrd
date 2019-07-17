package car;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class Pos {

	private JFrame frame;
	DAO dao = new DAO();
	ArrayList<DTO> dtoList = new ArrayList<DTO>();
	DTO dto = new DTO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pos window = new Pos();
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
	public Pos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 856, 726);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String out_time = format1.format(System.currentTimeMillis()); // 나가는 시간 찍힘.

		dto = dao.rd_out_car().get(0); // 렌덤으로 차 선택
		dto.setOut_time(out_time); // 출차시간 dto에 입력
		dao.update_outtime(dto); // 출차시간 db에 업데이트
		int fare_sum = dao.money(out_time); // 요금 계산
		int st_hr = dao.stayTime(out_time) / 60; // 시간 계산
		int st_min = dao.stayTime(out_time) % 60; // 분 계산

		// test print
		System.out.println(
				dto.getCar_num() + "\t" + dto.getIn_time() + "\t" + dto.getOut_time() + "\t" + dto.getFare_sum());

		// if (dao.select_ad_car(dto.getCar_num()).size()>0) { // 회원 여부 확인
		if (dao.check_memeber(dto.getCar_num())) {
			dto.setFare_sum(0);
		} else {
			dto.setFare_sum(fare_sum); // dto에 요금 입력
		}
		dao.update_fare(dto); // db에 요금 업데이트

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(492, 10, 336, 194);
		frame.getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JPanel panel_7 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_7, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_7, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_7, 97, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_7, 326, SpringLayout.WEST, panel_1);
		panel_1.add(panel_7);
		SpringLayout sl_panel_7 = new SpringLayout();
		panel_7.setLayout(sl_panel_7);

		JLabel lbl_CarNum = new JLabel("\uCC28\uB7C9\uBC88\uD638 : " + dto.getCar_num());
		sl_panel_7.putConstraint(SpringLayout.WEST, lbl_CarNum, 65, SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, lbl_CarNum, -27, SpringLayout.SOUTH, panel_7);
		lbl_CarNum.setFont(new Font("굴림", Font.PLAIN, 25));
		lbl_CarNum.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lbl_CarNum); // ★ ★ → lbl_CarNum 차량번호

		JPanel panel_8 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_8, 9, SpringLayout.SOUTH, panel_7);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_8, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_8, 87, SpringLayout.SOUTH, panel_7);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_8, 326, SpringLayout.WEST, panel_1);
		panel_1.add(panel_8);
		SpringLayout sl_panel_8 = new SpringLayout();
		panel_8.setLayout(sl_panel_8);

		JLabel lbl_RateTime = new JLabel("주차시간 : " + st_hr + "시간 " + st_min + "분");
		sl_panel_8.putConstraint(SpringLayout.NORTH, lbl_RateTime, 22, SpringLayout.NORTH, panel_8);
		sl_panel_8.putConstraint(SpringLayout.WEST, lbl_RateTime, 62, SpringLayout.WEST, panel_8);
		lbl_RateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_RateTime.setFont(new Font("굴림", Font.PLAIN, 25));
		panel_8.add(lbl_RateTime); // ★ ★ → lbl_RateTime 사용시간

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		panel_2.setBounds(492, 214, 336, 222);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 8, 312, 102);
		panel_2.add(panel_6);
		panel_6.setLayout(null);

		// 입차시간 :
		JLabel lbl_InTime = new JLabel("" + dto.getIn_time());
		lbl_InTime.setFont(new Font("굴림", Font.PLAIN, 28));
		lbl_InTime.setBounds(57, 32, 224, 46);
		panel_6.add(lbl_InTime); // ★ ★ → lbl_InTime 입차시간

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(12, 110, 312, 102);
		panel_2.add(panel_9);
		panel_9.setLayout(null);

		// 출차시간 :
		JLabel lbl_OutTime = new JLabel("" + dto.getOut_time());
		lbl_OutTime.setFont(new Font("굴림", Font.PLAIN, 28));
		lbl_OutTime.setBounds(57, 29, 224, 46);
		panel_9.add(lbl_OutTime); // ★ ★ → lbl_OutTime 출차시간

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		panel_3.setBounds(492, 446, 336, 71);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		String payMsg = "";
		JButton btn_Pay = new JButton("\uACB0\uC81C"); // ★ ★ → btn_Pay 결제 버튼
		btn_Pay.setBounds(97, 10, 144, 49);
		panel_3.add(btn_Pay);
		btn_Pay.setBackground(Color.LIGHT_GRAY);
		btn_Pay.setFont(new Font("굴림", Font.PLAIN, 25));

		btn_Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FloorChoice Floorview = new FloorChoice();
				Floorview.main(null);
				frame.dispose();

			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, new Color(0, 0, 0), null));
		panel.setLayout(null);
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(12, 10, 468, 493);
		frame.getContentPane().add(panel);

		JLabel lbl_FareSum = new JLabel("\uCD1D \uACB0\uC81C \uAE08\uC561 : ");
		lbl_FareSum.setFont(new Font("굴림", Font.PLAIN, 37));
		lbl_FareSum.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_FareSum.setBounds(12, 10, 444, 174);
		panel.add(lbl_FareSum); // ★ ★ → lbl_FareSum

		JLabel lbl_Amount = new JLabel(dto.getFare_sum() + "원");
		lbl_Amount.setFont(new Font("굴림", Font.PLAIN, 87));
		lbl_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Amount.setBounds(12, 100, 444, 174);
		panel.add(lbl_Amount); // ★ ★ → lbl_Amount

		JLabel lbl_Info = new JLabel("카드를 넣어 주세요..." + payMsg);
		lbl_Info.setFont(new Font("굴림", Font.PLAIN, 37));
		lbl_Info.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Info.setBounds(12, 210, 444, 174);
		panel.add(lbl_Info); // ★ ★ → lbl_Info

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(12, 513, 468, 153);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(41, 26, 234, 58);
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("D:\\pics\\sm.png"));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(251, 10, 258, 86);
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("D:\\pics\\labor.png"));

		JLabel label_3 = new JLabel("");
		label_3.setBounds(41, 76, 234, 76);
		panel_4.add(label_3);
		label_3.setIcon(new ImageIcon("D:\\pics\\hrdnet.png"));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\pics\\plus.png"));
		lblNewLabel_4.setBounds(227, 76, 201, 76);
		panel_4.add(lblNewLabel_4);

		JLabel lbl_Thanks = new JLabel("이용해 주셔서 감사합니다.");
		lbl_Thanks.setFont(new Font("휴먼매직체", Font.PLAIN, 30));
		lbl_Thanks.setBounds(492, 487, 316, 139);
		frame.getContentPane().add(lbl_Thanks); // ★ ★ → lbl_FareSum
	}
}