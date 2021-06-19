package com.srf.retro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Cursor;
import java.awt.Window.Type;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JProgressBar;

public class Welcome {

	public JFrame frame;
	private JLabel icon;
	public int x = 0;
	private JProgressBar load;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
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
	public Welcome() {
		initialize();
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                x = x+1;
                if(x<100){
                    load.setValue(x);
                    
                }else if(x == 100){
                   
                   frame.dispose();
                   revEng window = new revEng();
					window.frmChatCheese.setVisible(true);
                   
                }
            }
        }, 0, 10, TimeUnit.MILLISECONDS);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\AZLogoIcon.png"));
		frame.setName("mainframe");
		frame.setResizable(false);
		frame.getContentPane().setIgnoreRepaint(true);
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		frame.getContentPane().setLayout(null);
		
		
		icon = new JLabel("");
		icon.setBounds(234, 64, 210, 218);
		frame.getContentPane().add(icon);
		frame.setBounds(100, 100, 726, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ImageIcon iconx = new ImageIcon("Icons\\AZSLogo.png");
	    Image img = iconx.getImage();
	    Image imsc = img.getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon newimg = new ImageIcon(imsc);
	    icon.setIcon(newimg);
	    
	    JLabel lblNewLabel = new JLabel("A desktop version of RetroNews");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 12));
	    lblNewLabel.setForeground(new Color(0, 0, 51));
	    lblNewLabel.setBounds(205, 293, 252, 14);
	    frame.getContentPane().add(lblNewLabel);
	    
	    load = new JProgressBar();
	    load.setForeground(new Color(51, 153, 153));
	    load.setBounds(53, 404, 605, 27);
	    frame.getContentPane().add(load);
	    
	}
}
