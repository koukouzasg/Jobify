package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import windowsBuilder.common.Paragraph;

public class ParagraphTest {

	private Paragraph p1 = new Paragraph("Music enthusiast");
	
	@Test
	public void testSetContents() {
		p1.setContents("Hiking");
		
		assertEquals("Hiking", p1.getContents());
	}

	@Test
	public void testGetContents() {
		
		assertEquals("Music enthusiast", p1.getContents());
	}

}
