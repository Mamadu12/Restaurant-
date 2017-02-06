import javax.swing.ImageIcon;

public class Main extends ItemsList{
	public Main(){
		super();
		
		super.addItem("Chicken with Palm Oil Sauce ", 3.99 , 200 ,"Special African Curry that makes gives the chicken hot and delicious tast",new ImageIcon("chicken_palmoil.jpg"));
		super.addItem("African Red Rice", 2.99 , 399 ,"Rice mixed with palm oil, veggies, tomato paste and fresh lemon wedges.",new ImageIcon("redrice.jpg")); 
		super.addItem("Golden Turkey with Green Lemon", 5.99 , 200 ,"6 fresh Italian parsley sprigs with lemon and carrots.",new ImageIcon("goldenturkey.jpg"));
		super.addItem("Fish on Grill", 14.99 , 398 ,"cooked to perfection over a wood-burning grill that gives it that unique, Bonefish Grill flavor.",new ImageIcon("ggrillfish.jpg"));
		super.addItem("OKra & Palin Rice", 11.75 , 350 ,"A Nigerian spice with a tart, lemony taste. Also known as bamia or ladies' fingers mixed with rice",new ImageIcon("okra_rice.jpg"));
		super.addItem("Pollo Carbonara", 15.00, 322, "Seasoned chicken, pancetta and spaghetti in a carbonara sauce.",new ImageIcon("polocarbonara.png"));
		super.addItem("Chicken Milanesa", 19.00, 411, 
				"With rocket, cherry tomatoes, red onion, bella lodi cheese, parsley and lemon. Served with "
						+ "spaghetti, in either pomodoro or bolognese sauce.",new ImageIcon("chikenmilanesa.jpg"));
		super.addItem("Steak & Rocked", 12.99, 309, "With red onion, peppers, cherry tomatoes, olives, bella lodi cheese with balsamic and olive oil dressed leaves.",new ImageIcon("steakrocked.png"));

		
		
		
		
	}

}



