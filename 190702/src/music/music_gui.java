package music;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class music_gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					music_gui window = new music_gui();
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
	public music_gui() {
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
		MusicCon con = new MusicCon();
		
		JPanel panel_info = new JPanel();
		panel_info.setBackground(Color.PINK);
		springLayout.putConstraint(SpringLayout.NORTH, panel_info, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_info, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_info, 127, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_info, 424, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_info);
		panel_info.setLayout(new CardLayout(0, 0));
		
		JPanel panel_control = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_control, 6, SpringLayout.SOUTH, panel_info);
		springLayout.putConstraint(SpringLayout.WEST, panel_control, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_control, 124, SpringLayout.SOUTH, panel_info);
		springLayout.putConstraint(SpringLayout.EAST, panel_control, 0, SpringLayout.EAST, panel_info);
		
		JLabel lbl_musicInfo = new JLabel("Music Info");
		lbl_musicInfo.setBackground(Color.WHITE);
		lbl_musicInfo.setFont(new Font("Georgia", Font.BOLD, 20));
		lbl_musicInfo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_info.add(lbl_musicInfo, "name_1199671015711900");
		frame.getContentPane().add(panel_control);
		panel_control.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btn_backward = new JButton("◀◀");
		panel_control.add(btn_backward);
		
		JButton btn_play = new JButton("▶");
		btn_play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lbl_musicInfo.setText(con.toString());
				con.playSong();
				
			}
		});
		panel_control.add(btn_play);
		
		JButton btn_stop = new JButton("■");
		btn_stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				con.mp3.stop();
			}
		});
		btn_stop.setBackground(Color.GRAY);
		panel_control.add(btn_stop);
		
		JButton btn_forward = new JButton("▶▶");
		btn_forward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lbl_musicInfo.setText(con.toString());
				con.playNext();
			}
		});
		panel_control.add(btn_forward);
	}

}
