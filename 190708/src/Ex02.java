import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ex02 {

	private JFrame frame;
	private JTextField textField_id;
	private JTextField textField_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex02 window = new Ex02();
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
	public Ex02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 477, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel_main = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_main, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_main, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_main, 20, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_main, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_main);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 210, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 202, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_2, -210, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, 0, SpringLayout.SOUTH, panel_1);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.WEST, panel_main);
		frame.getContentPane().add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JLabel lbl_check = new JLabel("Please check!");
		sl_panel_2.putConstraint(SpringLayout.EAST, lbl_check, -58, SpringLayout.EAST, panel_2);
		panel_2.add(lbl_check);
		
		JCheckBox chckbx_csharp = new JCheckBox("C# JCheckBox");
		sl_panel_2.putConstraint(SpringLayout.NORTH, chckbx_csharp, 74, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, lbl_check, -21, SpringLayout.NORTH, chckbx_csharp);
		sl_panel_2.putConstraint(SpringLayout.EAST, chckbx_csharp, -42, SpringLayout.EAST, panel_2);
		panel_2.add(chckbx_csharp);
		
		JCheckBox chckbx_cpp = new JCheckBox("C++ JCheckBox");
		sl_panel_2.putConstraint(SpringLayout.NORTH, chckbx_cpp, 41, SpringLayout.SOUTH, chckbx_csharp);
		sl_panel_2.putConstraint(SpringLayout.WEST, chckbx_cpp, 0, SpringLayout.WEST, chckbx_csharp);
		panel_2.add(chckbx_cpp);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbl_id);
		
		textField_id = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lbl_id, -8, SpringLayout.NORTH, textField_id);
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_id, 57, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_id, -36, SpringLayout.EAST, panel_1);
		panel_1.add(textField_id);
		textField_id.setColumns(10);
		
		//getText() 해당 컴코넌트 안에 담긴 텍스트 가져올 때
		System.out.println(lbl_id.getText());
		//setText() 컴포넌트 안의 텍스트를 변경할 때
		lbl_id.setText("hello world");
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_1.putConstraint(SpringLayout.EAST, lbl_id, 0, SpringLayout.EAST, lbl_password);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lbl_password, -74, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lbl_password, -65, SpringLayout.EAST, panel_1);
		panel_1.add(lbl_password);
		
		textField_password = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField_password, 6, SpringLayout.SOUTH, lbl_password);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_password, 0, SpringLayout.EAST, textField_id);
		panel_1.add(textField_password);
		textField_password.setColumns(10);
		
		JButton btn_Ok = new JButton("OK");
		btn_Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String txt1 = textField_id.getText();
				lbl_id.setText(txt1);
				String txt2 = textField_password.getText();
				lbl_password.setText(txt2);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btn_Ok, 28, SpringLayout.SOUTH, panel_2);
		springLayout.putConstraint(SpringLayout.WEST, btn_Ok, 204, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btn_Ok);
	}
}
