package hotel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TSSTTEE {

	private JFrame Book;
	private JTextField txtCheckindate;
	private JTextField txtDays;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TSSTTEE window = new TSSTTEE();
					window.Book.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TSSTTEE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Book = new JFrame();
		Book.setBounds(100, 100, 450, 300);
		Book.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Book.getContentPane().setLayout(null);
		
		JButton btnAddToCart = new JButton("AddToCart");
		btnAddToCart.setBounds(174, 200, 101, 27);
		Book.getContentPane().add(btnAddToCart);
		
		JLabel lblRoomnum = new JLabel("RoomNum");
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
		
		txtCheckindate = new JTextField();
		txtCheckindate.setText("CheckInDate");
		txtCheckindate.setBounds(235, 122, 114, 21);
		Book.getContentPane().add(txtCheckindate);
		txtCheckindate.setColumns(10);
		
		txtDays = new JTextField();
		txtDays.setText("Days");
		txtDays.setBounds(235, 93, 114, 21);
		Book.getContentPane().add(txtDays);
		txtDays.setColumns(10);
	}
}
