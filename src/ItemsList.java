import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

	
public class ItemsList extends DefaultListModel
{
	public ItemsList()
	{
		super();
	}
	public void addItem(String name, double price, int calories, String description, ImageIcon image)
	{
		super.addElement(new MenuItem(name, price, calories, description,image));
	}
	public Object getItemName(String itemName) {
		// TODO Auto-generated method stub
		return itemName;
	}
	public Object getItemPrice(int price) {
		// TODO Auto-generated method stub
		return price;
	}
	


}
