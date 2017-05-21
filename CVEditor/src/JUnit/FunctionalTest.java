package JUnit;

import java.util.ArrayList;
import windowsBuilder.common.*;

public class FunctionalTest {
	public static void main(String[] args) {
		ArrayList<Paragraph> empty = new ArrayList<Paragraph>();
		ArrayList<BulletList> emp = new ArrayList<BulletList>();
		
		Paragraph name = new Paragraph("name");
		Paragraph address = new Paragraph("address");
		Paragraph Telephone = new Paragraph("tel");
		Paragraph Mobile = new Paragraph("mob");
		Paragraph email = new Paragraph("email");
		ArrayList<Paragraph> gip = new ArrayList<Paragraph>();
		gip.add(name);
		gip.add(address);
		gip.add(Telephone);
		gip.add(Mobile);
		gip.add(email);
		Section GI = new Section("GENERAL INFORMATION",gip,emp);
		
		Paragraph info = new Paragraph("personal profile paragraph of functional");
		ArrayList<Paragraph> ppp = new ArrayList<Paragraph>();
		ppp.add(info);
		Section PP = new Section("PROFESSIONAL PROFILE",empty,emp);
		
		
		
		BulletListItem prog1 = new BulletListItem(2014,"python");
		BulletListItem prog2 = new BulletListItem(2015,"C");
		BulletListItem prog3 = new BulletListItem(2017,"latex");
		ArrayList<BulletListItem> prog = new ArrayList<BulletListItem>();
		prog.add(prog1);
		prog.add(prog2);
		prog.add(prog3);
		BulletList lang = new BulletList(prog,"Program Languages");
		BulletListItem def = new BulletListItem(2017,"jazz");
		ArrayList<BulletListItem> ball = new ArrayList<BulletListItem>();
		ball.add(def);
		BulletList football = new BulletList(ball,"music education");
		ArrayList<BulletList> Skills = new ArrayList<BulletList>();
		Skills.add(lang);
		Skills.add(football);
		Section SE = new Section("Skills And Experience",empty,Skills);
		
		Paragraph career = new Paragraph("career summary of functional");
		ArrayList<Paragraph> careerSum = new ArrayList<Paragraph>();
		careerSum.add(career);
		Section CS = new Section("Career Summary",careerSum,emp);
		
		BulletListItem ed1 = new BulletListItem(2013,"Computer Science Engineering in Ioannina");
		BulletListItem ed2 = new BulletListItem(2010,"Third Highschool afras mono of Corfu");
		BulletListItem ed3 = new BulletListItem(2010,"Berkley music college");
		ArrayList<BulletListItem> Train = new ArrayList<BulletListItem>();
		BulletList etb = new BulletList(Train,"");
		etb.addBulletListItem(ed1);
		etb.addBulletListItem(ed2);
		etb.addBulletListItem(ed3);
		ArrayList<BulletList> etblist = new ArrayList<BulletList>();
		etblist.add(etb);
		Section ET = new Section("EDUCATION AND TRAINING",empty,etblist);
		
		BulletListItem c1 = new BulletListItem(2013,"Mathematics in Ioannina");
		ArrayList<BulletListItem> fci = new ArrayList<BulletListItem>();
		BulletList fcb = new BulletList(fci,"");
		fcb.addBulletListItem(c1);
		ArrayList<BulletList> fcblist = new ArrayList<BulletList>();
		fcblist.add(fcb);
		Section FC = new Section("FURTHER COURSES",empty,emp);
		
		Paragraph add = new Paragraph("Social and patient");
		ArrayList<Paragraph> aip = new ArrayList<Paragraph>();
		aip.add(add);
		Section AI = new Section("ADDITIONAL INFORMATION",empty,emp);
		
		Paragraph inter = new Paragraph("Sports");
		ArrayList<Paragraph> intrs = new ArrayList<Paragraph>();
		intrs.add(inter);
		Section I = new Section("INTERESTS",intrs,emp);

		ArrayList<Section> sl1 = new ArrayList<Section>();
		sl1.add(GI);
		sl1.add(PP);
		sl1.add(SE);
		sl1.add(CS);
		sl1.add(ET);
		sl1.add(FC);
		sl1.add(AI);
		sl1.add(I);
		CV CVfun1 = new CV("Functional CV",sl1);
/////////// First CV template		
		name = new Paragraph("name");
		address = new Paragraph("address");
		Telephone = new Paragraph("tel");
		Mobile = new Paragraph("mob");
		email = new Paragraph("email");
		gip = new ArrayList<Paragraph>();
		gip.add(name);
		gip.add(address);
		gip.add(Telephone);
		gip.add(Mobile);
		gip.add(email);
		GI = new Section("GENERAL INFORMATION",gip,emp);
		
		info = new Paragraph("personal profile paragraph of functional, 2nd template");
		ppp = new ArrayList<Paragraph>();
		ppp.add(info);
		PP = new Section("PROFESSIONAL PROFILE",empty,emp);
		
		prog1 = new BulletListItem(2014,"python");
		prog2 = new BulletListItem(2015,"C");
		prog3 = new BulletListItem(2017,"latex");
		prog = new ArrayList<BulletListItem>();
		prog.add(prog1);
		prog.add(prog2);
		prog.add(prog3);
		lang = new BulletList(prog,"Program Languages");
		def = new BulletListItem(2017,"jazz");
		ball = new ArrayList<BulletListItem>();
		ball.add(def);
		football = new BulletList(ball,"music education");
		Skills = new ArrayList<BulletList>();
		Skills.add(lang);
		Skills.add(football);
		SE = new Section("Skills And Experience",empty,Skills);
		
		career = new Paragraph("career summary of functional,template 2");
		careerSum = new ArrayList<Paragraph>();
		careerSum.add(career);
		CS = new Section("Career Summary",careerSum,emp);
		
		ed1 = new BulletListItem(2013,"Computer Science Engineering in Athens");
		ed2 = new BulletListItem(2010,"Third Highschool Triklino of Corfu");
		Train = new ArrayList<BulletListItem>();
		etb = new BulletList(Train,"");
		etb.addBulletListItem(ed1);
		etb.addBulletListItem(ed2);
		etblist = new ArrayList<BulletList>();
		etblist.add(etb);
		ET = new Section("EDUCATION AND TRAINING",empty,etblist);
		
		c1 = new BulletListItem(2013,"Mathematics in Ioannina");
		fci = new ArrayList<BulletListItem>();
		fcb = new BulletList(fci,"");
		fcb.addBulletListItem(c1);
		fcblist = new ArrayList<BulletList>();
		fcblist.add(fcb);
		FC = new Section("FURTHER COURSES",empty,emp);
		
		add = new Paragraph("Social only");
		aip = new ArrayList<Paragraph>();
		aip.add(add);
		AI = new Section("ADDITIONAL INFORMATION",empty,emp);
		
		inter = new Paragraph("Music");
		intrs = new ArrayList<Paragraph>();
		intrs.add(inter);
		I = new Section("INTERESTS",intrs,emp);

		sl1 = new ArrayList<Section>();
		sl1.add(GI);
		sl1.add(PP);
		sl1.add(SE);
		sl1.add(CS);
		sl1.add(ET);
		sl1.add(FC);
		sl1.add(AI);
		sl1.add(I);
		CV CVfun2 = new CV("Functional CV",sl1);
/////////Second CV Template		
			
		CVfun1.writeToFile("First.txt");
		CVfun1.writeToLatex("First.tex");
		
		CVfun2.writeToFile("Second.txt");
		CVfun2.writeToLatex("Second.tex");
		CVfun1.openFile("First.txt");
		CVfun1.openFile("First.tex");
		CV CVmerged = new CV("", null);
		CVmerged.mergeFiles("First.txt", "Second.txt");
		CVmerged.writeToFile("Merged.txt");
		CVmerged.mergeFiles("First.tex", "Second.tex");
		CVmerged.writeToLatex("Merged.tex");
	}
}
