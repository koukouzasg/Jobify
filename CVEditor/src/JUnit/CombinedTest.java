package JUnit;

import java.util.ArrayList;
import windowsBuilder.common.*;

public class CombinedTest {
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
		
		Paragraph info = new Paragraph("personal profile paragraph of combined");
		ArrayList<Paragraph> ppp = new ArrayList<Paragraph>();
		ppp.add(info);
		Section PP = new Section("PROFESSIONAL PROFILE",empty,emp);
		
		BulletListItem exp1 = new BulletListItem(2014,"Real");
		BulletListItem exp2 = new BulletListItem(2015,"Barcelona");
		BulletListItem exp3 = new BulletListItem(2017,"Panathinaikos");
		ArrayList<BulletListItem> exp = new ArrayList<BulletListItem>();
		exp.add(exp1);
		exp.add(exp2);
		exp.add(exp3);
		BulletList mm = new BulletList(exp,"Teams player for:");
		BulletListItem music = new BulletListItem(2017,"Rock");
		ArrayList<BulletListItem> genre = new ArrayList<BulletListItem>();
		genre.add(music);
		BulletList musicEdu = new BulletList(genre,"music education");
		ArrayList<BulletList> EXP = new ArrayList<BulletList>();
		EXP.add(mm);
		EXP.add(musicEdu);
		Section SE = new Section("Skills And Experience",empty,EXP);
		
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
		Section PE = new Section("PROFESSIONAL EXPERIENCE",empty,Skills);
		
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
		sl1.add(PE);
		sl1.add(ET);
		sl1.add(FC);
		sl1.add(AI);
		sl1.add(I);
		CV CVcom1 = new CV("Combined CV",sl1);
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
		
		info = new Paragraph("personal profile paragraph of chronological, 2nd template");
		ppp = new ArrayList<Paragraph>();
		ppp.add(info);
		PP = new Section("PROFESSIONAL PROFILE",empty,emp);
		
		exp1 = new BulletListItem(2014,"Real");
		exp2 = new BulletListItem(2015,"Barcelona");
		exp3 = new BulletListItem(2017,"Panathinaikos");
		exp = new ArrayList<BulletListItem>();
		exp.add(exp1);
		exp.add(exp2);
		exp.add(exp3);
		mm = new BulletList(exp,"Teams player for:");
		music = new BulletListItem(2017,"Rock");
		genre = new ArrayList<BulletListItem>();
		genre.add(music);
		musicEdu = new BulletList(genre,"music education");
		EXP = new ArrayList<BulletList>();
		EXP.add(mm);
		EXP.add(musicEdu);
		SE = new Section("Skills And Experience",empty,EXP);
		
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
		PE = new Section("PROFESSIONAL EXPERIENCE",empty,Skills);
		
		ed1 = new BulletListItem(2013,"Computer Science Engineering in Athens");
		ed2 = new BulletListItem(2010,"Third Highschool Triklino of Corfu");
		ed3 = new BulletListItem(2010,"Berkley music college");
		Train = new ArrayList<BulletListItem>();
		etb = new BulletList(Train,"");
		etb.addBulletListItem(ed1);
		etb.addBulletListItem(ed2);
		etb.addBulletListItem(ed3);
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
		sl1.add(PE);
		sl1.add(ET);
		sl1.add(FC);
		sl1.add(AI);
		sl1.add(I);
		CV CVcom2 = new CV("Combined CV",sl1);
/////////Second CV Template		
			
		CVcom1.writeToFile("First.txt");
		CVcom1.writeToLatex("First.tex");
		
		CVcom2.writeToFile("Second.txt");
		CVcom2.writeToLatex("Second.tex");
		CVcom1.openFile("Second.txt");
		CVcom1.openFile("Second.tex");
		CV CVmerged = new CV("", null);
		CVmerged.mergeFiles("First.txt", "Second.txt");
		CVmerged.writeToFile("Merged.txt");
		CVmerged.mergeFiles("First.tex", "Second.tex");
		CVmerged.writeToLatex("Merged.tex");
	}
}
