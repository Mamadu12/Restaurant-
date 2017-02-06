import javax.swing.ImageIcon;

public class Dessert extends ItemsList
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Dessert(){
		super();

		super.addItem("Coconut Ice Cream",  3.99 , 200 , "Coconut ice cream with chopped almonds and chocolate chips.",new ImageIcon("cocoIcecream.jpg"));

		super.addItem("Bear Claw Ice Cream", 2.99, 207, "A dark chocolate ice cream filled with chocolate coated "
				+ "cashews and swirled with luscious thick golden caramel.",new ImageIcon("bearglow.jpg"));

		super.addItem("Mexican Mess",  4.99 , 248 , "Delicious mexican dessert made with corn, "
				+ "cheese, beans and a few spices",new ImageIcon("mexican mess.jpg"));

		super.addItem("Golden Nugget CheeseCake", 5.99 , 321 , "Gorgeous creamy cheesekace with crunchy. "
				+ "honeycomb and chocolate pieces",new ImageIcon("goldenNugget.jpg"));
		super.addItem("Banana Pudding", 4.99, 87, "Prepared with vanilla flavored custard, cookies and sliced fresh bananas, topped with whipped cream or meringue.",new ImageIcon("bananaPudim.jpg"));
		super.addItem("Warm Chocolate Cake", 5.00, 104, "Served with a German Coconut Pecan IcingPecan Brittle Ice Cream and Chocolate Fudge Sauce.",new ImageIcon("cholocatecake.jpg"));
	}


}
