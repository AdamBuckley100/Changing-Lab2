package lab2testing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertingIntoATable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	Connection conn;
	public MyGui theGuiClass;

	//	private Connection thisClassesConn;

	//	public InsertingIntoATable(MyGui inputTheGuiClass)
	//	{
	//		theGuiClass = inputTheGuiClass;
	//		try {
	//			conn = theGuiClass.getConnection();
	//		} catch (SQLException e) {
	//			// Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//	}

	//	public void makeConnectionHappen() throws SQLException
	//	{
	//			MyGui theGuiClassItself = new MyGui();
	//
	//		try {
	//			conn = theGuiClassItself.getConnection();
	//		} catch (SQLException e) {
	//			// Auto-generated catch block
	//			System.out.println("Error when assigning conn getConnection");
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertingIntoATable frame = new InsertingIntoATable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertingIntoATable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblPicTableYou = new JLabel("Pic table you want to add to:");
		GridBagConstraints gbc_lblPicTableYou = new GridBagConstraints();
		gbc_lblPicTableYou.insets = new Insets(0, 0, 5, 5);
		gbc_lblPicTableYou.gridx = 4;
		gbc_lblPicTableYou.gridy = 0;
		contentPane.add(lblPicTableYou, gbc_lblPicTableYou);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblAddTheBelow = new JLabel("Add the below info of the person you want added:");
		GridBagConstraints gbc_lblAddTheBelow = new GridBagConstraints();
		gbc_lblAddTheBelow.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddTheBelow.gridx = 4;
		gbc_lblAddTheBelow.gridy = 3;
		contentPane.add(lblAddTheBelow, gbc_lblAddTheBelow);

		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 4;
		contentPane.add(label, gbc_label);

		JLabel lblFirstName = new JLabel("First Name:");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 4;
		gbc_lblFirstName.gridy = 7;
		contentPane.add(lblFirstName, gbc_lblFirstName);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 8;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name:");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 4;
		gbc_lblLastName.gridy = 9;
		contentPane.add(lblLastName, gbc_lblLastName);

		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 10;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 4;
		gbc_lblEmail.gridy = 11;
		contentPane.add(lblEmail, gbc_lblEmail);

		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 12;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		JButton btnConfirmAddition = new JButton("Confirm addition");
		btnConfirmAddition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// now access stuff i need in myGUI class

				MyGui theGuiClass = null;

				try {
					theGuiClass = new MyGui();
				} catch (SQLException e1) {
					System.out.println("GUI class instantiation error occured");
					e1.printStackTrace();
				}
				Connection conn = null;
				try {
					conn = theGuiClass.getConnection();
				} catch (SQLException e1) {
					System.out.println("Error 2");
					e1.printStackTrace();
				}

				String tableToAddTo = textField.getText();

				//String newTableEntrysId = textField_1.getText();

				int theIdOfTheLastInTable = 0;

				try {
					System.out.println("KKKKKK " + theGuiClass);
					theIdOfTheLastInTable = theGuiClass.getNumberImAt();
				} catch (SQLException e1) {
					// Auto-generated catch block
					e1.printStackTrace();
				}
				
				//theIdOfTheLastInTable++;

				String theNumInString = String.valueOf(theIdOfTheLastInTable);

				String newTableEntrysFirstName = textField_2.getText();
				String newTableEntrysLastName = textField_3.getText();
				String newTableEntrysEmail = textField_4.getText();

				try {
					String createString =
							"INSERT INTO " + tableToAddTo +
							" VALUES ('" + theNumInString + "', '" + newTableEntrysFirstName + "', '" + newTableEntrysLastName + "', '" + newTableEntrysEmail + "');";
					System.out.println("LOOK HERE FULL STRING OF INSERT INTO:" + createString);
					System.out.println("Conn of the new class: " + conn);
					theGuiClass.executeUpdate(conn, createString);
					System.out.println("Updated the table of ID: " + tableToAddTo);
				} catch (SQLException e) {
					System.out.println("ERROR: Could not update the table");
					e.printStackTrace();
					return;
				}
			}
		});
		GridBagConstraints gbc_btnConfirmAddition = new GridBagConstraints();
		gbc_btnConfirmAddition.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmAddition.gridx = 4;
		gbc_btnConfirmAddition.gridy = 14;
		contentPane.add(btnConfirmAddition, gbc_btnConfirmAddition);
	}
}