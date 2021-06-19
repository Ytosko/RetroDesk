package com.srf.retro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.Toolkit;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JSpinner;
import java.awt.List;
import java.awt.ComponentOrientation;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class nchooser {

	public JFrame frmNewspaperChooser;
	DefaultListModel lx, ly;
	private JList l2;
	private JList l1;

	String macad = "";

	String Select = "";
	String newSelect = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nchooser window = new nchooser();
					window.frmNewspaperChooser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public nchooser() {
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
		loadn();
	}

	private void elemn() {
		for (int i = 0; i < ly.getSize(); i++) {
			for (int h = 0; h < lx.getSize(); h++) {
				if (ly.getElementAt(i).equals(lx.getElementAt(h))) {
					lx.remove(i);
				}
			}
		}

	}

	private void loadn() {
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

	private void clrn() {
		if (newSelect.equals("")) {
			JOptionPane.showMessageDialog(frmNewspaperChooser, "Newspaper not selected!", "Error", JOptionPane.WARNING_MESSAGE);
		} else {
			int flag = 1;
			if (flag == 1) {
				Connection x;
				Statement y;

				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root", "");
					y = (Statement) x.createStatement();

					String sql = "DELETE FROM `" + macad + "_paper` WHERE paper = '" + newSelect + "'";
					try (PreparedStatement pstmt = (PreparedStatement) x.prepareStatement(sql)) {

						pstmt.executeUpdate();

						x.close();
					} catch (Exception e) {

					}

					newSelect = "";
					Select = "";
					loadn();
					x.close();
					y.close();
					l1.clearSelection();
					l2.clearSelection();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	private void addn() {
		try {
			Connection x12 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root",
					"");
			Statement y12 = (Statement) x12.createStatement();

			String sql112 = "CREATE TABLE IF NOT EXISTS ytosko_1.`" + macad + "_paper` ("
					+ "  `id` int(10) NOT NULL AUTO_INCREMENT," + "  `paper` varchar(100) NOT NULL,"
					+ "   PRiMARY KEY(`id`)" + ") ENGINE = InnoDB DEFAULT CHARSET = latin1 AUTO_INCREMENT =1";

			y12.executeUpdate(sql112);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Select.equals("")) {
			JOptionPane.showMessageDialog(frmNewspaperChooser, "Newspaper not selected!", "Error", JOptionPane.WARNING_MESSAGE);
		} else {
			int flag = 1;
			for (int i = 0; i < ly.getSize(); i++) {
				if (ly.getElementAt(i).equals(Select)) {
					JOptionPane.showMessageDialog(frmNewspaperChooser, "Newspaper already choosen!", "Error",
							JOptionPane.WARNING_MESSAGE);
					flag++;
				}
			}
			if (flag == 1) {
				Connection x;
				Statement y;
				ResultSet z;

				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					x = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ytosko_1", "root", "");
					y = (Statement) x.createStatement();
					String sql = ("INSERT INTO `" + macad + "_paper`(Paper)" + "VALUES (?)");

					PreparedStatement preparedStatement = (PreparedStatement) x.prepareStatement(sql);
					preparedStatement.setString(1, Select);
					preparedStatement.executeUpdate();
				
						
						String sql1 = "SELECT * FROM `stat` WHERE id = 1";
						y = (Statement) x.createStatement();

						z = y.executeQuery(sql1);
						if (z.next()) {
							int v = z.getInt(Select);
							int up = v+1;
							String sql11 = "UPDATE `stat` " 
							+ "SET `" + Select + "` = ? "
						    + "WHERE id = 1";
							
							PreparedStatement preparedStatement1 = (PreparedStatement) x.prepareStatement(sql11);
							preparedStatement1.setInt(1, up);
							preparedStatement1.executeUpdate();

						} else {
							JOptionPane.showOptionDialog(frmNewspaperChooser, "Invalid operation", "Error",
									JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
									new Object[] {}, null);
							x.close();
							y.close();
						}
						
					
					newSelect = "";
					Select = "";
					loadn();
					x.close();
					y.close();
					l1.clearSelection();
					l2.clearSelection();
					JOptionPane.showMessageDialog(frmNewspaperChooser, "Updated!", "Error",
							JOptionPane.WARNING_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void loadc() {
		lx.removeAllElements();
		lx.addElement("BD News 24");
		lx.addElement("The Daily Star");
		lx.addElement("Prothom Alo");
		lx.addElement("Kaler Kontho");
		lx.addElement("Somoy News");
		lx.addElement("Independent TV");
		lx.addElement("Bangladesh Pratidin");

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewspaperChooser = new JFrame();
		frmNewspaperChooser.setTitle("Newspaper chooser");
		frmNewspaperChooser.setResizable(false);
		frmNewspaperChooser.setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\icons8_chat_64.png"));
		frmNewspaperChooser.getContentPane().setBackground(Color.WHITE);
		frmNewspaperChooser.setBounds(100, 100, 745, 464);
		frmNewspaperChooser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNewspaperChooser.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("AZ Newspaper chooser");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 709, 42);
		frmNewspaperChooser.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Available Newspapers");
		lblNewLabel_1.setForeground(new Color(210, 105, 30));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 84, 158, 14);
		frmNewspaperChooser.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Choosen Newspapers");
		lblNewLabel_1_1.setForeground(new Color(255, 99, 71));
		lblNewLabel_1_1.setFont(new Font("Sitka Text", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(571, 84, 158, 14);
		frmNewspaperChooser.getContentPane().add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("Add > >");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addn();
			}
		});
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(305, 178, 106, 36);
		frmNewspaperChooser.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("< < Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clrn();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setFocusTraversalKeysEnabled(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(305, 236, 106, 36);
		frmNewspaperChooser.getContentPane().add(btnNewButton_1);

		lx = new DefaultListModel();
		ly = new DefaultListModel();

		l1 = new JList(lx);
		l1.setFocusable(false);
		l1.setFocusTraversalKeysEnabled(false);
		l1.setSelectionForeground(Color.LIGHT_GRAY);
		l1.setSelectionBackground(Color.WHITE);
		l1.setFixedCellHeight(30);
		l1.setForeground(new Color(0, 0, 128));
		l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		l1.setBounds(10, 100, 219, 314);
		l1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Select = l1.getSelectedValue().toString();
			}
		});
		frmNewspaperChooser.getContentPane().add(l1);

		l2 = new JList(ly);
		l2.setFocusable(false);
		l2.setFocusTraversalKeysEnabled(false);
		l2.setSelectionForeground(Color.LIGHT_GRAY);
		l2.setSelectionBackground(Color.WHITE);
		l2.setForeground(new Color(0, 128, 128));
		l2.setFixedCellHeight(30);
		l2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		l2.setBounds(500, 100, 219, 314);
		l2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newSelect = l2.getSelectedValue().toString();
			}
		});
		frmNewspaperChooser.getContentPane().add(l2);
	}
}
