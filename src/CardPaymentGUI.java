import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class CardPaymentGUI extends JDialog {

	protected static final char[] i = null;
	protected static final String order = null;
	protected static final String total = null;
	private final JPanel paymentPanel = new JPanel();
	private JButton buttonConclude;
	private JTextField nameTextField;
	private JTextField cardTextField;
	private JComboBox<Object> yearComboBox ;
	private JComboBox<Object> cardTypeComboBox;
	private JComboBox<Object> monthComboBox;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CardPaymentGUI dialog = new CardPaymentGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CardPaymentGUI() {
		setTitle("PAYMENT");
		setBounds(100, 100, 435, 308);
		getContentPane().setLayout(new BorderLayout());
		paymentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(paymentPanel, BorderLayout.CENTER);
		paymentPanel.setLayout(null);

		JLabel label = new JLabel("Please enter your details");
		label.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBounds(144, 11, 181, 28);
		paymentPanel.add(label);

		JLabel nameLabel = new JLabel("Name on Card:");
		nameLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		nameLabel.setBounds(10, 49, 109, 20);
		paymentPanel.add(nameLabel);

		nameTextField = new JTextField();
		nameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char enter = e.getKeyChar();
				if(((Character.isAlphabetic(enter)) || (enter == KeyEvent.VK_SPACE) ||
						(enter == KeyEvent.VK_BACK_SPACE)||(enter ==KeyEvent.VK_DELETE)))	{
					e.getID();
					nameTextField.setBackground(Color.white);
				} else{
					e.consume();
					nameTextField.setBackground(Color.red);
					JOptionPane.showMessageDialog(CardPaymentGUI.this, "Only Alphabetic characters are allowed");
				}
			}
		});
		nameTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		nameTextField.setColumns(10);
		nameTextField.setBounds(129, 50, 214, 20);
		paymentPanel.add(nameTextField);

		JLabel cardLabel = new JLabel("Card Number:");
		cardLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cardLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		cardLabel.setBounds(10, 98, 97, 20);
		paymentPanel.add(cardLabel);

		JLabel dateLabel = new JLabel("Expire Date:");
		dateLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		dateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		dateLabel.setBounds(10, 129, 97, 20);
		paymentPanel.add(dateLabel);

		JLabel cardTypeLabel = new JLabel("Credit Card Type:");
		cardTypeLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cardTypeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		cardTypeLabel.setBounds(10, 160, 121, 20);
		paymentPanel.add(cardTypeLabel);

		cardTextField = new JTextField();
		cardTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		cardTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		cardTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char enter = arg0.getKeyChar();
				if(((Character.isDigit(enter)) || (enter == KeyEvent.VK_SPACE) ||
						(enter == KeyEvent.VK_BACK_SPACE)||(enter ==KeyEvent.VK_DELETE)))	{
					arg0.getID();
					cardTextField.setBackground(Color.white);
				}else{
					cardTextField.setBackground(Color.RED);
					arg0.consume();
					JOptionPane.showMessageDialog(CardPaymentGUI.this, "Only numbers are allowed");
				}				
			}
		});
		cardTextField.setColumns(10);
		cardTextField.setBounds(129, 99, 214, 20);
		paymentPanel.add(cardTextField);

		String[] months = {"Month","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		monthComboBox = new JComboBox<Object>(months);
		monthComboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		monthComboBox.setFont(new Font("Arial", Font.PLAIN, 11));
		monthComboBox.setBounds(129, 130, 86, 20);
		paymentPanel.add(monthComboBox);

		String[] years = {"Year","2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2028", "2029"};
		yearComboBox = new JComboBox<Object>(years);
		yearComboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		yearComboBox.setFont(new Font("Arial", Font.PLAIN, 11));
		yearComboBox.setBounds(241, 130, 80, 20);
		paymentPanel.add(yearComboBox);

		String[] cardType = {"Card","Debit MasterCard", "Visa Debit", "Maestro", "Visa Electron", "PayPall"};
		cardTypeComboBox = new JComboBox<Object>(cardType);
		cardTypeComboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cardTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 11));
		cardTypeComboBox.setBounds(161, 161, 130, 20);
		paymentPanel.add(cardTypeComboBox);

		buttonConclude = new JButton("Conclude Order");
		buttonConclude.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		buttonConclude.setFont(new Font("Arial", Font.PLAIN, 11));
		buttonConclude.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				concludeOrder();
			}	


		});
		buttonConclude.setBounds(161, 214, 130, 28);
		paymentPanel.add(buttonConclude);
	}


	private void concludeOrder(){
		if(	nameTextField.getText().isEmpty() && cardTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(CardPaymentGUI.this, "Please fill in the above spaces");

		} else if(nameTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(CardPaymentGUI.this, "Please Insert your name");

		}else if(cardTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(CardPaymentGUI.this, "Please Insert your Card number");

		}else if(monthComboBox.getSelectedItem().equals("Month")){
			JOptionPane.showMessageDialog(CardPaymentGUI.this, "Please select a month");

		}else if(yearComboBox.getSelectedItem().equals("Year")){
			JOptionPane.showMessageDialog(CardPaymentGUI.this, "Please select a year to proceed");	

		}else if(cardTypeComboBox.getSelectedItem().equals("Card")){
			JOptionPane.showMessageDialog(CardPaymentGUI.this, "Please select your card type");

		}else{
			JOptionPane.showMessageDialog(CardPaymentGUI.this, "Your order is being processed");
			dispose();
		}

	}

	private void exit(int j) {
		// TODO Auto-generated method stub

	}
}
