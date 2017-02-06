import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.im.InputContext;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale.Category;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;

public class MenuGUI extends JFrame implements ActionListener{

	protected static final String itemImage = null;
	private DefaultListModel<MenuItem> orderList;
	ItemsList itemList = new ItemsList();
	private JList<MenuItem> listOrder ;
	private DefaultTableModel model;
	private JPanel contentPane;
	private JPanel panelOrder;
	private Starter starterList;
	private Main mainList;
	private Dessert dessertList;
	private Drinks drinksList;
	private JList listCourse;
	private JTextField priceTextField;
	private JTextField kcalTextField;
	private JTextField itemDesc;
	private JPopupMenu paymentPopup;
	private JButton btnAdd;
	private JButton btnRemove;
	private JComboBox comboCourses;
	private JComboBox comboDiners;
	private JComboBox comboTables;
	private JTable table;
	private JScrollPane scrollDesc;
	private JLabel lblTotalPrice;
	private JLabel lblSelectACourse;
	private JLabel lblTotalCalories;
	private JLabel lblItemDescription;
	private JLabel imageLabel;
	private JPanel panelNewCustomer;
	private JButton btnNewCustomer;
	private JScrollPane scrollOrderList;
	private JScrollPane scrollCourse;
	private JButton btnLucky;
	private JButton btnLuckydip;
	private JLabel lblImage;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI frame = new MenuGUI();
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
	public MenuGUI() {
		setBackground(new Color(255, 222, 173));

		///Item lists

		starterList = new Starter();
		mainList = new Main();
		dessertList = new Dessert();
		drinksList = new Drinks();
		setResizable(false);

		setTitle("African Flavour ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1425, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 128)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblSelectACourse = new JLabel("Select a Course");
		lblSelectACourse.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblSelectACourse.setForeground(new Color(255, 0, 0));
		lblSelectACourse.setBackground(Color.LIGHT_GRAY);
		lblSelectACourse.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSelectACourse.setBounds(10, 26, 123, 24);
		contentPane.add(lblSelectACourse);

		listCourse = new JList();
		listCourse.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuItem selectedItem = (MenuItem) listCourse.getSelectedValue();
				if(selectedItem !=null){
					String description = selectedItem.itemDescription();
					itemDesc.setText(description);
					imageLabel.setIcon(selectedItem.getItemImage());
					
				}
				
				
			}
		});
		listCourse.setForeground(Color.BLACK);

		listCourse.setBounds(10, 81, 280, 362);
		contentPane.add(listCourse);
		listCourse.setBackground(new Color(245, 245, 245));
		listCourse.setFont(new Font("Arial", Font.PLAIN, 17));

		scrollCourse = new JScrollPane();
		scrollCourse.getViewport().setView(listCourse);
		scrollCourse.setBounds(10, 81, 280, 362);
		contentPane.add(scrollCourse);

		// ORDER TABLE:

		//BUTTON ADD 

		btnAdd = new JButton("Add >>");
		btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addItem();
			}

		});
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 13));
		btnAdd.setBounds(312, 140, 102, 45);
		contentPane.add(btnAdd);

		// BUTTON REMOVE

		model = new DefaultTableModel();
		btnRemove = new JButton("<< Remove");
		btnRemove.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
		btnRemove.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				removeItem();
			}

			private MenuItem table(int selectedItem) {
				return null;
			}	
		});
		btnRemove.setFont(new Font("Arial", Font.PLAIN, 13));
		btnRemove.setBounds(312, 217, 102, 45);
		contentPane.add(btnRemove);

		// COMBO BOX WITH THE COURSES NAMES

		String[] course = {"Courses","","Starter", "Main", "Dessert", "Drinks"};
		comboCourses = new JComboBox(course);
		comboCourses.setBackground(Color.WHITE);
		comboCourses.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		comboCourses.setForeground(Color.BLACK);
		comboCourses.setFont(new Font("Arial", Font.PLAIN, 16));
		comboCourses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				comboCourses();
			}
		});
		comboCourses.addKeyListener(new KeyAdapter() {

		});
		comboCourses.setBounds(134, 26, 123, 24);
		contentPane.add(comboCourses);

		lblItemDescription = new JLabel("Description:");
		lblItemDescription.setForeground(new Color(255, 0, 0));
		lblItemDescription.setBorder(new CompoundBorder());
		lblItemDescription.setFont(new Font("Arial", Font.PLAIN, 14));
		lblItemDescription.setBounds(38, 467, 86, 34);
		contentPane.add(lblItemDescription);

		scrollDesc = new JScrollPane();
		scrollDesc.setBorder(new CompoundBorder());
		scrollDesc.setBounds(121, 467, 704, 34);
		contentPane.add(scrollDesc);


		String[] tables = {"Table", "Table1","Table 2", "Table 3", "Table 4", "Table 5", "Table 6"}; 
		String[] diners = {"Customer","Person 1", "Person 2", "Person 3", "Person 4", "Person 5"};

		panelNewCustomer = new JPanel();
		panelNewCustomer.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		panelNewCustomer.setBounds(294, 11, 456, 45);
		contentPane.add(panelNewCustomer);
		panelNewCustomer.setLayout(null);
		comboTables = new JComboBox(tables);
		comboTables.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		comboTables.setBounds(10, 9, 139, 24);
		panelNewCustomer.add(comboTables);

		btnNewCustomer = new JButton("Add Customer");
		btnNewCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {



				if(comboTables.getSelectedItem().equals("Table") &&(comboDiners.getSelectedItem().equals("Customer"))){
					JOptionPane.showMessageDialog(MenuGUI.this, "Please select state your table and diners number");
					btnAdd.setEnabled(false);
					btnRemove.setEnabled(false);


				} else{
					addToOrderList((String)comboTables.getSelectedItem() + "\n" +"\n" + comboDiners.getSelectedItem());
					btnAdd.setEnabled(true);
					btnRemove.setEnabled(true);

				}

			}
			private void addToOrderList(String value) {
				model = (DefaultTableModel) table.getModel();		
				model.addRow(new Object[]{value, "", "", ""});

			}
		});
		btnNewCustomer.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnNewCustomer.setBounds(161, 8, 136, 25);
		panelNewCustomer.add(btnNewCustomer);
		btnNewCustomer.setFont(new Font("Arial", Font.PLAIN, 13));
		comboDiners = new JComboBox(diners);
		comboDiners.setBounds(307, 9, 141, 25);
		panelNewCustomer.add(comboDiners);
		comboDiners.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));

		itemDesc = new JTextField();
		itemDesc.setBounds(121, 467, 702, 32);
		contentPane.add(itemDesc);
		itemDesc.setFont(new Font("Arial", Font.PLAIN, 12));
		itemDesc.setBackground(Color.WHITE);
		itemDesc.setBorder(UIManager.getBorder("ScrollPane.border"));
		itemDesc.setEditable(false);
		itemDesc.setColumns(10);
		scrollDesc.getViewport().setView(itemDesc);

		panelOrder = new JPanel();
		panelOrder.setBounds(424, 81, 310, 366);
		contentPane.add(panelOrder);
		panelOrder.setLayout(null);

		scrollOrderList = new JScrollPane();
		scrollOrderList.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollOrderList.setBounds(0, 0, 310, 366);
		panelOrder.add(scrollOrderList);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollOrderList.setColumnHeaderView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				" Name ", "  Price  ", "  Calories  "
			}
		));
		scrollOrderList.setViewportView(table);

		JButton btnClearOrder = new JButton("Clear Order");
		btnClearOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearAll();
			}
			
			private void invalidate() {
			// TODO Auto-generated method stub

			}

		});
		btnClearOrder.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
		btnClearOrder.setFont(new Font("Arial", Font.PLAIN, 11));
		btnClearOrder.setBounds(312, 369, 102, 45);
		contentPane.add(btnClearOrder);

		JPanel panelOrder_1 = new JPanel();
		panelOrder_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
		panelOrder_1.setBounds(760, 11, 221, 362);
		contentPane.add(panelOrder_1);
		panelOrder_1.setLayout(null);

		lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setBounds(27, 11, 156, 30);
		panelOrder_1.add(lblTotalPrice);
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblTotalPrice.setFont(new Font("Arial", Font.PLAIN, 16));

		priceTextField = new JTextField();
		priceTextField.setBounds(51, 61, 115, 24);
		panelOrder_1.add(priceTextField);
		priceTextField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		priceTextField.setEditable(false);
		priceTextField.setText("0");

		priceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		priceTextField.setColumns(10);

		lblTotalCalories = new JLabel("Total Calories");
		lblTotalCalories.setBounds(27, 125, 156, 30);
		panelOrder_1.add(lblTotalCalories);
		lblTotalCalories.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalCalories.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblTotalCalories.setFont(new Font("Arial", Font.PLAIN, 16));

		kcalTextField = new JTextField();
		kcalTextField.setBounds(54, 181, 112, 24);
		panelOrder_1.add(kcalTextField);
		kcalTextField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		kcalTextField.setEditable(false);
		kcalTextField.setText("0");
		kcalTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		kcalTextField.setColumns(10);

		JButton btnFinishOrder = new JButton("Conclude ");
		btnFinishOrder.setBounds(51, 243, 115, 47);
		panelOrder_1.add(btnFinishOrder);
		btnFinishOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String String;
				addToOrderList((String)priceTextField.getText() + kcalTextField.getText());

			}
			private void addToOrderList(String string) {
				model = (DefaultTableModel) table.getModel();		
				model.addRow(new Object[]{ "", "Total: " + priceTextField.getText(), kcalTextField.getText()+ " kcal"});


			}
		});
		btnFinishOrder.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
		btnFinishOrder.setFont(new Font("Arial", Font.PLAIN, 11));
		
				JButton btnCash = new JButton("Cash");
				btnCash.setBounds(10, 308, 92, 30);
				panelOrder_1.add(btnCash);
				btnCash.addActionListener(new ActionListener() {
					
					private double total;
					
					public void actionPerformed(ActionEvent arg0) {
						printReceipt();
					}
				});
				btnCash.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
				btnCash.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCash.setEnabled(true);
		
				JButton btnCard = new JButton("Card");
				btnCard.setBounds(119, 308, 92, 30);
				panelOrder_1.add(btnCard);
				btnCard.setFont(new Font("Arial", Font.PLAIN, 13));
				btnCard.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CardPaymentGUI instance = new CardPaymentGUI();
						instance.setVisible(true);
						dispose();
					}
				});
				btnCard.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
		
		btnLuckydip = new JButton("Lucky Dip");
		btnLuckydip.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
		btnLuckydip.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLuckydip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random randomItem = new Random();
				
				MenuItem random = (MenuItem) starterList.get(randomItem.nextInt(starterList.size()));
				MenuItem random1 = (MenuItem) mainList.get(randomItem.nextInt(mainList.size()));
				MenuItem random2 = (MenuItem) dessertList.get(randomItem.nextInt(dessertList.size()));
				MenuItem random3 = (MenuItem) drinksList.get(randomItem.nextInt(drinksList.size()));
				
				model = (DefaultTableModel) table.getModel();
				
				model.addRow(new Object[]{random.getItemName(), random.getItemPrice(), random.getItemCalories()});
				model.addRow(new Object[]{random1.getItemName(), random1.getItemPrice(), random1.getItemCalories()});
				model.addRow(new Object[]{random2.getItemName(), random2.getItemPrice(), random2.getItemCalories()});
				model.addRow(new Object[]{random3.getItemName(), random3.getItemPrice(), random3.getItemCalories()});
				
				double orderPrice = (random.getItemPrice() + random1.getItemPrice() + random2.getItemPrice() + random3.getItemPrice()) ;
				double curentAmmount = Double.parseDouble(priceTextField.getText());
				double total = orderPrice + curentAmmount; 
				priceTextField.setText(Double.toString(total));

				int orderCalories =  (random.getItemCalories() +random1.getItemCalories() + random2.getItemCalories() + random3.getItemCalories()) ;
				int currentCalories = Integer.parseInt(kcalTextField.getText());
				int totalkcal = orderCalories + currentCalories;
				kcalTextField.setText(String.valueOf(totalkcal));
				
			}
		});
		btnLuckydip.setBounds(312, 295, 102, 45);
		contentPane.add(btnLuckydip);
		
		imageLabel = new JLabel("");
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		imageLabel.setBounds(991, 65, 396, 362);
		contentPane.add(imageLabel);
		
		lblImage = new JLabel("Image");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setFont(new Font("Arial", Font.PLAIN, 15));
		lblImage.setBounds(1116, 11, 188, 24);
		contentPane.add(lblImage);

	}	

	private void addItem(){

		// Get selected object from the listCourse

		MenuItem selectedItem = (MenuItem) listCourse.getSelectedValue();

		// Check if any object has been selected

		if(selectedItem != null) {
			model = (DefaultTableModel) table.getModel();		
			model.addRow(new Object[]{selectedItem.getItemName(), selectedItem.getItemPrice(), selectedItem.getItemCalories()});

			double orderPrice = selectedItem.getItemPrice();
			double curentAmmount = Double.parseDouble(priceTextField.getText());
			double total = orderPrice + curentAmmount; 
			priceTextField.setText(Double.toString(total));


			int orderCalories = selectedItem.getItemCalories();
			int currentCalories = Integer.parseInt(kcalTextField.getText());
			int totalkcal = orderCalories + currentCalories;
			kcalTextField.setText(String.valueOf(totalkcal));
		}
		else 
		{

			JOptionPane.showMessageDialog(MenuGUI.this, "Please select a course and then select an Item to add");

		}
	}
	private void removeItem(){
		
		//Get selected object
		int selectedItem = table.getSelectedRow();

		if(selectedItem != -1 ){
			double orderPrice =  (Double)model.getValueAt(selectedItem, 1);
			double curentAmmount = Double.parseDouble(priceTextField.getText());
			double total = curentAmmount - orderPrice;
			priceTextField.setText(Double.toString(total));

			int itemCalories = (Integer)model.getValueAt(selectedItem, 2);
			int curentCalories = Integer.parseInt(kcalTextField.getText());
			int totalkcal = curentCalories - itemCalories;
			kcalTextField.setText(String.valueOf(totalkcal));

			model.removeRow(table.getSelectedRow());
		}

		else{
			JOptionPane.showMessageDialog(MenuGUI.this, "Please select an Item to remove");
		}


	}
	private void clearAll(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();	
		model.getDataVector().removeAllElements();

		priceTextField.setText("");
		kcalTextField.setText("");

		model.fireTableDataChanged();
		table.repaint();
		this.invalidate();
	}
	private void comboCourses(){
		String selectedValue = (String) comboCourses.getSelectedItem();

		if(selectedValue.equals("Starter")) {
			listCourse.setModel(starterList);

		} else if(selectedValue.equals("Main")) {
			listCourse.setModel(mainList); 

		} else if(selectedValue.equals("Dessert")){
			listCourse.setModel(dessertList);
		}
		else  if(selectedValue.equals("Drinks")){
			listCourse.setModel(drinksList);

		}else{
			listCourse.setModel(new DefaultListModel());
		}
	}

	private void itemDescription(){
		MenuItem selectedItem = (MenuItem) listCourse.getSelectedValue();
		if (selectedItem !=null){	
			String description = selectedItem.itemDescription();
			itemDesc.setText(description);
		} 
		else
		{
			JOptionPane.showMessageDialog(MenuGUI.this, "Please select a course");
			itemDesc.setText(null);
		}
	}
		
		
	private  void printReceipt(){
		if(table.getModel().equals(null)){
			System.out.print("Plese order first");
		}
		else{
			MessageFormat header = new MessageFormat("Receitp");
			MessageFormat footer = new MessageFormat("Page{0,number,integer}");
			MessageFormat price = new MessageFormat(priceTextField.getText());
			MessageFormat kcal = new MessageFormat(kcalTextField.getText());
			try{
				table.print();

			}catch(java.awt.print.PrinterException e){
				System.err.format("Cannot Print %s%n", e.getMessage());
			}
		}

	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {


	}

	public static String getResource(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

