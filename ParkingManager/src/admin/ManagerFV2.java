package admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import car.DAO;
import car.DTO;

public class ManagerFV2 {


	public static int selectFloor;
	private JFrame frame;
	private int position;
	private JButton[] buttons = new JButton[40];
	static ManagerFV2 window;
	DAO dao = new DAO();
	DTO dto = new DTO();
	private int floor;
	private int adjust;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ManagerFV2();
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
	public ManagerFV2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1272, 850);

		// vDist = 주차공간의 세로 위치. 10개 공간마다 아래로 내려감.
		int[] vDist = { 10, 226, 351, 578 };

		// 각 층별 번호가 맞도록 번호 조절해 주는 변수
		floor = ManagerView.selectFloor;
		adjust = (floor - 1) * 40;

		// 주차 여부 확인용 '불리언 배열' // 1층의 빈 공간 위치를 불러옴
		ArrayList<DTO> binkan = dao.selectEmpty(floor);
		String arr[] = new String[40];
		System.out.println(binkan.size());

		for (int i = 0; i < binkan.size(); i++) {
			// 리스트에 주차된 차의 위치번호를 이용해 주차된 리스트 인덱스에 "red"라고 표시
			arr[binkan.get(i).getPosition() - 1 - adjust] = "red";
		}

		// 각 층의 40개 버튼을 생성 시작
		for (int j = 0; j < 4; j++) {

			// 각 단계의 1~10번째 주차 공간을 버튼으로 그려 줌.
			for (int i = 0 + j * 10, num = 0; i < (j + 1) * 10; i++, num++) { // 차칸 번호는 1부터 시작하고 i 또는 mi는 0부터 시작함.
				if (arr[i] != null) {
					// 버튼의 이름 "" + (i + 1)
					buttons[i] = new JButton("" + (i + 1 + adjust));
					buttons[i].setBackground(new Color(255, 0, 0));
				} else {
					// 버튼의 이름 "" + (i + 1)
					buttons[i] = new JButton("" + (i + 1 + adjust));
					buttons[i].setBackground(new Color(0, 255, 0));
				}

				// button 번호를 actionListener 안으로 넣기 위해 final로 설정
				final Integer mi = new Integer(i);

				buttons[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// set clicked position
						position = mi;
						
//						System.out.println(dao.selectOne(position));
//						int sz = dao.selectOne(position).size(); 

						// 빈공간인지 확인
//						if (sz>0) {

							int[] positionArr = new int[160];
							for (int i = 0; i < 160; i++) {
								positionArr[i] = i;

								if (positionArr[i] == mi + adjust) {
									position = positionArr[i] + 1; // mi가 클릭한 칸의 번호인데 인덱스 번호처럼 0에서 시작하고 있다.
									break;
								}
							} //

							// set buttons background red if space is selected
							if (arr[mi] == null) {
								buttons[mi].setBackground(new Color(255, 0, 0));
							}

							// set buttons background green rest of empty spaces
							for (int j = 0; j < buttons.length; j++) {
								if (j != mi && arr[j] == null) {
									buttons[j].setBackground(new Color(0, 255, 0));
								}
							} // set green empty space.end.
//						} else {
//							WarnPosition warn = new WarnPosition();
//							warn.main(null);
//						}

					} // actionPerformed end

				});

				buttons[i].setBounds(150 + num * 98, vDist[j], 84, 115);
				frame.getContentPane().add(buttons[i]);
			}
		}
		frame.getContentPane().add(panel);
		// 각 층의 40개 버튼을 생성 끝.

		// 확인 버튼 생성 시작
		JButton button = new JButton("\uD655\uC778");
		button.setBounds(514, 800, 97, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				DTO dto = new DTO(ManagerFV.carIn.getCar_num(), position, ManagerFV.carIn.getOut_time());
//				dao.insert_member(dto);
				ManagerView mv = new ManagerView();
				ManagerView.main(null);
				window.frame.setVisible(false);
			}
		});
		panel.setLayout(null);
		panel.add(button);
		// 확인 버튼 생성 끝.

		// 취소 버튼 생성 시작
		JButton bt_cancel = new JButton("취소");
		bt_cancel.setBounds(664, 800, 97, 23);
		bt_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				window.frame.setVisible(false);
			}
		});
		panel.setLayout(null);
		panel.add(bt_cancel);
		// 취소 버튼 생성 끝.

// 주차장 도로 표시 그리기 시작
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(67, 542, 1097, 10);
		panel_1.setBackground(Color.GRAY);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(67, 186, 1097, 10);
		panel_2.setBackground(Color.GRAY);
		panel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1164, 186, 10, 572);
		panel_3.setBackground(Color.GRAY);
		panel.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(1107, 758, 76, 73);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uCD9C\uAD6C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("휴먼매직체", Font.PLAIN, 32));
		lblNewLabel.setBounds(0, 10, 78, 53);
		panel_4.add(lblNewLabel);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GRAY);
		panel_5.setBounds(67, 186, 10, 582);
		panel.add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.GRAY);
		panel_6.setBounds(67, 758, 1055, 10);
		panel.add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(1191, 758, 69, 73);
		panel.add(panel_7);

		JLabel label = new JLabel("\uC785\uAD6C");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("휴먼매직체", Font.PLAIN, 32));
		label.setBounds(0, 10, 78, 53);
		panel_7.add(label);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.ORANGE);
		panel_8.setBounds(109, 714, 1109, 10);
		panel.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.ORANGE);
		panel_9.setBounds(109, 142, 10, 582);
		panel.add(panel_9);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.ORANGE);
		panel_10.setBounds(109, 498, 1109, 10);
		panel.add(panel_10);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.ORANGE);
		panel_11.setBounds(109, 142, 1120, 10);
		panel.add(panel_11);

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.ORANGE);
		panel_12.setBounds(1219, 142, 10, 616);
		panel.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.GREEN);
		panel_13.setBounds(31, 786, 37, 37);
		panel.add(panel_13);
		
		JLabel lblNewLabel_1 = new JLabel("주차 가능");
		lblNewLabel_1.setFont(new Font("돋움체", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(80, 786, 91, 33);
		panel.add(lblNewLabel_1);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.RED);
		panel_14.setBounds(190, 786, 37, 37);
		panel.add(panel_14);
		
		JLabel label_1 = new JLabel("주차 불가");
		label_1.setFont(new Font("돋움체", Font.PLAIN, 18));
		label_1.setBounds(239, 786, 91, 33);
		panel.add(label_1);
// 주차장 도로 표시 그리기 끝.
		
	}
}
