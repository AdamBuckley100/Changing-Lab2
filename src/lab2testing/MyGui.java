package lab2testing;
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

public class MyGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblId;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblEmail;

	Connection conn;
	Statement theStatement;
	ResultSet resultSet;

	/** The name of the MySQL account to use (or empty for anonymous) */
	private final String userName = "root";

	/** The password for the MySQL account (or empty for anonymous) */
	private final String password = "";

	/** The name of the computer running MySQL */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database we are testing with (this default is installed with MySQL) */
	private final String dbName = "test2_create_db";
	private JTextField textField_4;
	private JLabel lblDeleteTableOption;
	private JButton btnDeleteTheTable;

	/** The name of the table we are testing with */
	//private final String tableName = "JDBC_TEST9";

	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException { // for initial use only! establishes new connection.
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command); // This will throw a SQLException if it fails
			return true;
		} finally {

			// This will run whether we throw an exception or not
			if (stmt != null) { stmt.close(); }
		}
	}

	/**
	 * Connect to MySQL and do some stuff.
	 */
	public void runn() {

		// Connect to MySQL for first and only time needed
		//Connection conn = null;
		try {
			System.out.println("got here 1");
			conn = this.getConnection();
			System.out.println("Connected to database");

			theStatement = conn.createStatement(); // let this happen ONE time.

			resultSet = theStatement.executeQuery("select * from web_members4"); // ONE time.

		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}

		//		//		// Create a table
		//		try {
		//			System.out.println("got here");
		//			String createString =
		//					"CREATE TABLE " + this.tableName + " ( " +
		//							"ID INTEGER NOT NULL, " +
		//							"NAME varchar(40) NOT NULL, " +
		//							"STREET varchar(40) NOT NULL, " +
		//							"CITY varchar(20) NOT NULL, " +
		//							"STATE char(2) NOT NULL, " +
		//							"ZIP char(5), " +
		//							"PRIMARY KEY (ID))";
		//			this.executeUpdate(conn, createString);
		//			System.out.println("Created a table");
		//		} catch (SQLException e) {
		//			System.out.println("ERROR: Could not create the table");
		//			e.printStackTrace();
		//			return;
		//		}

		//		// Drop the table
		//		try {
		//			String dropString = "DROP TABLE " + this.tableName;
		//			this.executeUpdate(conn, dropString);
		//			System.out.println("Dropped the table");
		//		} catch (SQLException e) {
		//			System.out.println("ERROR: Could not drop the table");
		//			e.printStackTrace();
		//			return;
		//		}

		try {
			resultSet.absolute(1);
		} catch (SQLException e) {
			//Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {

		MyGui app = new MyGui();
		app.runn(); // db set up (should only have to happen once).

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MyGui frame = new MyGui();
					app.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private String sendBackId() throws SQLException
	{
		Connection conn = getConnection();

		System.out.println(conn); //you can take this out if you want

		Statement theStatement = conn.createStatement();

		ResultSet resultSet = theStatement.executeQuery("select id from web_members4");
		// Note: above replaced Data with web_members3. You can change "where id=11" to any number value.

		String id = "";

		if( resultSet.next() )
		{
			id = resultSet.getString("id");
		}

		System.out.println("id is " + id);
		return id;
	}

	private String sendBackFirstName() throws SQLException
	{
		Connection conn = getConnection();

		System.out.println(conn); //you can take this out if you want

		Statement theStatement = conn.createStatement();

		ResultSet resultSet = theStatement.executeQuery("select firstname from web_members4");
		// Note: above replaced Data with web_members3. You can change "where id=11" to any number value.

		String firstName = "";

		if( resultSet.next() )
		{
			firstName = resultSet.getString("firstname");
		}

		System.out.println("First Name is " + firstName);
		return firstName;
	}

	private String sendBackLastName() throws SQLException
	{
		Connection conn = getConnection();

		System.out.println(conn); //you can take this out if you want

		Statement theStatement = conn.createStatement();

		ResultSet resultSet = theStatement.executeQuery("select lastname from web_members4");
		// Note: above replaced Data with web_members3. You can change "where id=11" to any number value.

		String lastName = "";

		if( resultSet.next() )
		{
			lastName = resultSet.getString("lastname");
		}

		System.out.println("Last Name is " + lastName);
		return lastName;
	}

	private String sendBackEmail() throws SQLException
	{
		Connection conn = getConnection();

		System.out.println(conn); //you can take this out if you want

		Statement theStatement = conn.createStatement();

		ResultSet resultSet = theStatement.executeQuery("select email from web_members4");
		// Note: above replaced Data with web_members3. You can change "where id=11" to any number value.

		String email = "";

		if( resultSet.next() )
		{
			email = resultSet.getString("email");
		}

		System.out.println("Email is " + email);
		return email;
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MyGui() throws SQLException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		lblId = new JLabel("ID:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 0);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 1;
		contentPane.add(lblId, gbc_lblId);

		textField = new JTextField(17);
		//textField.setText("Hello");
		String theId = sendBackId();
		textField.setText(theId);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		lblFirstName = new JLabel("First Name:");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 0);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 3;
		contentPane.add(lblFirstName, gbc_lblFirstName);

		textField_1 = new JTextField(18);
		String theFirstName = sendBackFirstName();
		textField_1.setText(theFirstName);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		lblLastName = new JLabel("Last Name:");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.insets = new Insets(0, 0, 5, 0);
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 5;
		contentPane.add(lblLastName, gbc_lblLastName);

		textField_2 = new JTextField(20);
		String theLastName = sendBackFirstName();
		textField_2.setText(theLastName);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 6;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 0);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 7;
		contentPane.add(lblEmail, gbc_lblEmail);

		textField_3 = new JTextField(19);
		String theEmail = sendBackEmail();
		textField_3.setText(theEmail);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 8;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		// BUTTON NEXT:
		JButton btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				System.out.println("in the next pressed");

				//we cant make a new connection each time next button is pressed!

				try {
					resultSet.next ();
					String idVal = resultSet.getString("id");
					String firstNameVal = resultSet.getString("firstname");
					String lastNameVal = resultSet.getString("lastname");
					String emailVal = resultSet.getString("email");

					textField.setText(idVal);
					textField_1.setText(firstNameVal);
					textField_2.setText(lastNameVal);
					textField_3.setText(emailVal);

					//						System.out.println (
					//								"id = " + idVal
					//								+ ", fistname = " + firstNameVal
					//								+ ", lastname = " + lastNameVal
					//								+ ", email = " + emailVal);

				} catch (SQLException e1) {
					System.out.println("error 4 OK?");
					e1.printStackTrace();
				}

			}
		});
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 5, 0);
		gbc_btnNext.gridx = 1;
		gbc_btnNext.gridy = 9;
		contentPane.add(btnNext, gbc_btnNext);

		// BUTTON PREVIOUS:
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					resultSet.previous();
					String idVal = resultSet.getString("id");
					String firstNameVal = resultSet.getString("firstname");
					String lastNameVal = resultSet.getString("lastname");
					String emailVal = resultSet.getString("email");

					textField.setText(idVal);
					textField_1.setText(firstNameVal);
					textField_2.setText(lastNameVal);
					textField_3.setText(emailVal);

					//						System.out.println (
					//								"id = " + idVal
					//								+ ", fistname = " + firstNameVal
					//								+ ", lastname = " + lastNameVal
					//								+ ", email = " + emailVal);

				} catch (SQLException e1) {
					System.out.println("error 4 OK?");
					e1.printStackTrace();
				}

			}
		});
		GridBagConstraints gbc_btnPrevious = new GridBagConstraints();
		gbc_btnPrevious.insets = new Insets(0, 0, 5, 0);
		gbc_btnPrevious.gridx = 1;
		gbc_btnPrevious.gridy = 10;
		contentPane.add(btnPrevious, gbc_btnPrevious);
		
		lblDeleteTableOption = new JLabel("Delete Table Option: (Please put in table name below)");
		GridBagConstraints gbc_lblDeleteTableOption = new GridBagConstraints();
		gbc_lblDeleteTableOption.insets = new Insets(0, 0, 5, 0);
		gbc_lblDeleteTableOption.gridx = 1;
		gbc_lblDeleteTableOption.gridy = 12;
		contentPane.add(lblDeleteTableOption, gbc_lblDeleteTableOption);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 13;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		btnDeleteTheTable = new JButton("Delete The Table");
		btnDeleteTheTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String tableNameInputted = textField_4.getText(); //textField4 is what was put in delete text input field.
				
				// Use that String above to drop the table specified.
				
				try {
					String dropString = "DROP TABLE " + tableNameInputted;
					executeUpdate(conn, dropString);
					System.out.println("Dropped the table " + tableNameInputted);
				} catch (SQLException e) {
					System.out.println("ERROR: Could not drop the table " + tableNameInputted);
					e.printStackTrace();
					return;
				}
			}
		});
		GridBagConstraints gbc_btnDeleteTheTable = new GridBagConstraints();
		gbc_btnDeleteTheTable.gridx = 1;
		gbc_btnDeleteTheTable.gridy = 14;
		contentPane.add(btnDeleteTheTable, gbc_btnDeleteTheTable);
	}
	
//	private void addATable() // i.e. create a new table in the database.
//	{
//				try {
//					String createString =
//							"CREATE TABLE " + this.tableName + " ( " +
//									"ID INTEGER NOT NULL, " +
//									"NAME varchar(40) NOT NULL, " +
//									"STREET varchar(40) NOT NULL, " +
//									"CITY varchar(20) NOT NULL, " +
//									"STATE char(2) NOT NULL, " +
//									"ZIP char(5), " +
//									"PRIMARY KEY (ID))";
//					this.executeUpdate(conn, createString);
//					System.out.println("Created a table");
//				} catch (SQLException e) {
//					System.out.println("ERROR: Could not create the table");
//					e.printStackTrace();
//					return;
//				}
//	}
	
	private void deleteATable()
	{
		// first take in a table name from user (of table they want deleted).
		
		
		
	}
	
}