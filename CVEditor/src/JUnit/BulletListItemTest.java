package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import windowsBuilder.common.BulletListItem;

public class BulletListItemTest {

	private BulletListItem b1 = new BulletListItem(2016, "Real Madrid, Football player");
	
	@Test
	public void testGetDate() {
		
		assertEquals(2016, b1.getDate());
	}

	@Test
	public void testGetContents() {
		assertEquals("Real Madrid, Football player", b1.getContents());
	}

	@Test
	public void testSetDate() {
		b1.setDate(6102);
		
		assertEquals(6102, b1.getDate());
	}

	@Test
	public void testSetContents() {
		b1.setContents("Google, DevOps");
		
		assertEquals("Google, DevOps", b1.getContents());
	}

}
