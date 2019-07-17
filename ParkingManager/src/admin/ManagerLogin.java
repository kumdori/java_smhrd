package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

//import car.DTO;
import car.DAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerLogin {
	static ManagerLogin window;
	private JFrame frame;
	private JTextField txt_ID;
	private JTextField txt_PW;
	DAO dao = new DAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ManagerLogin();
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
	public ManagerLogin() {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(34, 57, 400, 454);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_Login = new JLabel("");
		lbl_Login.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\Login.jpg"));
		lbl_Login.setBounds(-61, 0, 504, 511);
		panel_1.add(lbl_Login);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(485, 83, 150, 373);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_ID = new JLabel("\uAD00\uB9AC\uC790 ID");
		lbl_ID.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ID.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 17));
		lbl_ID.setBounds(12, 10, 103, 42);
		panel.add(lbl_ID);
		
		JLabel lbl_PW = new JLabel("\uAD00\uB9AC\uC790 PW");
		lbl_PW.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_PW.setFont(new Font("나눔스퀘어라운드 Bold", Font.PLAIN, 17));
		lbl_PW.setBounds(12, 162, 103, 42);
		panel.add(lbl_PW);
		
		txt_ID = new JTextField();
		txt_ID.setBounds(12, 51, 116, 42);
		panel.add(txt_ID);
		txt_ID.setColumns(10);
		
		txt_PW = new JTextField();
		txt_PW.setColumns(10);
		txt_PW.setBounds(12, 202, 116, 42);
		panel.add(txt_PW);
		
		JButton btn_ok = new JButton("");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagerAdd manager = new ManagerAdd();
				manager.main(null);
				window.frame.setVisible(false);
			}
		});
		btn_ok.setBorderPainted(false);
		btn_ok.setForeground(Color.WHITE);
		btn_ok.setBackground(Color.WHITE);
		btn_ok.setIcon(new ImageIcon("D:\\한종대\\Java Workspace\\ParkingManager\\pics\\LoginButton.jpg"));
		btn_ok.setBounds(50, 281, 48, 42);
		panel.add(btn_ok);
	}

}
