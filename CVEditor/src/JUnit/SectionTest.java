package JUnit;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import windowsBuilder.common.*;


public class SectionTest {

	private ArrayList<Paragraph> empty = new ArrayList<Paragraph>();
	private ArrayList<BulletList> emp = new ArrayList<BulletList>();
	private Paragraph info = new Paragraph("Jobify, Developer");
	private ArrayList<Paragraph> ppp = new ArrayList<Paragraph>();
	
	private BulletListItem ed1 = new BulletListItem(2013,"Computer Science Engineering in Ioannina");
	private ArrayList<BulletListItem> Train = new ArrayList<BulletListItem>();
	private BulletList etb = new BulletList(Train,"");
	
	
	@Test
	public void testGetBulletLists() {		
		etb.addBulletListItem(ed1);
		ArrayList<BulletList> etblist = new ArrayList<BulletList>();
		etblist.add(etb);
		Section ET = new Section("EDUCATION AND TRAINING",empty,etblist);
		
		assertEquals(etblist, ET.getBulletArrays());
		
	}

	@Test
	public void testGetParagraphs() {
		ppp.add(info);
		Section PP = new Section("PROFESSIONAL PROFILE",ppp,emp);
		
		assertEquals(ppp, PP.getParagraphs());
	}

}
