import java.net.URL;

import javax.swing.ImageIcon;

public class Drinks extends ItemsList {

	private String itemImage;

	public Drinks() {

		super();	

		super.addItem("Water", 0.00 , 00 ,"Natural/mineral water", new ImageIcon("water.jpg"));
		super.addItem("Pepsi", 2.75 , 149 ,"Pepsi/Coke with zero sugar", new ImageIcon("pepsi.jpg")); 
		super.addItem("Mango Juice", 5.99 , 171 ,"Tropical mango juice ",new ImageIcon("mangojuice.jpg"));
		super.addItem("Hot Tea", 2.99, 15, "Hot Water available with Assorted Tea Blends.",new ImageIcon("hottea.jpeg"));
		super.addItem("Sangria (Wine Drink of the Island Gods)", 3.50, 45, "Orange juice, lime juice and grapefruit with rum and vodka",new ImageIcon("Sangria.jpg"));
		
		
		
	}




}


