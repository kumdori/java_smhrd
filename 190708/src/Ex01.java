import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Ex01 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex01 window = new Ex01();
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
	public Ex01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 582, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		Ex03 dial = new Ex03();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 421, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 275, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lbl_helloworld = new JLabel("Hello World!");
		lbl_helloworld.setForeground(Color.RED);
		lbl_helloworld.setBackground(Color.BLACK);
		lbl_helloworld.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_helloworld.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		panel.add(lbl_helloworld);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, -275, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 421, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btn_ok = new JButton("확인");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dial.setVisible(true);
				
			}
		});
		btn_ok.setBackground(Color.YELLOW);
		panel_1.add(btn_ok);
		
		JButton btn_cancel = new JButton("취소");
		panel_1.add(btn_cancel);
	}
}
