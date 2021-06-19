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
import javax.swing.JProgressBar;
import java.awt.Cursor;

public class revEng {

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
	DefaultListModel l1;
	int bd = 1;
	int ds = 1;
	int pa = 1;
	int kk = 1;
	int sn = 1;
	int it = 1;
	int bp = 1;
	int tot = 7;
	private JProgressBar bnpr;
	private JProgressBar indtv;
	private JProgressBar smnw;
	private JProgressBar kkn;
	private JProgressBar pal;
	private JProgressBar dst;
	private JProgressBar bdn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					revEng window = new revEng();
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
	public revEng() {
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
					Connection x12 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root",
							"");
					Statement y12 = (Statement) x12.createStatement();

					String sql112 = "CREATE TABLE IF NOT EXISTS ytosko_1.`stat` ("
							+ "  `id` int(10) NOT NULL AUTO_INCREMENT,"
							+ "  `BD News 24` int(100) NOT NULL,"
							+ "  `The Daily Star` int(100) NOT NULL,"
							+ "  `Prothom Alo` int(100) NOT NULL,"
							+ "  `Kaler Kontho` int(100) NOT NULL,"
							+ "  `Somoy News` int(100) NOT NULL,"
							+ "  `Independent TV` int(100) NOT NULL,"
							+ "  `Bangladesh Pratidin` int(100) NOT NULL,"
							+ "   PRiMARY KEY(`id`)" + ") ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT =1";

					y12.executeUpdate(sql112);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		loadfam();
	}

	private void loadfam() {
		new Thread(new Runnable() {
			public void run() {
				Connection x;
				Statement y;
				ResultSet z;

				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1",
							"root", "");
					String sql = "SELECT * FROM `stat` WHERE id = 1";
					y = (Statement) x.createStatement();

					z = y.executeQuery(sql);
					if (z.next()) {
						bd = z.getInt("BD News 24");
						tot += bd;
						ds = z.getInt("The Daily Star");
						tot += ds;
						pa = z.getInt("Prothom Alo");
						tot += pa;
						kk = z.getInt("Kaler Kontho");
						tot += kk;
						sn = z.getInt("Somoy News");
						tot += sn;
						it = z.getInt("Independent TV");
						tot += it;
						bp = z.getInt("Bangladesh Pratidin");
						tot += bp;
						
						x.close();
						y.close();

					} else {
						JOptionPane.showOptionDialog(frmChatCheese, "Invalid operation", "Error",
								JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
								new Object[] {}, null);
						x.close();
						y.close();
					}
					bnpr.setValue((int)(((double)bp/(double)tot)*100));
					indtv.setValue((int)(((double)it/(double)tot)*100));
					smnw.setValue((int)(((double)sn/(double)tot)*100));
					kkn.setValue((int)(((double)kk/(double)tot)*100));
					pal.setValue((int)(((double)pa/(double)tot)*100));
					dst.setValue((int)(((double)ds/(double)tot)*100));
					bdn.setValue((int)(((double)bd/(double)tot)*100));
					
					x.close();
					y.close();
				} catch (Exception e1) {
					System.out.println("Error here!");
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
		frmChatCheese.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmChatCheese.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		emic.setIcon(new ImageIcon("Icons\\email_30px.png"));
		emic.setBounds(654, 90, 48, 37);
		frmChatCheese.getContentPane().add(emic);

		pw = new JPasswordField();
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
		pwic.setIcon(new ImageIcon("Icons\\password_30px.png"));
		pwic.setBounds(654, 157, 48, 37);
		frmChatCheese.getContentPane().add(pwic);

		btnLogIn = new JButton("   Log In");
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
									Login window = new Login();
									window.frmChatCheese.setVisible(true);
									frmChatCheese.dispose();
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
		btnLogIn.setBounds(698, 230, 143, 45);
		frmChatCheese.getContentPane().add(btnLogIn);

		btnNeedAnAccount = new JButton("Need an account? Click here");
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

		l1 = new DefaultListModel();

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
		
		JButton btnTryMacBased = new JButton("Try mac based login");
		btnTryMacBased.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
									Login window = new Login();
									window.frmChatCheese.setVisible(true);
									frmChatCheese.dispose();
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
		});
		btnTryMacBased.setRolloverEnabled(false);
		btnTryMacBased.setRequestFocusEnabled(false);
		btnTryMacBased.setForeground(Color.BLUE);
		btnTryMacBased.setFont(new Font("Consolas", Font.BOLD, 18));
		btnTryMacBased.setIcon(new ImageIcon("Icons\\login_24px.png"));
		btnTryMacBased.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnTryMacBased.setBackground(Color.WHITE);
		btnTryMacBased.setBounds(851, 230, 252, 45);
		frmChatCheese.getContentPane().add(btnTryMacBased);
		
		bdn = new JProgressBar();
		bdn.setBorderPainted(false);
		bdn.setBorder(null);
		bdn.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		bdn.setBackground(Color.WHITE);
		bdn.setValue(25);
		bdn.setFont(new Font("MS Gothic", Font.BOLD, 15));
		bdn.setForeground(Color.ORANGE);
		bdn.setStringPainted(true);
		bdn.setBounds(172, 130, 389, 37);
		frmChatCheese.getContentPane().add(bdn);
		
		dst = new JProgressBar();
		dst.setBorderPainted(false);
		dst.setBorder(null);
		dst.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		dst.setBackground(Color.WHITE);
		dst.setValue(25);
		dst.setFont(new Font("MS Gothic", Font.BOLD, 15));
		dst.setForeground(Color.ORANGE);
		dst.setStringPainted(true);
		dst.setBounds(172, 178, 389, 37);
		frmChatCheese.getContentPane().add(dst);
		
		pal = new JProgressBar();
		pal.setBorderPainted(false);
		pal.setBorder(null);
		pal.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		pal.setBackground(Color.WHITE);
		pal.setValue(25);
		pal.setFont(new Font("MS Gothic", Font.BOLD, 15));
		pal.setForeground(Color.ORANGE);
		pal.setStringPainted(true);
		pal.setBounds(172, 230, 389, 37);
		frmChatCheese.getContentPane().add(pal);
		
		kkn = new JProgressBar();
		kkn.setBorderPainted(false);
		kkn.setBorder(null);
		kkn.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		kkn.setBackground(Color.WHITE);
		kkn.setValue(25);
		kkn.setFont(new Font("MS Gothic", Font.BOLD, 15));
		kkn.setForeground(Color.ORANGE);
		kkn.setStringPainted(true);
		kkn.setBounds(172, 278, 389, 37);
		frmChatCheese.getContentPane().add(kkn);
		
		smnw = new JProgressBar();
		smnw.setBorderPainted(false);
		smnw.setBorder(null);
		smnw.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		smnw.setBackground(Color.WHITE);
		smnw.setValue(25);
		smnw.setFont(new Font("MS Gothic", Font.BOLD, 15));
		smnw.setForeground(Color.ORANGE);
		smnw.setStringPainted(true);
		smnw.setBounds(172, 326, 389, 37);
		frmChatCheese.getContentPane().add(smnw);
		
		indtv = new JProgressBar();
		indtv.setBorderPainted(false);
		indtv.setBorder(null);
		indtv.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		indtv.setBackground(Color.WHITE);
		indtv.setValue(25);
		indtv.setFont(new Font("MS Gothic", Font.BOLD, 15));
		indtv.setForeground(Color.ORANGE);
		indtv.setStringPainted(true);
		indtv.setBounds(172, 371, 389, 37);
		frmChatCheese.getContentPane().add(indtv);
		
		bnpr = new JProgressBar();
		bnpr.setBorderPainted(false);
		bnpr.setBorder(null);
		bnpr.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		bnpr.setBackground(Color.WHITE);
		bnpr.setValue(25);
		bnpr.setFont(new Font("MS Gothic", Font.BOLD, 15));
		bnpr.setForeground(Color.ORANGE);
		bnpr.setStringPainted(true);
		bnpr.setBounds(172, 418, 389, 37);
		frmChatCheese.getContentPane().add(bnpr);
		
		JLabel lblNewLabel = new JLabel("BD News 24");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 130, 108, 37);
		frmChatCheese.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("The Daily Star");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("MS Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 178, 108, 37);
		frmChatCheese.getContentPane().add(lblNewLabel_1);
		
		JLabel lblProthomAlo = new JLabel("Prothom Alo");
		lblProthomAlo.setForeground(Color.LIGHT_GRAY);
		lblProthomAlo.setFont(new Font("MS Gothic", Font.BOLD, 14));
		lblProthomAlo.setBounds(10, 230, 108, 37);
		frmChatCheese.getContentPane().add(lblProthomAlo);
		
		JLabel lblKalerKontho = new JLabel("Kaler Kontho");
		lblKalerKontho.setForeground(Color.LIGHT_GRAY);
		lblKalerKontho.setFont(new Font("MS Gothic", Font.BOLD, 14));
		lblKalerKontho.setBounds(10, 278, 108, 37);
		frmChatCheese.getContentPane().add(lblKalerKontho);
		
		JLabel lblSomoyNews = new JLabel("Somoy News");
		lblSomoyNews.setForeground(Color.LIGHT_GRAY);
		lblSomoyNews.setFont(new Font("MS Gothic", Font.BOLD, 14));
		lblSomoyNews.setBounds(10, 326, 108, 37);
		frmChatCheese.getContentPane().add(lblSomoyNews);
		
		JLabel lblIndependentTv = new JLabel("Independent TV");
		lblIndependentTv.setForeground(Color.LIGHT_GRAY);
		lblIndependentTv.setFont(new Font("MS Gothic", Font.BOLD, 14));
		lblIndependentTv.setBounds(10, 371, 108, 37);
		frmChatCheese.getContentPane().add(lblIndependentTv);
		
		JLabel lblBangladeshPratidin = new JLabel("Bangladesh Pratidin");
		lblBangladeshPratidin.setForeground(Color.LIGHT_GRAY);
		lblBangladeshPratidin.setFont(new Font("MS Gothic", Font.BOLD, 14));
		lblBangladeshPratidin.setBounds(10, 418, 152, 37);
		frmChatCheese.getContentPane().add(lblBangladeshPratidin);
		
		JLabel lblNewLabel_2 = new JLabel("Most readed newspaper");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 71, 580, 37);
		frmChatCheese.getContentPane().add(lblNewLabel_2);
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
