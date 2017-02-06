import javax.swing.ImageIcon;

public class Starter extends ItemsList{

	public Starter() {
		
		super();	

		super.addItem("Garlic Bread", 3.99 , 175 ,"Bread toasted and flavored with butter and garlic.", new ImageIcon("garlicBread.jpg")); 
		super.addItem("Chicken Wings", 7.50 , 200 ,"Deep-fried, unbreaded, and coated in vinegar-based cayenne pepper hot sauce and butter.",new ImageIcon("chickenwings.jpg"));
		super.addItem("Sweet Potato Soup", 4.99 , 399 ,"Spicy ginger, and sweet and salty miso all meet in this easy, delicious soup.",new ImageIcon("sweet potato.jpg"));
		super.addItem("Chicken liver", 10.00 , 315 ,"A rich, sweet pâté recipe using pineau - a sherry-like aperitif.",new ImageIcon("chickenLiver.jpg"));
		super.addItem("Tuna Takani", 18, 450, "Marinated with soya and lime, avocado purée",new ImageIcon("tunatakani.jpg"));
		super.addItem("King Prawns", 7.99, 162, "In a pomodoro sauce with garlic, red chilli and spinach. Served with toasted sourdough",new ImageIcon("kingpraw.jpg"));
		super.addItem("Crispy Crab & Citrus Salad", 4.99, 120, "With sweet roquito chilli pearls, mixed leaves, cucumber, and a St. Clements citrus, chilli and mint dressing",new ImageIcon("crispy crab.jpg"));
	
	
	
	
	}
	

	public int getSelectedIndex() {
		// TODO Auto-generated method stub
		return 0;
	}	

}


