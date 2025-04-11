package hotel;
import java.util.*;
import java.util.Map.Entry;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class HotelDriver implements GeneralOperations{
	private static String LoggedInUsr=null;
	private JFrame frame;
	private static HashMap<String,Customer> Customers;
	private static HashMap<Integer, Room> RegRooms;
	private static HashMap<Integer, VIPRoom> VIPRooms;
	private static HashMap<String, RegWorker> RegStaffs;
	private static HashMap<String, Manager> Managers;
	private static JButton btnLogIn;
	private static JButton btnSignUp;
	private static JLabel lblWelcomeToThe;
	private static JButton btnCart;
	public static JButton btnBook;
	private static ShoppingCart cart; 
	private static double total;
	///Used for generating check in date
	private static Date DesiredDate=new Date();
	private static int GlobalDays=0;
	///Common variable to allocate the specified room object///
	private static VIPRoom Vrm;
	private static Room rm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Thread tthread=new TimeThread();
		tthread.start();
		SaveMechanism.initialize();
		Customers=SaveMechanism.ReadCustomers();
		RegRooms=SaveMechanism.ReadRegRooms();
		VIPRooms=SaveMechanism.ReadVIPRooms();
		RegStaffs=SaveMechanism.ReadRegStaffs();
		Managers=SaveMechanism.ReadManager();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelDriver window = new HotelDriver();
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
	public HotelDriver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static JButton btn101;
	private static JButton btn102;
	private static JButton btn103;
	private static JButton btn104;
	private static JButton btn105;
	private static JButton btn201;
	private static JButton btn202;
	private static JButton btn203;
	private static JButton btn204;
	private static JButton btn205;
	private static JButton btn301;
	private static JButton btn302;
	private static JButton btn303;
	private static JButton btn304;
	private static JButton btn305;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(btnLogIn.getText().equals("Log In"))
					LogIn();
				else
					LogOut();
			}
			});
		
		
		lblWelcomeToThe = new JLabel("Welcome to the Hotel!");
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				SignUp();	
			}
			});
		
		btnCart = new JButton("Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cart!=null)
					checkCart();
				else
					JOptionPane.showMessageDialog(null, "Log In First!!!","Warning",JOptionPane.INFORMATION_MESSAGE);
			}		
			});
		
		btn101 = new JButton("101");
		btn101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(101);
			}
		});
		btn101.setBackground(RoomStatsColor(101));
		
		btn102 = new JButton("102");
		btn102.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(102);
			}
		});
		btn102.setBackground(RoomStatsColor(102));
		
		btn103 = new JButton("103");
		btn103.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(103);
			}
		});
		btn103.setBackground(RoomStatsColor(103));
		
		 btn201 = new JButton("201");
		btn201.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(201);
			}
		});
		btn201.setBackground(RoomStatsColor(201));
		
		 btn301 = new JButton("301");
		btn301.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(301);
			}
		});
		btn301.setBackground(RoomStatsColor(301));
		
		 btn104 = new JButton("104");
		btn104.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(104);
			}
		});
		btn104.setBackground(RoomStatsColor(104));
		
		 btn105 = new JButton("105");
		btn105.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(105);
			}
		});
		btn105.setBackground(RoomStatsColor(105));
		
		 btn202 = new JButton("202");
		btn202.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(202);
			}
		});
		btn202.setBackground(RoomStatsColor(202));
		
		 btn203 = new JButton("203");
		btn203.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(203);
			}
		});
		btn203.setBackground(RoomStatsColor(203));
		
		 btn204 = new JButton("204");
		btn204.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(204);
			}
		});
		btn204.setBackground(RoomStatsColor(204));
		
		 btn205 = new JButton("205");
		btn205.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(205);
			}
		});
		btn205.setBackground(RoomStatsColor(205));
		
		 btn302 = new JButton("302");
		btn302.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(302);
			}
		});
		btn302.setBackground(RoomStatsColor(302));
		
		 btn303 = new JButton("303");
		btn303.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(303);
			}
		});
		btn303.setBackground(RoomStatsColor(303));
		
		 btn304 = new JButton("304");
		btn304.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(304);
			}
		});
		btn304.setBackground(RoomStatsColor(304));
		
		 btn305 = new JButton("305");
		btn305.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowRooms(305);
			}
		});
		btn305.setBackground(RoomStatsColor(305));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(lblWelcomeToThe)
					.addGap(87)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSignUp, Alignment.TRAILING)
						.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn301)
							.addGap(18)
							.addComponent(btn302)
							.addGap(18)
							.addComponent(btn303)
							.addGap(18)
							.addComponent(btn304)
							.addGap(18)
							.addComponent(btn305))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn201)
							.addGap(18)
							.addComponent(btn202)
							.addGap(18)
							.addComponent(btn203)
							.addGap(18)
							.addComponent(btn204)
							.addGap(18)
							.addComponent(btn205))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn101)
							.addGap(18)
							.addComponent(btn102)
							.addGap(18)
							.addComponent(btn103)
							.addGap(18)
							.addComponent(btn104)
							.addGap(18)
							.addComponent(btn105)))
					.addContainerGap(46, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(337, Short.MAX_VALUE)
					.addComponent(btnCart)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogIn)
						.addComponent(lblWelcomeToThe))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSignUp)
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn301)
						.addComponent(btn302)
						.addComponent(btn303)
						.addComponent(btn304)
						.addComponent(btn305))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn201)
						.addComponent(btn202)
						.addComponent(btn203)
						.addComponent(btn204)
						.addComponent(btn205))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn101)
						.addComponent(btn102)
						.addComponent(btn103)
						.addComponent(btn104)
						.addComponent(btn105))
					.addGap(18)
					.addComponent(btnCart)
					.addGap(23))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
	
	public void LogIn()
	{
		JTextField textField;
		JPasswordField passwordField;
		JFrame login=new JFrame("Log In");
		login.setBounds(100, 100, 450, 300);
		login.getContentPane().setLayout(null);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setBounds(204, 58, 60, 20);
		login.getContentPane().add(lblLogIn);
		
		textField = new JTextField();
		textField.setBounds(182, 113, 120, 21);
		login.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(182, 170, 120, 21);
		login.getContentPane().add(passwordField);

		JLabel lblUsrName = new JLabel("Usr Name:");
		lblUsrName.setBounds(105, 115, 63, 17);
		login.getContentPane().add(lblUsrName);
		
		JLabel lblCredential = new JLabel("Credential:");
		lblCredential.setBounds(105, 172, 82, 17);
		login.getContentPane().add(lblCredential);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(170, 210, 101, 27);
		login.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String FirstNameIndex="";
				Customer Cstm;
				String UsrName;
				String Credential;
				boolean correct=false;
				String text = textField.getText();
				char[] passwords = passwordField.getPassword();
				String passcode=new String(passwords);
			    textField.selectAll();
			    if(text.equals("Admin")&&passcode.equals("Admin123123"))
			    	{
			    	frame.setVisible(false);
			    	login.dispose();
			    	AdminMod();
			    	}
			    else {
			    Iterator<Map.Entry<String,Customer>> iterator=Customers.entrySet().iterator();
				while(iterator.hasNext())//Use iterator to iterate through every key value pair
				{
					Map.Entry<String, Customer> entry=iterator.next();
					FirstNameIndex=entry.getKey();
					Cstm=entry.getValue();
					UsrName=Cstm.getUsrName();
					Credential=Cstm.getCredential();
					System.out.println(UsrName+Credential);
					if(text.equals(UsrName)&&Credential.equals(passcode))
					{
						correct=true;
						break;
					}
				}
				if(correct)
				{
					LoggedInUsr=FirstNameIndex;
					JOptionPane.showMessageDialog(null, "Succefully logged in!","Congrats",JOptionPane.INFORMATION_MESSAGE);
					login.setVisible(false);
					btnLogIn.setText("Log Out");
					btnSignUp.setVisible(false);
					lblWelcomeToThe.setText("Welcome!     "+FirstNameIndex);
					cart=new ShoppingCart();
				}
				else
				JOptionPane.showMessageDialog(null, "Incorrect User Name or");
			}
		}
		});
		
		
        login.setVisible(true);
	}

	public void SignUp()
	{
		JFrame signup = new JFrame();
		signup.setBounds(100, 100, 450, 350);
		signup.getContentPane().setLayout(null);
		
		JTextField TextGender = new JTextField();
		TextGender.setBounds(133, 144, 30, 21);
		signup.getContentPane().add(TextGender);
		TextGender.setColumns(10);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setBounds(196, 50, 58, 17);
		signup.getContentPane().add(lblSignUp);
		
		JTextField TextFirstName = new JTextField();
		TextFirstName.setBounds(122, 96, 90, 21);
		signup.getContentPane().add(TextFirstName);
		TextFirstName.setColumns(10);
		
		JTextField TextLastName = new JTextField();
		TextLastName.setBounds(305, 96, 74, 21);
		signup.getContentPane().add(TextLastName);
		TextLastName.setColumns(10);
		
		JTextField TextAge = new JTextField();
		TextAge.setBounds(207, 144, 31, 21);
		signup.getContentPane().add(TextAge);
		TextAge.setColumns(10);
		
		JTextField TextEmail = new JTextField();
		TextEmail.setBounds(150, 220, 136, 21);
		signup.getContentPane().add(TextEmail);
		TextEmail.setColumns(10);
		
		JLabel lbloptional = new JLabel("(Optional)");
		lbloptional.setBounds(304, 222, 70, 17);
		signup.getContentPane().add(lbloptional);
		
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setBounds(47, 98, 74, 17);
		signup.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setBounds(235, 98, 74, 17);
		signup.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(47, 222, 42, 17);
		signup.getContentPane().add(lblEmail);
		
		JLabel lblGender = new JLabel("Gender(M/F):");
		lblGender.setBounds(47, 146, 87, 17);
		signup.getContentPane().add(lblGender);
		
		JLabel lblAge = new JLabel("Age: ");
		lblAge.setBounds(170, 146, 30, 17);
		signup.getContentPane().add(lblAge);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: \n");
		lblPhoneNumber.setBounds(47, 187, 105, 17);
		signup.getContentPane().add(lblPhoneNumber);
		
		JTextField TextPhone = new JTextField();
		TextPhone.setBounds(150, 185, 136, 21);
		signup.getContentPane().add(TextPhone);
		TextPhone.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(170, 253, 101, 27);
		signup.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String FirstName=TextFirstName.getText();
				String LastName=TextLastName.getText();
				String Gender = TextGender.getText();
				String Number=TextPhone.getText();
				String Email=TextEmail.getText();
			    TextFirstName.selectAll();
			    TextLastName.selectAll();
				TextGender.selectAll();
				TextPhone.selectAll();
				TextEmail.selectAll();
				try {
				int Age=Integer.parseInt(TextAge.getText());
				
				if(Number.length()>=4&&(Gender.equals("M")||Gender.equals("F"))&&!(Gender.isBlank()||FirstName.isBlank()||LastName.isBlank())) {
					String FirstNameIndex=FirstName;
					while(Customers.containsKey(FirstNameIndex))
						FirstNameIndex+=(int)(Math.random()*10);
					if(Email.isBlank())
						{
						Customers.put(FirstNameIndex, new Customer(FirstName,LastName,Gender,Number,Age));
						}
					else
						Customers.put(FirstNameIndex, new Customer(FirstName,LastName,Gender,Number,Email,Age));
					SaveMechanism.SaveCustomers(Customers);
					JOptionPane.showMessageDialog(null, 
							"Successfully Signed Up!\nYour user name is first name+upper cased first letter of last name\nCredential is last 4 digits of your phone + your age","Congrats"
							,JOptionPane.INFORMATION_MESSAGE);
					signup.setVisible(false);
				}
				else JOptionPane.showMessageDialog(null,"Please enter valid information.","Warning",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(NumberFormatException e1)
				{
				JOptionPane.showMessageDialog(null, "Please input valid number in age and accompany number!", "Warning", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		signup.setVisible(true);
	}
	
	private static void LogOut()
	{
		LoggedInUsr=null;
		btnLogIn.setText("Log In");
		btnSignUp.setVisible(true);
		lblWelcomeToThe.setText("Welcome to the Hotel!");
	}
	
	private static void ShowRooms(int RoomNum)
	{
		JFrame frame;
		if(VIPRooms.containsKey(RoomNum))
		{
			frame = new JFrame();
			frame.setBounds(100, 100, 260, 325);
			frame.getContentPane().setLayout(null);
			
			JLabel Room_Num = new JLabel("New label");
			Room_Num.setBounds(120, 30, 89, 26);
			Room_Num.setFont(new Font("Dialog", Font.BOLD, 18));
			frame.getContentPane().add(Room_Num);
			
			JLabel lblType = new JLabel("Type:");
			lblType.setBounds(60, 60, 32, 17);
			frame.getContentPane().add(lblType);
			
			JLabel lblType_1 = new JLabel("Type");
			lblType_1.setBounds(150, 60, 50, 17);
			frame.getContentPane().add(lblType_1);
			
			JLabel lblPrice = new JLabel("Price:");
			lblPrice.setBounds(60, 85, 33, 17);
			frame.getContentPane().add(lblPrice);
			
			JLabel lblPrice_1 = new JLabel("Price");
			lblPrice_1.setBounds(150, 85, 60, 17);
			frame.getContentPane().add(lblPrice_1);
			
			JLabel lblStatus = new JLabel("Status:");
			lblStatus.setBounds(60, 110, 41, 17);
			frame.getContentPane().add(lblStatus);
			
			JLabel lblStatus_1 = new JLabel("Status");
			lblStatus_1.setBounds(150, 110, 100, 17);
			frame.getContentPane().add(lblStatus_1);
			
			JLabel lblBedType = new JLabel("Bed Type:");
			lblBedType.setBounds(60, 135, 58, 17);
			frame.getContentPane().add(lblBedType);
			
			JLabel lblBedType_1 = new JLabel("BedType");
			lblBedType_1.setBounds(150, 135, 100, 17);
			frame.getContentPane().add(lblBedType_1);
			
			JButton btnCancel=new JButton("Cancel");
			btnCancel.setFont(new Font("Dialog", Font.BOLD, 10));
			btnCancel.setBounds(180,10,70,20);
			frame.getContentPane().add(btnCancel);
			btnCancel.setVisible(false);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(btnCancel.getText()=="Cancel")
					{
						int result = JOptionPane.showConfirmDialog(
						            null,                        // Parent component (null = center of screen)
									"Are you sure you want to cancel?", // Message
									"Confirm Exit",              // Title
									JOptionPane.YES_NO_OPTION    // Options: Yes / No
						);
						
						if (result == JOptionPane.YES_OPTION) {
							{
							Cancel(RoomNum);
							frame.dispose();//close the frame
							}
						} 
					}
					else if(btnCancel.getText()=="Extend")
						ExtendDate(RoomNum);
					
				};
			});
			btnBook = new JButton("Book");
			if(Customers.containsKey(LoggedInUsr))
				if(Customers.get(LoggedInUsr).getRoom()==RoomNum)
					{
					if(!Customers.get(LoggedInUsr).getCheckInStat())//if checked in, no cancel
						{
						btnCancel.setText("Cancel");
						btnCancel.setVisible(true);
						}
					else
						{
						btnCancel.setText("Extend");
						btnCancel.setVisible(true);
						}
					if(Customers.get(LoggedInUsr).getCheckInStat())//if customer checked in
						btnBook.setText("Check Out");
					else
						btnBook.setText("Check In");
					}
			else if(VIPRooms.get(RoomNum).getStatus().equals("Occupied")||VIPRooms.get(RoomNum).getStatus().equals("Booked"))
				btnBook.setText("Join Queue");
			btnBook.setBounds(90, 230, 100, 27);
			btnBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(btnBook.getText().equals("Book"))
					{
						boolean judge=true;
						for(Entry<String, Double> i:cart.getEntrySets())
	                	{
	                		String temp=i.getKey().substring(0,3);
	                		if(isParsableInt(temp)&&(RegRooms.containsKey(Integer.parseInt(temp))||VIPRooms.containsKey(Integer.parseInt(temp))))//if it is a valid room opt
	                		{
	                			judge=false;//no double booking
	                			break;
	                		}
	                	}
						if(judge)
							Book(RoomNum);
						else
							JOptionPane.showMessageDialog(null,"No double booking!","Warning!",JOptionPane.INFORMATION_MESSAGE);
					}
					else if(btnBook.getText().equals("Check In"))
						{
						CheckIn();
						VIPRooms.get(RoomNum).setStatus("Occupied");
						updateStatus();
						SaveMechanism.SaveVIPRooms(VIPRooms);
						SaveMechanism.SaveCustomers(Customers);
						frame.setVisible(false);
						}
					else if(btnBook.getText().equals("Check Out"))
					{
						CheckOut();
						if(VIPRooms.get(RoomNum).isNext())
							VIPRooms.get(RoomNum).setStatus("Reserved");
						else	
							VIPRooms.get(RoomNum).setStatus("Available");
						updateStatus();
						SaveMechanism.SaveVIPRooms(VIPRooms);
						SaveMechanism.SaveCustomers(Customers);
						frame.setVisible(false);
					}
				}
			});
			frame.getContentPane().add(btnBook);
			
			JLabel lblBathTub = new JLabel("Bath Tub:");
			lblBathTub.setBounds(60, 160, 56, 17);
			frame.getContentPane().add(lblBathTub);
			
			JLabel lblBathTub_1 = new JLabel("BathTub");
			lblBathTub_1.setBounds(150, 160, 50, 17);
			frame.getContentPane().add(lblBathTub_1);
			
			JLabel lblBalcony = new JLabel("Balcony:");
			lblBalcony.setBounds(60, 185, 50, 17);
			frame.getContentPane().add(lblBalcony);
			
			JLabel lblBalcony_1 = new JLabel("Balcony");
			lblBalcony_1.setBounds(150, 185, 47, 17);
			frame.getContentPane().add(lblBalcony_1);
			
			VIPRoom vipRoom=VIPRooms.get(RoomNum);
			
			Room_Num.setText(""+RoomNum);
			lblType_1.setText("VIP");
			lblPrice_1.setText(""+vipRoom.getPrice());
			lblStatus_1.setText(vipRoom.getStatus());
			lblBedType_1.setText(vipRoom.getBedType());
			lblBalcony_1.setText(vipRoom.getBalconyType());
			lblBathTub_1.setText(vipRoom.getBathTubType());
			
			frame.setVisible(true);
		}
		else if(RegRooms.containsKey(RoomNum))
		{
			frame = new JFrame();
			frame.setBounds(100, 100, 270, 250);
			frame.getContentPane().setLayout(null);
			
			JLabel Room_Num = new JLabel("New label");
			Room_Num.setBounds(120, 30, 89, 26);
			Room_Num.setFont(new Font("Dialog", Font.BOLD, 18));
			frame.getContentPane().add(Room_Num);
			
			JLabel lblType = new JLabel("Type:");
			lblType.setBounds(60, 61, 50, 17);
			frame.getContentPane().add(lblType);
			
			JLabel lblType_1 = new JLabel("Type");
			lblType_1.setBounds(150, 61, 60, 17);
			frame.getContentPane().add(lblType_1);
			
			JLabel lblPrice = new JLabel("Price:");
			lblPrice.setBounds(60, 83, 33, 17);
			frame.getContentPane().add(lblPrice);
			
			JLabel lblPrice_1 = new JLabel("Price");
			lblPrice_1.setBounds(150, 83, 60, 17);
			frame.getContentPane().add(lblPrice_1);
			
			JLabel lblStatus = new JLabel("Status:");
			lblStatus.setBounds(60, 105, 41, 17);
			frame.getContentPane().add(lblStatus);
			
			JLabel lblStatus_1 = new JLabel("Status");
			lblStatus_1.setBounds(150, 105, 100, 17);
			frame.getContentPane().add(lblStatus_1);
			
			JLabel lblBedType = new JLabel("Bed Type:");
			lblBedType.setBounds(60, 127, 58, 17);
			frame.getContentPane().add(lblBedType);
			
			JButton btnCancel=new JButton("Cancel");
			btnCancel.setFont(new Font("Dialog", Font.BOLD, 10));
			btnCancel.setBounds(180,10,70,20);
			frame.getContentPane().add(btnCancel);
			btnCancel.setVisible(false);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 int result = JOptionPane.showConfirmDialog(
					            null,                        // Parent component (null = center of screen)
					            "Are you sure you want to cancel?", // Message
					            "Confirm Exit",              // Title
					            JOptionPane.YES_NO_OPTION    // Options: Yes / No
					        );

					        if (result == JOptionPane.YES_OPTION) {
					        	{
					        	Cancel(RoomNum);
								frame.dispose();//close the frame
								}
					        } 
					
				};
			});
			
			btnBook = new JButton("Book");
			if(Customers.containsKey(LoggedInUsr))
				if(Customers.get(LoggedInUsr).getRoom()==RoomNum)
					{
					if(!Customers.get(LoggedInUsr).getCheckInStat())//if checked in, no cancel
						btnCancel.setVisible(true);
					if(Customers.get(LoggedInUsr).getCheckInStat())//if customer checked in
						btnBook.setText("Check Out");
					else
						btnBook.setText("Check In");
					}
			else if(RegRooms.get(RoomNum).getStatus().equals("Occupied")||RegRooms.get(RoomNum).getStatus().equals("Booked"))
				btnBook.setText("Join Queue");
			btnBook.setBounds(90, 170, 100, 27);
			btnBook.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(btnBook.getText().equals("Book"))
							Book(RoomNum);
						else if(btnBook.getText().equals("Check In"))
							{
							CheckIn();
							RegRooms.get(RoomNum).setStatus("Occupied");
							updateStatus();
							SaveMechanism.SaveRegRooms(RegRooms);
							SaveMechanism.SaveCustomers(Customers);
							frame.setVisible(false);
							}
						else if(btnBook.getText().equals("Check Out"))
						{
							CheckOut();
							if(RegRooms.get(RoomNum).isNext())
								RegRooms.get(RoomNum).setStatus("Reserved");
							else	
								RegRooms.get(RoomNum).setStatus("Available");
							updateStatus();
							SaveMechanism.SaveRegRooms(RegRooms);
							SaveMechanism.SaveCustomers(Customers);
							frame.setVisible(false);
						}
						else if(btnBook.getText().equals("Join Queue"))
							JoinQueue(RoomNum);
				}
			});
			frame.getContentPane().add(btnBook);
			
			JLabel lblBedType_1 = new JLabel("BedType");
			lblBedType_1.setBounds(150, 127, 100, 17);
			frame.getContentPane().add(lblBedType_1);
			
			Room rgRoom=RegRooms.get(RoomNum);
			
			Room_Num.setText(""+RoomNum);
			lblType_1.setText("Regular");
			lblPrice_1.setText(""+rgRoom.getPrice());
			lblStatus_1.setText(rgRoom.getStatus());
			lblBedType_1.setText(rgRoom.getBedType());
			
			frame.setVisible(true);
		}
		else
			JOptionPane.showMessageDialog(null, "Something Happened, maybe the room DNE","Error",JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	private static Color RoomStatsColor(int RoomNum)
	{
		if(VIPRooms.containsKey(RoomNum))
		{
			String stats=VIPRooms.get(RoomNum).getStatus();
			return statcolor(stats);
		}
		else if(RegRooms.containsKey(RoomNum))
		{
			String stats=RegRooms.get(RoomNum).getStatus();
			return statcolor(stats);
		}
		else
			{
			JOptionPane.showMessageDialog(null, "Something Happened, maybe the room DNE","Error",JOptionPane.INFORMATION_MESSAGE);
			return statcolor("");
			}
		
			
	}

	private static Color statcolor(String stat){
		if(stat.equals("Occupied"))
			return Color.RED;
		else if(stat.equals("Booked"))
			return Color.YELLOW;
		else if(stat.equals("Available"))
			return Color.GREEN;
		else
			return Color.MAGENTA;
	}
	

	public static void Book(int RoomNum) {
		JFrame Book = new JFrame();
		Book.setBounds(100, 100, 450, 300);
		Book.getContentPane().setLayout(null);
		
		JButton btnAddToCart = new JButton("AddToCart");
		btnAddToCart.setBounds(174, 200, 101, 27);
		Book.getContentPane().add(btnAddToCart);
		
		JLabel lblRoomnum = new JLabel(""+RoomNum);
		lblRoomnum.setBounds(196, 51, 62, 27);
		Book.getContentPane().add(lblRoomnum);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setBounds(105, 95, 58, 17);
		Book.getContentPane().add(lblDays);
		
		JLabel lblCheckInDate = new JLabel("Check In Date:");
		lblCheckInDate.setBounds(105, 124, 86, 17);
		Book.getContentPane().add(lblCheckInDate);
		
		JLabel lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setBounds(105, 153, 74, 17);
		Book.getContentPane().add(lblTotalPrice);
		
		JLabel lblTotalPrice_1 = new JLabel("0");
		lblTotalPrice_1.setBounds(235, 153, 58, 17);
		Book.getContentPane().add(lblTotalPrice_1);
		
		JTextField txtCheckindate = new JTextField();
		txtCheckindate.setText("CheckInDate");
		txtCheckindate.setBounds(235, 122, 114, 21);
		Book.getContentPane().add(txtCheckindate);
		txtCheckindate.setColumns(10);
		
		JTextField txtDays = new JTextField();
		txtDays.setText("Days");
		txtDays.setBounds(235, 93, 114, 21);
		Book.getContentPane().add(txtDays);	
		
		txtDays.setColumns(10);
		
		JCheckBox chckbxPets = new JCheckBox("Pets?");
		chckbxPets.setBounds(105, 173, 70, 25);
		Book.getContentPane().add(chckbxPets);
		
		JTextField TextNumofAccom = new JTextField();
		TextNumofAccom.setBounds(300, 177, 20, 21);
		TextNumofAccom.setText("0");
		Book.getContentPane().add(TextNumofAccom);
		TextNumofAccom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("# of Accompanies: ");
		lblNewLabel.setBounds(180, 177, 114, 17);
		Book.getContentPane().add(lblNewLabel);
		
		if(VIPRooms.containsKey(RoomNum))
		{
			Vrm=VIPRooms.get(RoomNum);
		}
		else if(RegRooms.containsKey(RoomNum))
		{
			rm=RegRooms.get(RoomNum);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Something Happened, maybe the room DNE","Error",JOptionPane.INFORMATION_MESSAGE);
		}
		txtDays.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(LoggedInUsr==null)
            		JOptionPane.showMessageDialog(null, "Log In First!!!","Warning",JOptionPane.INFORMATION_MESSAGE);
            	else
            		{
            		if(Customers.get(LoggedInUsr).getRoom()!=0)
            			JOptionPane.showMessageDialog(null, "Can only book one room per account!","Warning!",JOptionPane.INFORMATION_MESSAGE);
            		else
            		{
	            		int AccompNum=Integer.parseInt(TextNumofAccom.getText());//set accompanies num here
	            		
		            	Customers.get(LoggedInUsr).setAccompaniesNum(AccompNum);
		                int days=Integer.parseInt(txtDays.getText());
		                GlobalDays=days;
		                boolean WithPet=chckbxPets.isSelected();
		                Customers.get(LoggedInUsr).setWithPets(WithPet);
		                if(Vrm!=null)
		                	total=Vrm.calcPrice(days,WithPet);
		                else
		                	total=rm.calcPrice(days, WithPet);//need to move the with pet and those things to book page not as property
		                lblTotalPrice_1.setText(""+total);
            		}
                }
            }
        });
		
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dt=txtCheckindate.getText();
				Calendar cal=Calendar.getInstance();
				try{
					cal.set(Integer.parseInt(dt.substring(0,4)),Integer.parseInt(dt.substring(4, 6))-1,Integer.parseInt(dt.substring(6, 8)));
					DesiredDate=cal.getTime();
					System.out.println(DesiredDate);
					if(cart!=null)//see if logged in yet
					{
					if(total!=0) {
						cart.addItem(""+RoomNum+"_"+txtDays.getText(),total );
						JOptionPane.showMessageDialog(null, "Join Cart Successfully","Pop Up",JOptionPane.INFORMATION_MESSAGE);
						Book.dispose();
						}
					else
						JOptionPane.showMessageDialog(null, "Enter Correct days!","Warning",JOptionPane.INFORMATION_MESSAGE);
					}
				else
					JOptionPane.showMessageDialog(null, "Log In First!!!","Warning",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(NumberFormatException e7)
				{
					JOptionPane.showMessageDialog(null, "Enter Correct Date!! (YYYYMMDD)","Error",JOptionPane.INFORMATION_MESSAGE );
				}
				
			}
		});
		Book.setVisible(true);
		
	}	
	
	///judge if the given string is parseintable
	public static boolean isParsableInt(String s) {
	    try {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	private JTable table;//reserve for cart
	
	public void checkCart()
	{
		frame = new JFrame("Shopping Cart");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        JButton removeButton = new JButton("Remove Selected");

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton checkoutButton = new JButton("Checkout");//set up functional bottoms within the panel
        
        bottomPanel.add(removeButton);
        bottomPanel.add(checkoutButton);

        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        String[] columnNames = {"Item", "Price ($)"};
        Object[][] data = new Object[cart.getSize()][2];
        int i = 0;
        for (var entry : cart.getEntrySets()) {
            data[i][0] = entry.getKey();//transfer hashmap to 2d array for easier price calculation
            data[i][1] = entry.getValue();
            i++;
        }

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = cart.getTotalPrice();
                JOptionPane.showMessageDialog(frame, "Total Price: $" + String.format("%.2f", total));//show 2 digits float
                
                int RN=Customers.get(LoggedInUsr).getRoom();
                if(RegRooms.containsKey(RN))
        		{
        			rm=RegRooms.get(RN);
        			rm.addDays(GlobalDays);
        		}
        		else if(VIPRooms.containsKey(RN))
        		{	
        			Vrm=VIPRooms.get(RN);
        			Vrm.addDays(GlobalDays);
        		}
                
                Set<Integer> rgrms=RegRooms.keySet();
                Set<Integer> vprms=VIPRooms.keySet();
                for(Entry<String, Double> i:cart.getEntrySets())
                	{
                		String temp=i.getKey().substring(0,3);
                		if(isParsableInt(temp)&&(RegRooms.containsKey(Integer.parseInt(temp))||VIPRooms.containsKey(Integer.parseInt(temp))))//if it is a valid room opt
                		{
	                		int temp_int=Integer.parseInt(temp);
	                		if(rgrms.contains(temp_int))
	                		{
	                			RegRooms.get(temp_int).setStatus("Booked");
	                			RegRooms.get(temp_int).setDesiredCheckOut(DesiredDate);
	                			RegRooms.get(temp_int).addDays(GlobalDays);
	                			updateStatus();
	                			Customers.get(LoggedInUsr).setRoom(temp_int);
	                			SaveMechanism.SaveRegRooms(RegRooms);
	                		}
	                		else if(vprms.contains(temp_int))
	                		{
	                			VIPRooms.get(temp_int).setStatus("Booked");
	                			VIPRooms.get(temp_int).setDesiredCheckOut(DesiredDate);
	                			VIPRooms.get(temp_int).addDays(GlobalDays);
	                			updateStatus();
	                			Customers.get(LoggedInUsr).setRoom(temp_int);
	                			SaveMechanism.SaveVIPRooms(VIPRooms);
	                		}
                	}
                	}
                ///Add third party payment method here///                
                
                /////////////////////////////////////////
                cart=new ShoppingCart();//reset shopping cart
                frame.setVisible(false);
                GlobalDays=0;
                SaveMechanism.SaveCustomers(Customers);
            }
        });
        
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String itemName = table.getValueAt(selectedRow, 0).toString();
                cart.removeItem(itemName);
                refreshTable();
                JOptionPane.showMessageDialog(frame, itemName + " removed from cart.");
            } else {
                JOptionPane.showMessageDialog(frame, "Please select an item to remove.");
            }
        }
        });
        
        
        frame.setVisible(true);
	}
	
	private void refreshTable() {
		GlobalDays=0;
	    String[] columnNames = {"Item", "Price ($)"};
	    Object[][] data = new Object[cart.getSize()][2];
	    int i = 0;
	    for (var entry : cart.getEntrySets()) {
	        data[i][0] = entry.getKey();
	        data[i][1] = entry.getValue();
	        i++;
	    }
	    table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
	}

	///update room color all at once
	public static void updateStatus()
	{
		btn101.setBackground(RoomStatsColor(101));
		btn102.setBackground(RoomStatsColor(102));
		btn103.setBackground(RoomStatsColor(103));
		btn104.setBackground(RoomStatsColor(104));
		btn105.setBackground(RoomStatsColor(105));
		btn201.setBackground(RoomStatsColor(201));
		btn202.setBackground(RoomStatsColor(202));
		btn203.setBackground(RoomStatsColor(203));
		btn204.setBackground(RoomStatsColor(204));
		btn205.setBackground(RoomStatsColor(205));
		btn301.setBackground(RoomStatsColor(301));
		btn302.setBackground(RoomStatsColor(302));
		btn303.setBackground(RoomStatsColor(303));
		btn304.setBackground(RoomStatsColor(304));
		btn304.setBackground(RoomStatsColor(304));
	}
	
	public static void CheckIn()
	{
		Date checkintime=Customers.get(LoggedInUsr).CheckIn();	
		//System.out.println(Customers.get(LoggedInUsr).getCheckInStat());
		JOptionPane.showMessageDialog(null, "Check In Time: " +checkintime.toString(),"Check In",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void CheckOut()
	{
		Date checkouttime=Customers.get(LoggedInUsr).CheckOut();	
		Customers.get(LoggedInUsr).setRoom(0);//reset account detail for next time
		Customers.get(LoggedInUsr).setWithPets(false);
		JOptionPane.showMessageDialog(null, "Check Out Time: " +checkouttime.toString(),"Check In",JOptionPane.INFORMATION_MESSAGE);
		Customers.get(LoggedInUsr).resetCheckIn();	
		
	}
	
	public static void Cancel(int roomNum)
	{
		Customers.get(LoggedInUsr).setRoom(0);
        if(RegRooms.containsKey(roomNum))
        {
        	rm=RegRooms.get(roomNum);
        	rm.setCurrentResident(null);
        	if(rm.isNext())
        		rm.setStatus("Booked");//Admin choice of method to notify next customer in the queue
        	///Add notification here to notify the next customer in the queue
        	///e.g. MessagePhone(Customers.get(Next(roomNum)).getPhone());
        	else
        		rm.setStatus("Available");
        }
        else if(VIPRooms.containsKey(roomNum))
        {
        	Vrm=VIPRooms.get(roomNum);
        	Vrm.setCurrentResident(null);
        	if(Vrm.isNext())
        		Vrm.setStatus("Booked");//Admin choice of method to notify next customer in the queue
        	///Add notification here
        	else
        		Vrm.setStatus("Available");
        }
        JOptionPane.showMessageDialog(null,"Cancelled Successfully","POP UP",JOptionPane.INFORMATION_MESSAGE);
        updateStatus();
		///Add Refund method here///
	}
	
	public static void ExtendDate(int roomNum)
	{
		JFrame Extend=new JFrame("Extend");
		Extend.setBounds(100, 100, 300, 220);
		Extend.getContentPane().setLayout(null);
		
		JLabel lblRm = new JLabel(""+roomNum);
		lblRm.setBounds(130, 32, 58, 17);
		Extend.getContentPane().add(lblRm);
		
		JTextField textField = new JTextField();//for days
		textField.setBounds(97, 61, 114, 21);
		Extend.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setBounds(46, 63, 33, 17);
		Extend.getContentPane().add(lblDays);
		
		JButton btnAddToCart = new JButton("Add To Cart");
		btnAddToCart.setBounds(89, 141, 122, 27);
		Extend.getContentPane().add(btnAddToCart);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(46, 101, 33, 17);
		Extend.getContentPane().add(lblTotal);
		
		JLabel value = new JLabel("0");
		value.setBounds(130, 101, 58, 17);
		Extend.getContentPane().add(value);
		if(VIPRooms.containsKey(roomNum))
		{
			Vrm=VIPRooms.get(roomNum);
		}
		else if(RegRooms.containsKey(roomNum))
		{
			rm=RegRooms.get(roomNum);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Something Happened, maybe the room DNE","Error",JOptionPane.INFORMATION_MESSAGE);
		}
		textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	            int days=Integer.parseInt(textField.getText());
	            GlobalDays=days;
	            if(Vrm!=null)
	            	total=Vrm.calcPrice(days,Customers.get(LoggedInUsr).isWithPets());
	            else
	            	total=rm.calcPrice(days, Customers.get(LoggedInUsr).isWithPets());
	            value.setText(""+total);
            }
        });
		
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cart!=null)
					{
					if(total!=0) {
						cart.addItem("Extend"+roomNum+"_"+textField.getText(),total );
						JOptionPane.showMessageDialog(null, "Join Cart Successfully","Pop Up",JOptionPane.INFORMATION_MESSAGE);
						Extend.dispose();
						}
					else
						JOptionPane.showMessageDialog(null, "Enter Correct days!","Warning",JOptionPane.INFORMATION_MESSAGE);
					}
				else
					JOptionPane.showMessageDialog(null, "Log In First!!!","Warning",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Extend.setVisible(true);
	}
	
	public static void JoinQueue(int RoomNum)
	{
		if(RegRooms.containsKey(RoomNum))
		{
			rm=RegRooms.get(RoomNum);
			rm.joinWaitingQueue(LoggedInUsr);
		}
		else if(VIPRooms.containsKey(RoomNum))
		{	
			Vrm=VIPRooms.get(RoomNum);
			Vrm.joinWaitingQueue(LoggedInUsr);
		}
		JOptionPane.showMessageDialog(null, "Successfully join the queue","POP UP",JOptionPane.INFORMATION_MESSAGE);
	}
	
	///this method is use for calling the next one in the queue

	@SuppressWarnings("unused")
	private String Next(int RoomNum)
	{
		if(RegRooms.containsKey(RoomNum))
		{
			rm=RegRooms.get(RoomNum);
			return rm.callNext();
		}
		else if(VIPRooms.containsKey(RoomNum))
		{	
			Vrm=VIPRooms.get(RoomNum);
			return Vrm.callNext();
		}
		else
			return null;
	}
	
	private void AdminMod()
	{
	
		Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Admin Mod");
        System.out.println("h for help");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();

            switch (command) {
                case "h":
                    System.out.println(
                    		///general operations
                    		"h:    "+"help"+
                    		"\nq:    "+"quit"+
                    		"\nexit: "+"exit"+
                    		"\nl:    "+"print all staffs"+
                    		"\nlm:   "+"print all managers"+
                    		"\nlr:   "+"print all regular staffs"+
                    		"\nf:    "+"find specific staff"+
                    		"\nc:    "+"change salary"+
                    		"\ncs:   "+"check salary"+
                    		"\nfir:  "+"fire a staff"+
                    		"\ngd:   "+"get job description"+
                    		"\nsgd:  "+"set job description"+
                    		"\ngjb:  "+"get job type"+
                    		"\nsjb:  "+"set job type"+
                    		"\ngje:  "+"get job experience"+
                    		"\nsje:  "+"set job experience"+
                    		"\ngjt:  "+"get work time"+
                    		"\nsjt:  "+"set work time"+
                    		"\n///////////////////////////////////////"+
                    		"\nManager Option:"+
                    		"\ngsb:  "+"get suborinates"+
                    		"\nssb:  "+"set subordinates"+
                    		"\nadsb: "+"add subordinate"+
                    		"\nrmsb: "+"remove subordinate"+
                    		"\nhm:   "+"hire a manager"+
                    		"\n///////////////////////////////////////"+
                    		"\nReg Worker Option:"+
                    		"\ngsup:  "+"get supervisor"+
                    		"\nssup:  "+"set supervisor"+
                    		"\nhrg:   "+"hire a worker"+
                    		"\n///////////////////////////////////////"+
                    		"\nRooms Option:"+
                    		"\ncr:    "+"check all rooms"+
                    		"\ncvpr: "+"check vip rooms"+
                    		"\ncrgr: "+"check regular rooms"
                    );
                    break;

                case "l":
                    
                    break;

                case "lm":

                    break;

                case "lr":

                    break;

                case "f":

                    break;
                case "c":
                	
                	break;
                case "cs":
                	
                	break;
                case "fir":
                	
                	break;
				case "gd":
				                	
					break;
				case "sgd":
					
					break;
				case "gjb":
					
					break;
				case "sjb":
					
					break;
				case "gje":
					
					break;
				case "sje":
					
					break;
				case "gjt":
					
					break;
				case "sjt":
					
					break;
				case "gsb":
					
					break;
				case "ssb":
					
					break;
				case "adsb":
					
					break;
				case "rmsb":
				                	
					break;
				case "hm":
					
					break;
				case "gsup":
					
					break;
				case "ssup":
					
					break;
				case "hrg":
					
					break;
				case "cr":
					
					break;
				case "cvpr":
					
					break;
				case "crgr":
					
					break;
                	
                case "q":
                    System.out.println("Exiting Admin Mod.");
                    frame.setVisible(true);
                    return;
                case "exit":
                	System.exit(0);//shutdown the program
                	return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    
	}
	
}