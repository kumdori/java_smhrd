import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class phoneDial extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel_1;
	private JTextField text_name;
	private JTextField text_age;
	private JTextField text_phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			phoneDial dialog = new phoneDial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public phoneDial() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			panel_1 = new JPanel();
			sl_contentPanel.putConstraint(SpringLayout.WEST, panel_1, 5, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, contentPanel);
			panel_1.setBackground(Color.GRAY);
			sl_contentPanel.putConstraint(SpringLayout.NORTH, panel_1, 5, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, panel_1, 70, SpringLayout.NORTH, contentPanel);
			contentPanel.add(panel_1);
		}
		{
			JPanel panel = new JPanel();
			sl_contentPanel.putConstraint(SpringLayout.NORTH, panel, 1, SpringLayout.SOUTH, panel_1);
			sl_contentPanel.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, panel_1);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, panel, -5, SpringLayout.SOUTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPanel);
			SpringLayout sl_panel_1 = new SpringLayout();
			panel_1.setLayout(sl_panel_1);
			{
				JLabel lblNewLabel = new JLabel("전화번호 등록");
				sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, -55, SpringLayout.SOUTH, panel_1);
				sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, -10, SpringLayout.SOUTH, panel_1);
				sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, -138, SpringLayout.EAST, panel_1);
				lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
				panel_1.add(lblNewLabel);
			}
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(Color.PINK);
				panel.add(panel_2);
			}
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(Color.ORANGE);
				panel.add(panel_2);
				SpringLayout sl_panel_2 = new SpringLayout();
				panel_2.setLayout(sl_panel_2);
				
				text_name = new JTextField();
				sl_panel_2.putConstraint(SpringLayout.NORTH, text_name, 20, SpringLayout.NORTH, panel_2);
				sl_panel_2.putConstraint(SpringLayout.WEST, text_name, 46, SpringLayout.WEST, panel_2);
				panel_2.add(text_name);
				text_name.setColumns(10);
				
				text_age = new JTextField();
				sl_panel_2.putConstraint(SpringLayout.WEST, text_age, 0, SpringLayout.WEST, text_name);
				panel_2.add(text_age);
				text_age.setColumns(10);
				
				text_phone = new JTextField();
				sl_panel_2.putConstraint(SpringLayout.NORTH, text_phone, 92, SpringLayout.NORTH, panel_2);
				sl_panel_2.putConstraint(SpringLayout.SOUTH, text_age, -13, SpringLayout.NORTH, text_phone);
				sl_panel_2.putConstraint(SpringLayout.WEST, text_phone, 0, SpringLayout.WEST, text_name);
				panel_2.add(text_phone);
				text_phone.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						PhoneDAO dao = new PhoneDAO();
						dao.insert(text_name.getText(), Integer.parseInt(text_age.getText()), text_phone.getText());
						setVisible(false);
						PhoneGUI gui = new PhoneGUI();
						gui.main(null);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
