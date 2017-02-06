import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MenuItem {
	private String itemName;
	private double itemPrice;
	private int itemCalories;
	private int tableNumber;
	private int dinersNumber;
	private String itemDescription;
	private double total;
	private int totalCalories;
	private ImageIcon itemImage;

	public MenuItem (String name, double price, int calories, String description, ImageIcon image){
		itemName = name;
		itemPrice =  price;
		itemCalories = calories;
		itemDescription = description;
		itemImage = image;
		
	
	}
	public ImageIcon getItemImage(){
		return itemImage;
	}

	public String getItemName(){
		return itemName;
	}

	public double getItemPrice(){
		return itemPrice;
	}

	public int getItemCalories(){
		return itemCalories;
	}
	public int getTableNumber(){
		return tableNumber;
	}
	public int getDinersNumber(){
		return dinersNumber;
	}

	public String itemDescription(){
		return itemDescription;
	}


	public double getTotal(){
		return total;
	}
	public int getTotalCalories(){
		return totalCalories;
	}

	
	public void getItemDescription(String description){
		this.itemDescription = description;
	}

	public String toString(){
		return itemName + ": £" + itemPrice + ", " + itemCalories + " kcl ";
	}

	


}

