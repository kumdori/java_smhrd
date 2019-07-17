package car;

import java.awt.Color;
import java.awt.EventQueue;
//import java.awt.Window;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FloorChoice {

	private JFrame frame;
	private SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private Random rd = new Random();
	static protected int selectFloor;
	private String car_num;
	private DAO dao = new DAO();
	public static DTO carIn;

//	protected DTO dto = new DTO(car_num, 0, shownum);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FloorChoice window = new FloorChoice();
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
	public FloorChoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// 랜덤 번호 만들기.
		carIn = dao.getCamData();

		// 여기까지

		// 각 층별 빈공간 수 불러오기 시작.
		int floor1 = 40 - dao.select_floorseat_1().size();
		int floor2 = 40 - dao.select_floorseat_2().size();
		int floor3 = 40 - dao.select_floorseat_3().size();
		int floor4 = 40 - dao.select_floorseat_4().size();
		// 각 층별 빈공간 수 불러오기 끝.

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 1300, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\floor1big.jpg"));
		btnNewButton.setBounds(218, 122, 356, 232);
		btnNewButton.setFont(new Font("휴먼매직체", Font.PLAIN, 38));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 버튼을 클릭햇을때 프레임 넘기는것
				FloorView FloorView = new FloorView();
				selectFloor = 1;
				FloorView.main(null);
				frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("");
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\floor2big.jpg"));
		button.setFont(new Font("휴먼매직체", Font.PLAIN, 38));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FloorView FloorView = new FloorView();
				selectFloor = 2;
				FloorView.main(null);
				frame.dispose();

			}
		});
		button.setBounds(630, 122, 356, 232);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("");
		button_1.setHorizontalAlignment(SwingConstants.CENTER);
		button_1.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\floor3big.jpg"));
		button_1.setFont(new Font("휴먼매직체", Font.PLAIN, 38));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ArrayList<ParkingDTO> list = new ArrayList<>();
//				Floor3 FloorView = new Floor3();
				FloorView FloorView = new FloorView();
				selectFloor = 3;
				FloorView.main(null);
				frame.dispose();
			}
		});
		button_1.setBounds(218, 446, 356, 258);
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("");
		button_2.setHorizontalAlignment(SwingConstants.CENTER);
		button_2.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\floor4big.jpg"));
		button_2.setFont(new Font("휴먼매직체", Font.PLAIN, 38));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Floor4 FloorView = new Floor4();
				FloorView FloorView = new FloorView();
				selectFloor = 4;
				FloorView.main(null);
				frame.dispose();
			}
		});
		button_2.setBounds(630, 446, 356, 258);
		frame.getContentPane().add(button_2);

		JLabel lbl_in_time = new JLabel("New label");
		lbl_in_time.setBounds(985, 44, 337, 61);
		frame.getContentPane().add(lbl_in_time);
		lbl_in_time.setForeground(Color.WHITE);
		lbl_in_time.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 30));
		lbl_in_time.setText(carIn.getOut_time());

		JLabel lbl_CarNum = new JLabel("New label");
		lbl_CarNum.setBounds(441, 32, 476, 52);
		frame.getContentPane().add(lbl_CarNum);
		lbl_CarNum.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 45));
		lbl_CarNum.setText(carIn.getCar_num() + "님 환영합니다.");

		JLabel lblNewLabel = new JLabel("\uD604\uC7AC \uC2DC\uAC04");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 25));
		lblNewLabel.setBounds(1069, 21, 118, 29);
		frame.getContentPane().add(lblNewLabel);

		
		//종료 버튼
//		JButton btnNewButton_1 = new JButton("");
//		btnNewButton_1.setHorizontalAlignment(SwingConstants.CENTER);
//		btnNewButton_1.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\exit.jpg"));
//		btnNewButton_1.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//				System.exit(0);
//			}
//		});
//		btnNewButton_1.setFont(new Font("휴먼매직체", Font.PLAIN, 27));
//		btnNewButton_1.setBounds(1077, 667, 129, 134);
//		frame.getContentPane().add(btnNewButton_1);

		JLabel lbl_floor1 = new JLabel("\uC8FC\uCC28 \uAC00\uB2A5 : " + floor1);
        lbl_floor1.setBackground(Color.WHITE);
        lbl_floor1.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_floor1.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 50));
        lbl_floor1.setBounds(218, 365, 332, 61);
        frame.getContentPane().add(lbl_floor1);
        
        JLabel lbl_floor2 = new JLabel("\uC8FC\uCC28 \uAC00\uB2A5 : " + floor2);
        lbl_floor2.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_floor2.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 50));
        lbl_floor2.setBounds(640, 364, 346, 62);
        frame.getContentPane().add(lbl_floor2);
        
        JLabel lbl_floor3 = new JLabel("\uC8FC\uCC28 \uAC00\uB2A5 : " + floor3);
        lbl_floor3.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_floor3.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 50));
        lbl_floor3.setBounds(218, 716, 356, 61);
        frame.getContentPane().add(lbl_floor3);
        
        JLabel lbl_floor4 = new JLabel("\uC8FC\uCC28 \uAC00\uB2A5 : " + floor4);
        lbl_floor4.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_floor4.setFont(new Font("나눔스퀘어라운드 ExtraBold", Font.PLAIN, 50));
        lbl_floor4.setBounds(630, 714, 356, 61);
        frame.getContentPane().add(lbl_floor4);
        
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.WHITE);
//		panel.setBounds(759, 44, 237, 112);
//		frame.getContentPane().add(panel);
//
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(Color.WHITE);
//		panel_1.setBounds(107, 87, 287, 98);
//		frame.getContentPane().add(panel_1);
//		panel_1.setLayout(null);
//
//		JLabel lbl_in_time = new JLabel("New label");
//		lbl_in_time.setFont(new Font("휴먼매직체", Font.PLAIN, 23));
//		lbl_in_time.setBounds(39, 10, 217, 67);
//		panel_1.add(lbl_in_time);
//		lbl_in_time.setText(carIn.getOut_time());
//
//		JPanel panel_2 = new JPanel();
//		panel_2.setBackground(Color.WHITE);
//		panel_2.setBounds(419, 87, 287, 98);
//		frame.getContentPane().add(panel_2);
//		panel_2.setLayout(null);
//
//		JLabel lbl_CarNum = new JLabel("New label");
//		lbl_CarNum.setFont(new Font("휴먼매직체", Font.PLAIN, 23));
//		lbl_CarNum.setBounds(30, 22, 206, 52);
//		panel_2.add(lbl_CarNum);
//		lbl_CarNum.setText(carIn.getCar_num() + "님 환영합니다.");

	}

}
