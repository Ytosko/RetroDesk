package com.srf.retro;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JList;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class news {

	public JFrame frmLeteastNews;
	private JList l2;
	private JList l1;
	DefaultListModel lx, ly;
	String macad = "";
	String ppp = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					news window = new news();
					window.frmLeteastNews.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public news() {
		initialize();
		try {
			Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
			while (networks.hasMoreElements()) {
				NetworkInterface network = networks.nextElement();
				byte[] mac = network.getHardwareAddress();
				StringBuilder sb = new StringBuilder();
				if (mac != null) {

					for (int i = 0; i < mac.length; i++) {
						sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
					}
					macad = sb.toString();
				}
			}
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		loadc();
	}

	private void loadc() {
		ly.removeAllElements();
		Connection x;
		Statement y;
		ResultSet z;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root", "");
			y = (Statement) x.createStatement();
			if (macad != null) {
				String sql = "SELECT * FROM `" + macad + "_paper`";
				y.executeQuery(sql);
				z = y.getResultSet();
				while (z.next()) {
					String line = z.getString("paper");

					int flag = 1;
					for (int i = 0; i < ly.getSize(); i++) {
						if (ly.getElementAt(i).equals(line)) {
							flag++;
						}

					}

					if (flag == 1) {
						ly.addElement(line);
					}
				}
				z.close();
				y.close();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLeteastNews = new JFrame();
		frmLeteastNews.setTitle("latest news");
		frmLeteastNews.setResizable(false);
		frmLeteastNews.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\AZLogoIcon.png"));
		frmLeteastNews.getContentPane().setBackground(Color.WHITE);
		frmLeteastNews.getContentPane().setLayout(null);
		
		lx = new DefaultListModel();
		ly = new DefaultListModel();
		
		l2 = new JList(ly);
		l2.setSelectionForeground(new Color(255, 255, 255));
		l2.setSelectionBackground(new Color(0, 128, 128));
		l2.setFixedCellHeight(30);
		l2.setFixedCellWidth(190);
		l2.setForeground(new Color(0, 0, 128));
		l2.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		l2.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		l2.setBounds(20, 39, 190, 475);
		frmLeteastNews.getContentPane().add(l2);
		
		l2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ppp = l2.getSelectedValue().toString();
				Connection x;
				Statement y;
				ResultSet z;

				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root", "");
					
					lx.removeAllElements();

					for (int j = 1; j <= 5; j++) {
						String sql = "SELECT * FROM `" + l2.getSelectedValue().toString() + "` WHERE Id ='" + j + "'";
						y = (Statement) x.createStatement();

						z = y.executeQuery(sql);

						if (z.next()) {
							int flag = 1;
							String line = z.getString("Title");
							for (int i = 0; i < lx.getSize(); i++) {
								if (lx.getElementAt(i).equals(line)) {
									flag++;
								}

							}

							if (flag == 1) {
								lx.addElement(line);
							}

						}
					}

				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		JLabel lblNewLabel = new JLabel("Choosen newspapers");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 13));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setBounds(20, 11, 190, 25);
		frmLeteastNews.getContentPane().add(lblNewLabel);
		
		l1 = new JList(lx);
		l1.setFocusTraversalKeysEnabled(false);
		l1.setFocusable(false);
		l1.setSelectionForeground(Color.WHITE);
		l1.setSelectionBackground(new Color(0, 128, 128));
		l1.setFixedCellHeight(40);
		l1.setFixedCellWidth(702);
		l1.setForeground(Color.DARK_GRAY);
		l1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 16));
		l1.setBorder(null);
		l1.setBounds(220, 39, 702, 475);
		l1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sx = l1.getSelectedIndex() + 1;
				l1.clearSelection();
				Connection x;
				Statement y;
				ResultSet z;

				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root", "");

					String sql = "SELECT * FROM `" + ppp + "` WHERE Id ='" + sx + "'";
					y = (Statement) x.createStatement();

					z = y.executeQuery(sql);

					if (z.next()) {
						System.out.println(z.getString("Url"));
						try {
							Desktop.getDesktop().browse(new URL(z.getString("Url")).toURI());
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					x.close();
					y.close();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frmLeteastNews.getContentPane().add(l1);
		frmLeteastNews.setBounds(100, 100, 951, 573);
		frmLeteastNews.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
