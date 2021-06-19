package com.srf.retroadmin;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class portal {

	private JFrame frmAdminPortal;
	private JList l2;
	DefaultListModel lx, ly;
	private JTextArea url1;
	private JTextArea title2;
	private JTextArea title3;
	private JTextArea title4;
	private JTextArea title5;
	private JTextArea url2;
	private JTextArea url3;
	private JTextArea url4;
	private JTextArea url5;
	private JTextArea title1;

	String t1 = "";
	String t2 = "";
	String t3 = "";
	String t4 = "";
	String t5 = "";

	String u1 = "";
	String u2 = "";
	String u3 = "";
	String u4 = "";
	String u5 = "";

	String s = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					portal window = new portal();
					window.frmAdminPortal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public portal() {
		initialize();
		loadc();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void loadc() {
		lx.removeAllElements();
		lx.addElement("BD News 24");
		lx.addElement("The Daily Star");
		lx.addElement("Prothom Alo");
		lx.addElement("Kaler Kontho");
		lx.addElement("Somoy News");
		lx.addElement("Independent TV");
		lx.addElement("Bangladesh Pratidin");
		lx.addElement("Headlines");


	}

	private void initialize() {
		frmAdminPortal = new JFrame();
		frmAdminPortal.getContentPane().setBackground(Color.WHITE);
		frmAdminPortal.getContentPane().setLayout(null);

		lx = new DefaultListModel();

		l2 = new JList(lx);
		l2.setSelectionForeground(Color.WHITE);
		l2.setSelectionBackground(new Color(0, 128, 128));
		l2.setForeground(new Color(0, 0, 128));
		l2.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		l2.setFixedCellWidth(190);
		l2.setFixedCellHeight(30);
		l2.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		l2.setBounds(10, 41, 190, 475);
		l2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s = l2.getSelectedValue().toString();
			}
		});
		frmAdminPortal.getContentPane().add(l2);

		JLabel lblNewLabel = new JLabel("Choose Newspaper");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Perpetua", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 16, 149, 14);
		frmAdminPortal.getContentPane().add(lblNewLabel);

		title1 = new JTextArea();
		title1.setForeground(new Color(0, 0, 0));
		title1.setAlignmentY(Component.TOP_ALIGNMENT);
		title1.setWrapStyleWord(true);
		title1.setLineWrap(true);
		title1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		title1.setBounds(0, 0, 199, 95);

		JScrollPane xiu = new JScrollPane(title1);
		xiu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		xiu.setBorder(new EmptyBorder(0, 0, 0, 0));
		xiu.setBounds(210, 78, 296, 63);
		frmAdminPortal.getContentPane().add(xiu);

		url1 = new JTextArea();
		url1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		url1.setFont(new Font("Monospaced", Font.BOLD, 13));
		url1.setForeground(new Color(0, 0, 255));
		url1.setLineWrap(true);
		url1.setBounds(216, 248, 653, 131);
		JScrollPane xiu1 = new JScrollPane(url1);
		xiu1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		xiu1.setBorder(new EmptyBorder(0, 0, 0, 0));
		xiu1.setBounds(532, 78, 301, 63);
		frmAdminPortal.getContentPane().add(xiu1);

		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblNewLabel_1.setBounds(216, 53, 46, 14);
		frmAdminPortal.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("URL");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(535, 49, 46, 14);
		frmAdminPortal.getContentPane().add(lblNewLabel_1_1);

		JScrollPane xiu_1 = new JScrollPane((Component) null);
		xiu_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		xiu_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		xiu_1.setBounds(210, 152, 296, 63);
		frmAdminPortal.getContentPane().add(xiu_1);

		title2 = new JTextArea();
		title2.setWrapStyleWord(true);
		title2.setLineWrap(true);
		title2.setForeground(Color.BLACK);
		title2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		title2.setAlignmentY(0.0f);
		xiu_1.setViewportView(title2);

		JScrollPane xiu_1_1 = new JScrollPane((Component) null);
		xiu_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		xiu_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		xiu_1_1.setBounds(210, 226, 296, 63);
		frmAdminPortal.getContentPane().add(xiu_1_1);

		title3 = new JTextArea();
		title3.setWrapStyleWord(true);
		title3.setLineWrap(true);
		title3.setForeground(Color.BLACK);
		title3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		title3.setAlignmentY(0.0f);
		xiu_1_1.setViewportView(title3);

		JScrollPane xiu_1_1_1 = new JScrollPane((Component) null);
		xiu_1_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		xiu_1_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		xiu_1_1_1.setBounds(210, 300, 296, 63);
		frmAdminPortal.getContentPane().add(xiu_1_1_1);

		title4 = new JTextArea();
		title4.setWrapStyleWord(true);
		title4.setLineWrap(true);
		title4.setForeground(Color.BLACK);
		title4.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		title4.setAlignmentY(0.0f);
		xiu_1_1_1.setViewportView(title4);

		JScrollPane xiu_1_1_1_1 = new JScrollPane((Component) null);
		xiu_1_1_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		xiu_1_1_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		xiu_1_1_1_1.setBounds(210, 374, 296, 63);
		frmAdminPortal.getContentPane().add(xiu_1_1_1_1);

		title5 = new JTextArea();
		title5.setWrapStyleWord(true);
		title5.setLineWrap(true);
		title5.setForeground(Color.BLACK);
		title5.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		title5.setAlignmentY(0.0f);
		xiu_1_1_1_1.setViewportView(title5);

		JScrollPane xiu1_1 = new JScrollPane((Component) null);
		xiu1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		xiu1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		xiu1_1.setBounds(532, 152, 301, 63);
		frmAdminPortal.getContentPane().add(xiu1_1);

		url2 = new JTextArea();
		url2.setLineWrap(true);
		url2.setForeground(Color.BLUE);
		url2.setFont(new Font("Monospaced", Font.BOLD, 13));
		url2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		xiu1_1.setViewportView(url2);

		JScrollPane xiu1_2 = new JScrollPane((Component) null);
		xiu1_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		xiu1_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		xiu1_2.setBounds(532, 226, 301, 63);
		frmAdminPortal.getContentPane().add(xiu1_2);

		url3 = new JTextArea();
		url3.setLineWrap(true);
		url3.setForeground(Color.BLUE);
		url3.setFont(new Font("Monospaced", Font.BOLD, 13));
		url3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		xiu1_2.setViewportView(url3);

		JScrollPane xiu1_3 = new JScrollPane((Component) null);
		xiu1_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		xiu1_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		xiu1_3.setBounds(532, 300, 301, 63);
		frmAdminPortal.getContentPane().add(xiu1_3);

		url4 = new JTextArea();
		url4.setLineWrap(true);
		url4.setForeground(Color.BLUE);
		url4.setFont(new Font("Monospaced", Font.BOLD, 13));
		url4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		xiu1_3.setViewportView(url4);

		JScrollPane xiu1_4 = new JScrollPane((Component) null);
		xiu1_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		xiu1_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		xiu1_4.setBounds(532, 374, 301, 63);
		frmAdminPortal.getContentPane().add(xiu1_4);

		url5 = new JTextArea();
		url5.setLineWrap(true);
		url5.setForeground(Color.BLUE);
		url5.setFont(new Font("Monospaced", Font.BOLD, 13));
		url5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		xiu1_4.setViewportView(url5);

		JButton btnNewButton = new JButton("Publish");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				t1 = title1.getText().toString().trim();
				t2 = title2.getText().toString().trim();
				t3 = title3.getText().toString().trim();
				t4 = title4.getText().toString().trim();
				t5 = title5.getText().toString().trim();

				u1 = url1.getText().toString().trim();
				u2 = url2.getText().toString().trim();
				u3 = url3.getText().toString().trim();
				u4 = url4.getText().toString().trim();
				u5 = url5.getText().toString().trim();

				if (t1.equals("") || t2.equals("") || t3.equals("") || t4.equals("") || t5.equals("") || u1.equals("")
						|| u2.equals("") || u3.equals("") || u4.equals("") || u5.equals("")) {
					JOptionPane.showMessageDialog(frmAdminPortal, "Title and urls are not filled well!", "Error",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (s.equals("")) {
						JOptionPane.showMessageDialog(frmAdminPortal, "Target newspaper is not selected well!", "Error",
								JOptionPane.WARNING_MESSAGE);
					} else {

						Connection x;
						Statement y;

						try {
							x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root",
									"");
							DatabaseMetaData dbm = (DatabaseMetaData) x.getMetaData();
							ResultSet tables = dbm.getTables(null, null, s, null);

							if (tables.next()) {

								Connection x1 = (Connection) DriverManager
										.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root", "");
								Statement y1 = (Statement) x1.createStatement();

								String sql1x = "DROP TABLE `" + s + "`";

								y1.executeUpdate(sql1x);

								String sql1 = "CREATE TABLE IF NOT EXISTS ytosko_1.`" + s + "` ("
										+ "  `Id` int(10) NOT NULL AUTO_INCREMENT,"
										+ "  `Title` text NOT NULL," + "  `Url` text NOT NULL,"
										+ "   PRiMARY KEY(`Id`)"
										+ ") ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT =1";

								y1.executeUpdate(sql1);

							} else {

								try {
									Connection x1 = (Connection) DriverManager
											.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root", "");
									Statement y1 = (Statement) x1.createStatement();

									String sql1 = "CREATE TABLE IF NOT EXISTS ytosko_1.`" + s + "` ("
											+ "  `Id` int(10) NOT NULL AUTO_INCREMENT,"
											+ "  `Title` text NOT NULL," + "  `Url` text NOT NULL,"
											+ "   PRiMARY KEY(`Id`)"
											+ ") ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT =1";

									y1.executeUpdate(sql1);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							try {
								Class.forName("com.mysql.jdbc.Driver").newInstance();
								x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1",
										"root", "");
								y = (Statement) x.createStatement();
								String sql = ("INSERT INTO `" + s + "`(Title,Url)" + "VALUES (?,?)");

								PreparedStatement preparedStatement = (PreparedStatement) x.prepareStatement(sql);
								preparedStatement.setString(1, t1);
								preparedStatement.setString(2, u1);
								preparedStatement.executeUpdate();
								String sql1 = ("INSERT INTO `" + s + "`(Title,Url)" + "VALUES (?,?)");

								PreparedStatement preparedStatement1 = (PreparedStatement) x.prepareStatement(sql1);
								preparedStatement1.setString(1, t2);
								preparedStatement1.setString(2, u2);
								preparedStatement1.executeUpdate();
								String sql11 = ("INSERT INTO `" + s + "`(Title,Url)" + "VALUES (?,?)");

								PreparedStatement preparedStatement11 = (PreparedStatement) x.prepareStatement(sql11);
								preparedStatement11.setString(1, t3);
								preparedStatement11.setString(2, u3);
								preparedStatement11.executeUpdate();
								String sql111 = ("INSERT INTO `" + s + "`(Title,Url)" + "VALUES (?,?)");

								PreparedStatement preparedStatement111 = (PreparedStatement) x.prepareStatement(sql111);
								preparedStatement111.setString(1, t4);
								preparedStatement111.setString(2, u4);
								preparedStatement111.executeUpdate();
								String sql1111 = ("INSERT INTO `" + s + "`(Title,Url)" + "VALUES (?,?)");

								PreparedStatement preparedStatement1111 = (PreparedStatement) x.prepareStatement(sql1111);
								preparedStatement1111.setString(1, t5);
								preparedStatement1111.setString(2, u5);
								preparedStatement1111.executeUpdate();
								
								x.close();
								y.close();
								s = "";
								t1 = "";
								t2 = "";
								t3 = "";
								t4 = "";
								t5 = "";
								
								u1 = "";
								u2 = "";
								u3 = "";
								u4 = "";
								u5 = "";
								
								l2.clearSelection();
								JOptionPane.showMessageDialog(frmAdminPortal, "Published!", "Error",
										JOptionPane.WARNING_MESSAGE);
								
							} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
									| SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}

			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(new Color(255, 69, 0));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
		btnNewButton.setBounds(744, 493, 89, 23);
		frmAdminPortal.getContentPane().add(btnNewButton);

		frmAdminPortal.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\chat_96px.png"));
		frmAdminPortal.setResizable(false);
		frmAdminPortal.setTitle("Admin Portal");
		frmAdminPortal.setBounds(100, 100, 902, 574);
		frmAdminPortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
