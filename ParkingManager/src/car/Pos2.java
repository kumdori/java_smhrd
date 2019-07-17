package car;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class Pos2 {

	private JFrame frame;

	DAO dao = new DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pos2 window = new Pos2();
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
	public Pos2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 841, 726);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		DTO dto = new DTO();

		////////////////////////////////////////

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

		/////////////////////////////////////////

		JLabel lbl_Thanks = new JLabel("이용해 주셔서 감사합니다.");
		lbl_Thanks.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 30));
		lbl_Thanks.setBounds(259, 516, 360, 139);
		frame.getContentPane().add(lbl_Thanks);

		JLabel lbl_carNum = new JLabel("" + dto.getCar_num());
		lbl_carNum.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_carNum.setFont(new Font("Dialog", Font.PLAIN, 50));
		lbl_carNum.setBounds(9, 124, 426, 76);
		frame.getContentPane().add(lbl_carNum);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\carNum.jpg"));
		lblNewLabel_5.setBounds(-1, 22, 436, 110);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\staytime.jpg"));
		label.setBounds(-1, 210, 436, 110);
		frame.getContentPane().add(label);

		JLabel lbl_time = new JLabel(st_hr + "시간 " + st_min + "분");
		lbl_time.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_time.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 50));
		lbl_time.setBounds(9, 314, 426, 57);
		frame.getContentPane().add(lbl_time);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\price.jpg"));
		lblNewLabel.setBounds(447, 22, 366, 122);
		frame.getContentPane().add(lblNewLabel);

		JLabel lbl_pay = new JLabel(dto.getFare_sum() + "원");
		lbl_pay.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_pay.setFont(new Font("Dialog", Font.PLAIN, 50));
		lbl_pay.setBounds(460, 127, 353, 86);
		frame.getContentPane().add(lbl_pay);

		JButton btn_ok = new JButton("");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FloorChoice Floorview = new FloorChoice();
				Floorview.main(null);
				frame.dispose();
			}
		});
		btn_ok.setBorderPainted(false);
		btn_ok.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\payment.jpg"));
		btn_ok.setBounds(235, 426, 360, 128);
		frame.getContentPane().add(btn_ok);
	}
}