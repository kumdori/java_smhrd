package car;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WarnPosition {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarnPosition window = new WarnPosition();
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
	public WarnPosition() {
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
		
		JLabel label = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, label, 169, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label, 114, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, label, 169, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, 188, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("이미 다른 차가 주차된 공간입니다.");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -28, SpringLayout.EAST, frame.getContentPane());
		lblNewLabel.setFont(new Font("HY견명조", Font.PLAIN, 24));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("다른 공간을 선택해 주세요.");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -30, SpringLayout.NORTH, label_1);
		springLayout.putConstraint(SpringLayout.SOUTH, label_1, -25, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.EAST, label_1, -68, SpringLayout.EAST, frame.getContentPane());
		label_1.setFont(new Font("HY견명조", Font.PLAIN, 24));
		frame.getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 17, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 163, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -30, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -147, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
	}
}
