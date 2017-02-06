import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Test;

public class MenuItemTest {

	@Test
	public void testGetItemImage() {
		MenuItem test = new MenuItem("justA test", 2.00, 45, "description test", new ImageIcon("rice.jpg"));
		ImageIcon output = test.getItemImage();
		Object itemImage;
		return;
	}
	


	@Test
	public void testGetItemPrice() {
		MenuItem test = new MenuItem("pizza", 2.00, 45, "description test", new ImageIcon(""));
		double output = test.getItemPrice();
		assertEquals(2.00, output, 0.001);
	}

	@Test
	public void testGetItemCalories() {
		MenuItem test2 = new MenuItem("rice", 2.00, 457, "description test", new ImageIcon(""));
		int output = test2.getItemCalories();
		assertEquals(457, output, 0.001);
	}
}
	


