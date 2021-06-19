package com.srf.retro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Enumeration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.ListSelectionModel;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;

public class Login {

	public JFrame frmChatCheese;
	private JTextField em;
	private JButton btnNeedAnAccount;
	private JButton btnLogOut;
	String macad;
	private JLabel emic;
	private JLabel pwic;
	private JPasswordField pw;
	private JButton btnLogIn;
	private JLabel hilb;
	JOptionPane JOptionPanex;
	int def = 0;
	private JList head;
	private JButton btnNewButton;
	DefaultListModel l1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmChatCheese.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		loadhead();

		new Thread(new Runnable() {
			public void run() {
				ToSystemTrayAction atr = new ToSystemTrayAction();
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
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

				} catch (SocketException e11) {
					e11.printStackTrace();
				}

				if (macad != null) {
					Connection x;
					Statement y;
					ResultSet z;
					try {

						Class.forName("com.mysql.jdbc.Driver").newInstance();
						x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root",
								"");
						String sql = "SELECT * FROM `LogINX` WHERE mac ='" + macad + "'";
						y = (Statement) x.createStatement();

						z = y.executeQuery(sql);

						try {
							Connection x12 = (Connection) DriverManager
									.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root", "");
							Statement y12 = (Statement) x12.createStatement();

							String sql112 = "CREATE TABLE IF NOT EXISTS ytosko_1.`" + macad + "_Saved` ("
									+ "  `INDEX` int(10) NOT NULL AUTO_INCREMENT," + "  `CHATS` varchar(100) NOT NULL,"
									+ "  `MESSAGES` text NOT NULL," + "   PRiMARY KEY(`INDEX`)"
									+ ") ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT =1";

							y12.executeUpdate(sql112);
							System.out.println("Saved directorry created!");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						DatabaseMetaData dbm = (DatabaseMetaData) x.getMetaData();
						ResultSet tables = dbm.getTables(null, null, macad, null);

						if (tables.next()) {

						} else {

							Connection x1 = (Connection) DriverManager
									.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root", "");
							Statement y1 = (Statement) x1.createStatement();

							String sql1 = "CREATE TABLE IF NOT EXISTS ytosko_1.`" + macad + "` ("
									+ "  `INDEX` int(10) NOT NULL AUTO_INCREMENT," + "  `CHATS` varchar(100) NOT NULL,"
									+ "   PRiMARY KEY(`INDEX`)"
									+ ") ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT =1";

							y1.executeUpdate(sql1);

						}
						if (z.next()) {
							Font font1 = new Font("SansSerif", Font.BOLD, 32);
							emic.setVisible(false);
							pwic.setVisible(false);
							pw.setVisible(false);
							btnLogIn.setVisible(false);
							btnNeedAnAccount.setVisible(false);
							em.setBorder(null);
							em.setEditable(false);
							em.setText(z.getString("name"));
							em.setHorizontalAlignment(SwingConstants.CENTER);
							em.setBackground(null);
							em.setFont(font1);
							hilb.setVisible(true);
							hilb.setText("This is an automated log in based on your MAC address");
							x.close();
							y.close();

						} else {
							JOptionPane.showOptionDialog(frmChatCheese, "Wrong Credentials", "Error",
									JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {},
									null);
							x.close();
							y.close();
						}
						x.close();
						y.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				} else {

				}
			}
		}).start();

	}

	private void loadhead() {
		Connection x;
		Statement y;
		ResultSet z;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root", "");

			for (int j = 1; j <= 5; j++) {
				String sql = "SELECT * FROM `headlines` WHERE Id ='" + j + "'";
				y = (Statement) x.createStatement();

				z = y.executeQuery(sql);

				if (z.next()) {
					int flag = 1;
					String line = z.getString("Title");
					for (int i = 0; i < l1.getSize(); i++) {
						if (l1.getElementAt(i).equals(line)) {
							flag++;
						}

					}

					if (flag == 1) {
						l1.addElement(line);
					}

				}
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
		frmChatCheese = new JFrame();
		frmChatCheese.getContentPane().setBackground(Color.WHITE);
		frmChatCheese.getContentPane().setLayout(null);

		JLabel lblWelcomeToChat = new JLabel("Welcome to AZ News V1");
		lblWelcomeToChat.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToChat.setForeground(Color.RED);
		lblWelcomeToChat.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblWelcomeToChat.setEnabled(false);
		lblWelcomeToChat.setBounds(10, 11, 1184, 37);
		frmChatCheese.getContentPane().add(lblWelcomeToChat);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.GRAY);
		separator.setBounds(600, 90, 8, 395);
		frmChatCheese.getContentPane().add(separator);

		em = new JTextField();
		em.setToolTipText("Email");
		em.setName("Email");
		em.setSelectionColor(Color.BLUE);
		em.setForeground(Color.BLUE);
		em.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		em.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		em.setBounds(698, 90, 405, 37);
		frmChatCheese.getContentPane().add(em);
		em.setColumns(10);

		emic = new JLabel("");
		emic.setVisible(false);
		emic.setIcon(new ImageIcon("Icons\\email_30px.png"));
		emic.setBounds(654, 90, 48, 37);
		frmChatCheese.getContentPane().add(emic);

		pw = new JPasswordField();
		pw.setVisible(false);
		pw.setToolTipText("Email");
		pw.setSelectionColor(Color.BLUE);
		pw.setName("Password");
		pw.setForeground(Color.BLUE);
		pw.setFont(new Font("Sitka Subheading", Font.PLAIN, 15));
		pw.setColumns(10);
		pw.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		pw.setBounds(698, 157, 405, 37);
		frmChatCheese.getContentPane().add(pw);

		pwic = new JLabel("");
		pwic.setVisible(false);
		pwic.setIcon(new ImageIcon("Icons\\password_30px.png"));
		pwic.setBounds(654, 157, 48, 37);
		frmChatCheese.getContentPane().add(pwic);

		btnLogIn = new JButton("   Log In");
		btnLogIn.setVisible(false);
		btnLogIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String email = em.getText().toString().trim();
				String password = new String(pw.getPassword());
				if (email != null && password != null) {

					new Thread(new Runnable() {
						public void run() {
							Connection x;
							Statement y;
							ResultSet z;
							String user1 = email;
							String pass1 = password;

							try {
								Class.forName("com.mysql.jdbc.Driver").newInstance();
								x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1",
										"root", "");
								String sql = "SELECT * FROM `LogINX` WHERE email ='" + user1 + "' AND password ='"
										+ pass1 + "'";
								y = (Statement) x.createStatement();

								z = y.executeQuery(sql);
								if (z.next()) {
									Font font1 = new Font("SansSerif", Font.BOLD, 32);
									emic.setVisible(false);
									pwic.setVisible(false);
									pw.setVisible(false);
									btnLogIn.setVisible(false);
									btnNeedAnAccount.setVisible(false);
									em.setBorder(null);
									em.setEditable(false);
									em.setText(z.getString("name"));
									em.setHorizontalAlignment(SwingConstants.CENTER);
									em.setBackground(null);
									em.setFont(font1);
									btnLogOut.setVisible(true);

									x.close();
									y.close();

								} else {
									JOptionPane.showOptionDialog(frmChatCheese, "Wrong Credentials", "Error",
											JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
											new Object[] {}, null);
									x.close();
									y.close();
								}
								x.close();
								y.close();
							} catch (Exception e1) {
								System.out.println("Error here!");
							}
						}
					}).start();

				} else {
					JOptionPane.showOptionDialog(frmChatCheese, "Wrong Credentials", "Error",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] {}, null);
				}

			}
		});

		btnLogIn.setRolloverEnabled(false);
		btnLogIn.setRequestFocusEnabled(false);
		btnLogIn.setIcon(new ImageIcon("Icons\\login_24px.png"));
		btnLogIn.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLogIn.setForeground(Color.BLUE);
		btnLogIn.setFont(new Font("Consolas", Font.BOLD, 18));
		btnLogIn.setBackground(Color.WHITE);
		btnLogIn.setBounds(824, 232, 143, 45);
		frmChatCheese.getContentPane().add(btnLogIn);

		btnNeedAnAccount = new JButton("Need an account? Click here");
		btnNeedAnAccount.setVisible(false);
		btnNeedAnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regi az = new regi();
				az.frmChatcheeseRegistration.setVisible(true);
			}
		});
		btnNeedAnAccount.setFocusTraversalKeysEnabled(false);
		btnNeedAnAccount.setFocusPainted(false);
		btnNeedAnAccount.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNeedAnAccount.setForeground(Color.GRAY);
		btnNeedAnAccount.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNeedAnAccount.setBackground(Color.WHITE);
		btnNeedAnAccount.setBounds(755, 337, 313, 37);
		frmChatCheese.getContentPane().add(btnNeedAnAccount);

		JButton btnJoinChat = new JButton("Leatest News");
		btnJoinChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				news window = new news();
				window.frmLeteastNews.setVisible(true);
			}
		});
		btnJoinChat.setHorizontalAlignment(SwingConstants.LEFT);

		btnJoinChat.setFocusTraversalKeysEnabled(false);
		btnJoinChat.setFocusPainted(false);
		btnJoinChat.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnJoinChat.setBackground(Color.WHITE);
		btnJoinChat.setForeground(Color.BLUE);
		btnJoinChat.setFont(new Font("Courier New", Font.BOLD, 15));
		btnJoinChat.setIcon(new ImageIcon("Icons\\joyent_60px.png"));
		btnJoinChat.setBounds(99, 90, 215, 53);
		frmChatCheese.getContentPane().add(btnJoinChat);

		JButton btnCreateChat = new JButton("Choose Newspaper");
		btnCreateChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nchooser window = new nchooser();
				window.frmNewspaperChooser.setVisible(true);

			}
		});
		btnCreateChat.setHorizontalAlignment(SwingConstants.LEFT);

		btnCreateChat.setIcon(new ImageIcon("Icons\\create_60px.png"));
		btnCreateChat.setForeground(Color.BLUE);
		btnCreateChat.setFont(new Font("Courier New", Font.BOLD, 15));
		btnCreateChat.setFocusTraversalKeysEnabled(false);
		btnCreateChat.setFocusPainted(false);
		btnCreateChat.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnCreateChat.setBackground(Color.WHITE);
		btnCreateChat.setBounds(338, 90, 215, 53);
		frmChatCheese.getContentPane().add(btnCreateChat);

		JButton btnSavedChats = new JButton("Weather");
		btnSavedChats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URL("https://www.yahoo.com/news/weather").toURI());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSavedChats.setHorizontalAlignment(SwingConstants.LEFT);
		btnSavedChats.setIcon(new ImageIcon("Icons\\save_all_60px.png"));
		btnSavedChats.setForeground(Color.BLUE);
		btnSavedChats.setFont(new Font("Courier New", Font.BOLD, 15));
		btnSavedChats.setFocusTraversalKeysEnabled(false);
		btnSavedChats.setFocusPainted(false);
		btnSavedChats.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSavedChats.setBackground(Color.WHITE);
		btnSavedChats.setBounds(99, 162, 215, 53);
		frmChatCheese.getContentPane().add(btnSavedChats);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(99, 281, 454, 21);
		frmChatCheese.getContentPane().add(separator_1);

		JLabel lblRecentChats = new JLabel("Headlines");
		lblRecentChats.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblRecentChats.setEnabled(false);
		lblRecentChats.setBounds(99, 247, 215, 30);
		frmChatCheese.getContentPane().add(lblRecentChats);

		l1 = new DefaultListModel();
		head = new JList(l1);
		head.setValueIsAdjusting(true);
		head.setRequestFocusEnabled(false);
		head.setFocusable(false);
		head.setFixedCellHeight(30);
		head.setFixedCellWidth(454);
		head.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		head.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		head.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		head.setBounds(new Rectangle(0, 0, 454, 50));
		head.setSelectionBackground(Color.WHITE);
		head.setSelectionForeground(SystemColor.menu);
		head.setBackground(Color.WHITE);
		head.setVisibleRowCount(6);
		head.setFont(new Font("Sitka Text", Font.ITALIC, 14));
		head.setForeground(SystemColor.windowBorder);
		head.setBounds(99, 288, 454, 197);
		head.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int s = head.getSelectedIndex() + 1;
				head.clearSelection();
				Connection x;
				Statement y;
				ResultSet z;

				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root", "");

					String sql = "SELECT * FROM `headlines` WHERE Id ='" + s + "'";
					y = (Statement) x.createStatement();

					z = y.executeQuery(sql);

					if (z.next()) {
						try {
							Desktop.getDesktop().browse(new URL(z.getString("Url")).toURI());
						} catch (Exception e1) {
							e1.printStackTrace();
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
		JScrollPane xiu = new JScrollPane(head);
		xiu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		xiu.setBorder(new EmptyBorder(0, 0, 0, 0));
		xiu.setBounds(99, 288, 454, 197);
		frmChatCheese.getContentPane().add(xiu);

		btnLogOut = new JButton("   Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome rez = new Welcome();
				rez.frame.setVisible(true);
				frmChatCheese.dispose();
			}
		});
		btnLogOut.setVisible(false);
		btnLogOut.setIcon(new ImageIcon("Icons\\logout_rounded_up_26px.png"));
		btnLogOut.setRolloverEnabled(false);
		btnLogOut.setRequestFocusEnabled(false);
		btnLogOut.setForeground(Color.BLUE);
		btnLogOut.setFont(new Font("Consolas", Font.BOLD, 18));
		btnLogOut.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setBounds(824, 418, 143, 45);
		frmChatCheese.getContentPane().add(btnLogOut);

		hilb = new JLabel("");
		hilb.setIcon(new ImageIcon("Icons\\warning_shield_30px.png"));
		hilb.setVisible(false);
		hilb.setHorizontalAlignment(SwingConstants.CENTER);
		hilb.setForeground(Color.DARK_GRAY);
		hilb.setFont(new Font("MS Gothic", Font.BOLD, 14));
		hilb.setBounds(654, 288, 449, 38);
		frmChatCheese.getContentPane().add(hilb);

		JButton btnExit = new JButton("Exit");
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setIcon(new ImageIcon("Icons\\exit_60px.png"));
		btnExit.setForeground(Color.BLUE);
		btnExit.setFont(new Font("Courier New", Font.BOLD, 15));
		btnExit.setFocusTraversalKeysEnabled(false);
		btnExit.setFocusPainted(false);
		btnExit.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(338, 162, 215, 53);
		frmChatCheese.getContentPane().add(btnExit);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadhead();
			}
		});
		btnNewButton.setIcon(new ImageIcon("Icons\\refresh_20px.png"));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(184, 247, 48, 30);
		frmChatCheese.getContentPane().add(btnNewButton);
		frmChatCheese.setType(Type.POPUP);
		frmChatCheese.setTitle("AZ News");
		frmChatCheese.setResizable(false);
		frmChatCheese.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\chat_96px.png"));
		frmChatCheese.setForeground(Color.WHITE);
		frmChatCheese.setBackground(Color.WHITE);
		frmChatCheese.setBounds(100, 100, 1210, 580);
		frmChatCheese.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
