package JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;


import org.junit.Test;

import windowsBuilder.common.BulletList;
import windowsBuilder.common.BulletListItem;

public class BulletListTest {

	private ArrayList<BulletListItem> listItem = new ArrayList<BulletListItem>();
	private BulletListItem b1 = new BulletListItem(2016, "Real Madrid, Football player");
	private BulletListItem b2 = new BulletListItem(2017, "Jobify, Developer");
	private String name = "Career Summary";
	
	
	@Test
	public void testGetName() {
		listItem.add(b1);
		listItem.add(b2);
		BulletList test = new BulletList(listItem, name);
		assertEquals("Career Summary", test.getName());
	}

	@Test
	public void testGetBulletList() {
		listItem.add(b1);
		listItem.add(b2);
		BulletList test = new BulletList(listItem, name);
		
		assertEquals(listItem, test.getBulletList());
	}

	@Test
	public void testSetName() {
		listItem.add(b1);
		listItem.add(b2);
		BulletList test = new BulletList(listItem, name);
		
		test.setName("Jobs");
		
		assertEquals("Jobs", test.getName());
	}

}
