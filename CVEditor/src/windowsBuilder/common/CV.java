package windowsBuilder.common;

import java.util.ArrayList;
import java.util.ArrayList;
import java.awt.Container;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CV {
	private String name;
	private String address;
	private ArrayList<Section> listSection = new ArrayList<Section>();
	
	public CV(String name, ArrayList<Section> list) {
		this.name = name;
		this.listSection = list;
	}
	
	public void addSection(Section x) {
		this.listSection.add(x);
	}
	
	public void addParagraph(Section x) {
		listSection.add(x);
	}
	
	public ArrayList<Section> getSections() {
		return this.listSection;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean mergeFiles(String fileName1, String fileName2) {
		CV cv1 = new CV("", null);
		cv1.openFile(fileName1);
		CV cv2 = new CV("", null);
		cv2.openFile(fileName2);
		if(!cv1.getName().equals(cv2.getName())){
			JOptionPane.showMessageDialog(null, "Cannot compare two different types of CV templates");
			return false;
		}
		if(!cv1.getSections().get(0).getParagraphs().get(0).getContents().equals(cv2.getSections().get(0).getParagraphs().get(0).getContents())){
			JOptionPane.showMessageDialog(null, "These Templates belong to two different people so they cannot be merged");
			return false;
		}
				
		boolean flag = false;
		boolean minorFlag = false;
		
		for (int i = 1; i<8; i++){
			for(int j=0; j<cv2.getSections().get(i).getParagraphs().size(); j++){
				for(int k=0; k<cv1.getSections().get(i).getParagraphs().size(); k++){
					String contents2 = cv2.getSections().get(i).getParagraphs().get(j).getContents();
					String contents1 = cv1.getSections().get(i).getParagraphs().get(k).getContents();
					if(!contents2.equals(contents1)){
						if(fileName1.endsWith(".txt")) {
							String finalContent = contents1;
							finalContent += " . "+ contents2;
							cv1.getSections().get(i).getParagraphs().get(k).setContents(finalContent);
						}else {
							String finalContent = contents1;
							finalContent += "\\\\\n"+ contents2;
							cv1.getSections().get(i).getParagraphs().get(k).setContents(finalContent);
						}
					}
				}
			}
			for(int j=0; j<cv2.getSections().get(i).getBulletLists().size(); j++){
				flag = false;
				for(int k=0; k<cv1.getSections().get(i).getBulletLists().size(); k++){
					String contents2 = cv2.getSections().get(i).getBulletLists().get(j).getName();
					String contents1 = cv1.getSections().get(i).getBulletLists().get(k).getName();
					if(contents2.equals(contents1)){
						for (BulletListItem x: cv2.getSections().get(i).getBulletLists().get(j).getBulletList()) {
							minorFlag = false;
							for (BulletListItem y: cv1.getSections().get(i).getBulletLists().get(k).getBulletList()) {
								String bullets1 = x.getContents();
								String bullets2 = y.getContents();
								
								if(bullets1.equals(bullets2)){
									minorFlag = true;	
									break;
								}
							}
							//add BulletListItem
							if (minorFlag == false) {
								cv1.getSections().get(i).getBulletLists().get(k).getBulletList().add(x);
							}
						}
						flag = true;
						break;
					}
				}
				//addBulletList
				if (flag == false) {
					cv1.getSections().get(i).getBulletLists().add(cv2.getSections().get(i).getBulletLists().get(j));
				}
			}
		}
		this.name = cv1.getName();
		this.listSection = cv1.getSections();
		return true;
	}

	
	public void writeToFile(String fileName){
		FileOutputStream outputStream = null; 
		try {
			outputStream = new FileOutputStream(fileName);
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file stuff.txt.");
			System.exit(0);
		}
		PrintWriter outputWriter= new PrintWriter(outputStream);
		int count = 1;
		outputWriter.print("\t"+"\t"+this.name+"\n");
		for(Section x: listSection){
			outputWriter.print(count+". "+x.toText()+"\n");
			count++;
		}
		outputWriter.close();
	}
	
	public void writeToLatex(String fileName){
		FileOutputStream outputStream = null; 
		try {
			outputStream = new FileOutputStream(fileName);
		}catch(FileNotFoundException e) {
			System.out.println("Error opening "+fileName);
			System.exit(0);
		}
		PrintWriter outputWriter= new PrintWriter(outputStream);
		
		outputWriter.println("\\"+"documentclass{article}");
		outputWriter.println("\\"+"setlength{"+"\\"+"parskip}{1.2ex}");
		outputWriter.println("\\"+"setlength{"+"\\"+"parindent}{2em}");
		outputWriter.println("\\"+"title{CV template created by:}");
		outputWriter.println("\\"+"author{Jobify}");
		outputWriter.println("\\"+"begin{document}");
		outputWriter.println("\\"+"maketitle");
		outputWriter.println("\t"+"\\"+"begin{center}");
		outputWriter.println("\t"+"\\"+"line(1,0){300}"+"\\"+"\\");
		outputWriter.println("\t"+"[0.25in]");
		outputWriter.println("\t"+"\\"+"huge{\\"+"bfseries "+name+"}"+"\\"+"\\");
		outputWriter.println("\t"+"[2mm]");
		outputWriter.println("\t"+"\\"+"line(1,0){300}"+"\\"+"\\");
		outputWriter.println("\t"+"[1.5cm]");
		outputWriter.println("\t"+"\\"+"end{center}");
		
		for(Section x: listSection){
			outputWriter.println("\\"+"section{"+x.getTitle()+"}");
			for(int i = 0;i<x.getParagraphs().size();i++) {
				outputWriter.println(x.getParagraphs().get(i).getContents()+"\\"+"\\");
			}
			for(int i = 0;i<x.getBulletLists().size();i++) {
				if(x.getBulletLists().get(i).getName() != ""){
					outputWriter.println("\\"+"subsection{"+x.getBulletLists().get(i).getName()+"}");
				}
				outputWriter.println("\\"+"begin{itemize}");
				for(int j = 0;j<x.getBulletLists().get(i).getBulletList().size(); j++){
					outputWriter.println("\\"+"item "+x.getBulletLists().get(i).getBulletList().get(j).getContents()+":"+
							x.getBulletLists().get(i).getBulletList().get(j).getDate());
				}
				outputWriter.println("\\"+"end{itemize}");
			}
		}
		outputWriter.println("\\"+"end{document}");
		outputWriter.close();
	}

	public void openFile(String fileName){
		Scanner inputReader = null;
		try{
			inputReader = new Scanner(new FileInputStream(fileName));
		}
		catch(FileNotFoundException e){
			System.out.println("Error opening the file!");
			System.exit(0);
		}
		
		if(fileName.endsWith(".txt")){
			String line = inputReader.nextLine();
			if(line.contains("Functional")){
				String cvName = "Functional CV";
				line = inputReader.nextLine();
				if(!line.contains("GENERAL INFORMATION")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				String[] parts;
				ArrayList<Paragraph> parList = new ArrayList<Paragraph>();
				while(line.contains("\t")){
					if(!line.equals("\t")){
						parts = line.split("\t");
						parList.add(new Paragraph(parts[1]));
						line = inputReader.nextLine();
					}
					else{
						parList.add(new Paragraph(""));
						line = inputReader.nextLine();
					}
				}
				
				//Section added
				ArrayList<Paragraph> emptyPar = new ArrayList<Paragraph>();
				ArrayList<BulletList> emptyBull = new ArrayList<BulletList>();
				Section GI = new Section("GENERAL INFORMATION", parList, emptyBull ); // added section
				
				//NEW SECTION
				if(!line.contains("PROFESSIONAL PROFILE")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				Section PP = new Section("PROFESSIONAL PROFILE", emptyPar, emptyBull);
				if(line.contains("\t")){
					if(line.contains("\t")){
						parts = line.split("\t");
						Paragraph profprof;
						if(parts.length>0) {
							profprof = new Paragraph(parts[1]);
						}else {
							profprof = new Paragraph("");
						}			
						ArrayList<Paragraph> profileList = new ArrayList<Paragraph>();
						profileList.add(profprof);
						PP = new Section("PROFESSIONAL PROFILE", profileList, emptyBull);	
					}
					line = inputReader.nextLine();
				}
				
				//NEW SECTION
				if(!line.contains("SKILLS AND EXPERIENCE")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				ArrayList<BulletList> skillList = new ArrayList<BulletList>();
				int num = 0;
				while(line.contains("\t")){
					parts = line.split("\t");
					skillList.add(new BulletList(new ArrayList<BulletListItem>(), parts[1]));
					line = inputReader.nextLine();
					while(line.contains("*")){
						parts = line.split("\\*\t");
						String[] newTemp = parts[1].split(":");
						int tempNum = Integer.parseInt(newTemp[1]);
						skillList.get(num).getBulletList().add(new BulletListItem(tempNum, newTemp[0]));
						line = inputReader.nextLine();
					}
					num++;
				}
				Section SaE = new Section("SKILLS AND EXPERIENCE", emptyPar, skillList); //Section added
				//NEW SECTION
				Section CS = new Section("CAREER SUMMARY", emptyPar, emptyBull); 
				if(!line.contains("CAREER SUMMARY")){
					cvName = "Error";
				}
				line = inputReader.nextLine();	
				if(line.contains("\t")){
					ArrayList<BulletListItem> i2 = new ArrayList<BulletListItem>();
					ArrayList<BulletList> careerList = new ArrayList<BulletList>();
					BulletList b2 = new BulletList(i2, "");
					line = inputReader.nextLine();
					while(line.contains("*")){
						parts = line.split("\\*\t");
						String[] temp = parts[1].split(":");
						int tempNum = Integer.parseInt(temp[1]);
						b2.addBulletListItem(new BulletListItem(tempNum, temp[0]));
						line = inputReader.nextLine();
					}
					careerList.add(b2);
					CS = new Section("CAREER SUMMARY", emptyPar, careerList);
				}
				//SECTION ADDED
				
				//NEW SECTION
				if(!line.contains("EDUCATION AND TRAINING")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				Section EaT = new Section("EDUCATION AND TRAINING", emptyPar, emptyBull);
				if(line.contains("\t")){
					ArrayList<BulletListItem> i3 = new ArrayList<BulletListItem>();
					ArrayList<BulletList> edAndTrList = new ArrayList<BulletList>();
					BulletList b3 = new BulletList(i3, "");
					line = inputReader.nextLine();
					while(line.contains("\t")){
						parts = line.split("\\*\t");
						String[] temp = parts[1].split(":");
						int tempNum = Integer.parseInt(temp[1]);
						b3.addBulletListItem(new BulletListItem(tempNum, temp[0]));
						line = inputReader.nextLine();
					}
					edAndTrList.add(b3);
					EaT = new Section("EDUCATION AND TRAINING", emptyPar, edAndTrList);
				}
				 //SECTION ADDED
				
				//NEW SECTION
				if(!line.contains("FURTHER COURSES")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				ArrayList<BulletListItem> i4 = new ArrayList<BulletListItem>();
				Section FC = new Section("FURTHER COURSES", emptyPar, emptyBull); //SECTION ADDED
				ArrayList<BulletList> furCourList = new ArrayList<BulletList>();
				if(line.contains("\t")){
					BulletList b4 = new BulletList(i4, "");
					line = inputReader.nextLine();
					while(line.contains("\t")){
						parts = line.split("\\*\t");
						String[] temp = parts[1].split(":");
						int tempNum = Integer.parseInt(temp[1]);
						b4.addBulletListItem(new BulletListItem(tempNum, temp[0]));
						line = inputReader.nextLine();
					}
					furCourList.add(b4);
					FC = new Section("FURTHER COURSES", emptyPar, furCourList); //SECTION ADDED
				}
				
				//NEW SECTION
				if(!line.contains("ADDITIONAL INFORMATION")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				Section AI = new Section("ADDITIONAL INFORMATION", emptyPar, emptyBull); //section added
				if(line.contains("\t")){
					System.out.println(line);
					parts = line.split("\t");
					Paragraph information = new Paragraph("");
					if(parts.length>0) {
						information.setContents(parts[1]);
					}else {
						information.setContents("");
					}
					ArrayList<Paragraph> infoPar = new ArrayList<Paragraph>();
					infoPar.add(information);
					AI = new Section("ADDITIONAL INFORMATION", infoPar, emptyBull); //section added
					line = inputReader.nextLine();
				}
				
				//NEW SECTION
				if(!line.contains("INTERESTS")){
					cvName = "Error";
				}
				if(inputReader.hasNextLine()){
					line = inputReader.nextLine();
				}
				Section I = new Section("INTERESTS", emptyPar, emptyBull); //section added
				if(line.contains("\t")){
					parts = line.split("\t");
					Paragraph interests = new Paragraph("");
					if(parts.length>0) {
						interests.setContents(parts[1]);
					}else {
						interests.setContents("");
					}
					ArrayList<Paragraph> interPar = new ArrayList<Paragraph>();
					interPar.add(interests);
					I = new Section("INTERESTS", interPar, emptyBull); //section added
				}
				
				//Add CV
				ArrayList<Section> sectionList = new ArrayList<Section>();
				sectionList.add(GI);
				sectionList.add(PP);
				sectionList.add(SaE);
				sectionList.add(CS);
				sectionList.add(EaT);
				sectionList.add(FC);
				sectionList.add(AI);
				sectionList.add(I);
				this.listSection = sectionList;
				this.name = cvName;
				
			}else if(line.contains("Chronological")){
				String cvName = "Chronological CV";
				line = inputReader.nextLine();
				if(!line.contains("GENERAL INFORMATION")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				String[] parts;
				ArrayList<Paragraph> parList = new ArrayList<Paragraph>();
				while(line.contains("\t")){
					if(!line.equals("\t")){
						parts = line.split("\t");
						parList.add(new Paragraph(parts[1]));
						line = inputReader.nextLine();
					}
					else{
						parList.add(new Paragraph(""));
						line = inputReader.nextLine();
					}
				}
				
				//Section added
				ArrayList<Paragraph> emptyPar = new ArrayList<Paragraph>();
				ArrayList<BulletList> emptyBull = new ArrayList<BulletList>();
				Section GI = new Section("GENERAL INFORMATION", parList, emptyBull ); // added section
				
				//NEW SECTION
				if(!line.contains("PROFESSIONAL PROFILE")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				Section PP = new Section("PROFESSIONAL PROFILE", emptyPar, emptyBull);
				if(line.contains("\t")){
					if(line.contains("\t")){
						parts = line.split("\t");
						Paragraph profprof;
						if(parts.length>0) {
							 profprof = new Paragraph(parts[1]);
						}else {
							 profprof = new Paragraph("");
						}
						ArrayList<Paragraph> profileList = new ArrayList<Paragraph>();
						profileList.add(profprof);
						PP = new Section("PROFESSIONAL PROFILE", profileList, emptyBull);	
					}
					line = inputReader.nextLine();
				}
				
				//NEW SECTION
				if(!line.contains("CORE STRENGTHS")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				Section CS = new Section("CORE STRENGTHS", emptyPar, emptyBull);
				Paragraph coreSt;
				if(line.contains("\t")){
					parts = line.split("\t");
					if(parts.length>0) {
						coreSt = new Paragraph(parts[1]);
					}else {
						coreSt = new Paragraph("");
					}
					
					ArrayList<Paragraph> coreList = new ArrayList<Paragraph>();
					coreList.add(coreSt);
					CS = new Section("CORE STRENGTHS", coreList, emptyBull);				
					line = inputReader.nextLine();
				}
				
				
				//NEW SECTION
				if(!line.contains("PROFESSIONAL EXPERIENCE")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				ArrayList<BulletList> expList = new ArrayList<BulletList>();
				int num = 0;
				while(line.contains("\t")){
					parts = line.split("\t");
					expList.add(new BulletList(new ArrayList<BulletListItem>(), parts[1]));
					line = inputReader.nextLine();
					while(line.contains("*")){
						parts = line.split("\\*\t");
						String[] newTemp = parts[1].split(":");
						int tempNum = Integer.parseInt(newTemp[1]);
						expList.get(num).getBulletList().add(new BulletListItem(tempNum, newTemp[0]));
						line = inputReader.nextLine();
					}
					num++;
				}
				Section PE = new Section("PROFESSIONAL EXPERIENCE", emptyPar, expList); //Section added

				//NEW SECTION
				if(!line.contains("EDUCATION AND TRAINING")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				Section EaT = new Section("EDUCATION AND TRAINING", emptyPar, emptyBull);
				if(line.contains("\t")){
					ArrayList<BulletListItem> i3 = new ArrayList<BulletListItem>();
					ArrayList<BulletList> edAndTrList = new ArrayList<BulletList>();
					BulletList b3 = new BulletList(i3, "");
					line = inputReader.nextLine();
					while(line.contains("\t")){
						parts = line.split("\\*\t");
						String[] temp = parts[1].split(":");
						int tempNum = Integer.parseInt(temp[1]);
						b3.addBulletListItem(new BulletListItem(tempNum, temp[0]));
						line = inputReader.nextLine();
					}
					edAndTrList.add(b3);
					EaT = new Section("EDUCATION AND TRAINING", emptyPar, edAndTrList);
				}
				 //SECTION ADDED
				
				//NEW SECTION
				if(!line.contains("FURTHER COURSES")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				ArrayList<BulletListItem> i4 = new ArrayList<BulletListItem>();
				Section FC = new Section("FURTHER COURSES", emptyPar, emptyBull); //SECTION ADDED
				ArrayList<BulletList> furCourList = new ArrayList<BulletList>();
				if(line.contains("\t")){
					BulletList b4 = new BulletList(i4, "");
					line = inputReader.nextLine();
					while(line.contains("\t")){
						parts = line.split("\\*\t");
						String[] temp = parts[1].split(":");
						int tempNum = Integer.parseInt(temp[1]);
						b4.addBulletListItem(new BulletListItem(tempNum, temp[0]));
						line = inputReader.nextLine();
					}
					furCourList.add(b4);
					FC = new Section("FURTHER COURSES", emptyPar, furCourList); //SECTION ADDED
				}
				
				//NEW SECTION
				if(!line.contains("ADDITIONAL INFORMATION")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				Section AI = new Section("ADDITIONAL INFORMATION", emptyPar, emptyBull); //section added
				if(line.contains("\t")){
					System.out.println(line);
					parts = line.split("\t");
					Paragraph information = new Paragraph("");
					if(parts.length>0) {
						information.setContents(parts[1]);
					}else{
						information.setContents("");
					}
					ArrayList<Paragraph> infoPar = new ArrayList<Paragraph>();
					infoPar.add(information);
					AI = new Section("ADDITIONAL INFORMATION", infoPar, emptyBull); //section added
					line = inputReader.nextLine();
				}
				
				//NEW SECTION
				if(!line.contains("INTERESTS")){
					cvName = "Error";
				}
				if(inputReader.hasNextLine()){
					line = inputReader.nextLine();
				}
				Section I = new Section("INTERESTS", emptyPar, emptyBull); //section added
				if(line.contains("\t")){
					parts = line.split("\t");
					Paragraph interests = new Paragraph("");
					if(parts.length>0) {
						interests.setContents(parts[1]);
					}else{
						interests.setContents("");
					}
					ArrayList<Paragraph> interPar = new ArrayList<Paragraph>();
					interPar.add(interests);
					I = new Section("INTERESTS", interPar, emptyBull); //section added
				}
				
				//Add CV
				ArrayList<Section> sectionList = new ArrayList<Section>();
				sectionList.add(GI);
				sectionList.add(PP);
				sectionList.add(CS);
				sectionList.add(PE);
				sectionList.add(EaT);
				sectionList.add(FC);
				sectionList.add(AI);
				sectionList.add(I);
				this.listSection = sectionList;
				this.name = cvName;
				
			}else if(line.contains("Combined")){
				String cvName = "Combined CV";
				line = inputReader.nextLine();
				if(!line.contains("GENERAL INFORMATION")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				String[] parts;
				ArrayList<Paragraph> parList = new ArrayList<Paragraph>();
				while(line.contains("\t")){
					if(!line.equals("\t")){
						parts = line.split("\t");
						if(parts.length>0) {
							parList.add(new Paragraph(parts[1]));
						}else{
							parList.add(new Paragraph(""));
						}
						line = inputReader.nextLine();
					}
					else{
						parList.add(new Paragraph(""));
						line = inputReader.nextLine();
					}
				}
				
				//Section added
				ArrayList<Paragraph> emptyPar = new ArrayList<Paragraph>();
				ArrayList<BulletList> emptyBull = new ArrayList<BulletList>();
				Section GI = new Section("GENERAL INFORMATION", parList, emptyBull ); // added section
				
				//NEW SECTION
				if(!line.contains("PROFESSIONAL PROFILE")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				Section PP = new Section("PROFESSIONAL PROFILE", emptyPar, emptyBull);
				if(line.contains("\t")){
					if(line.contains("\t")){
						parts = line.split("\t");
						
						Paragraph profprof = new Paragraph(parts[1]);
						ArrayList<Paragraph> profileList = new ArrayList<Paragraph>();
						profileList.add(profprof);
						PP = new Section("PROFESSIONAL PROFILE", profileList, emptyBull);	
					}
					line = inputReader.nextLine();
				}
					
				
				
				//NEW SECTION
				if(!line.contains("SKILLS AND EXPERIENCE")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				ArrayList<BulletList> skillList = new ArrayList<BulletList>();
				int num = 0;
				while(line.contains("\t")){
					parts = line.split("\t");
					skillList.add(new BulletList(new ArrayList<BulletListItem>(), parts[1]));
					line = inputReader.nextLine();
					while(line.contains("*")){
						parts = line.split("\\*\t");
						String[] newTemp = parts[1].split(":");
						int tempNum = Integer.parseInt(newTemp[1]);
						skillList.get(num).getBulletList().add(new BulletListItem(tempNum, newTemp[0]));
						line = inputReader.nextLine();
					}
					num++;
					//line = inputReader.nextLine();
				}
				Section SaE = new Section("SKILLS AND EXPERIENCE", emptyPar, skillList); //Section added
				
				//NEW SECTION
				if(!line.contains("PROFESSIONAL EXPERIENCE")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				ArrayList<BulletList> expList = new ArrayList<BulletList>();
				num = 0;
				while(line.contains("\t")){
					parts = line.split("\t");
					expList.add(new BulletList(new ArrayList<BulletListItem>(), parts[1]));
					line = inputReader.nextLine();
					while(line.contains("*")){
						parts = line.split("\\*\t");
						String[] newTemp = parts[1].split(":");
						int tempNum = Integer.parseInt(newTemp[1]);
						expList.get(num).getBulletList().add(new BulletListItem(tempNum, newTemp[0]));
						line = inputReader.nextLine();
					}
					num++;
				}
				Section PE = new Section("PROFESSIONAL EXPERIENCE", emptyPar, expList); //Section added

				//NEW SECTION
				if(!line.contains("EDUCATION AND TRAINING")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				Section EaT = new Section("EDUCATION AND TRAINING", emptyPar, emptyBull);
				if(line.contains("\t")){
					ArrayList<BulletListItem> i3 = new ArrayList<BulletListItem>();
					ArrayList<BulletList> edAndTrList = new ArrayList<BulletList>();
					BulletList b3 = new BulletList(i3, "");
					line = inputReader.nextLine();
					while(line.contains("\t")){
						parts = line.split("\\*\t");
						String[] temp = parts[1].split(":");
						int tempNum = Integer.parseInt(temp[1]);
						b3.addBulletListItem(new BulletListItem(tempNum, temp[0]));
						line = inputReader.nextLine();
					}
					edAndTrList.add(b3);
					EaT = new Section("EDUCATION AND TRAINING", emptyPar, edAndTrList);
				}
				 //SECTION ADDED
				
				//NEW SECTION
				if(!line.contains("FURTHER COURSES")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				ArrayList<BulletListItem> i4 = new ArrayList<BulletListItem>();
				Section FC = new Section("FURTHER COURSES", emptyPar, emptyBull); //SECTION ADDED
				ArrayList<BulletList> furCourList = new ArrayList<BulletList>();
				if(line.contains("\t")){
					BulletList b4 = new BulletList(i4, "");
					line = inputReader.nextLine();
					while(line.contains("\t")){
						parts = line.split("\\*\t");
						String[] temp = parts[1].split(":");
						int tempNum = Integer.parseInt(temp[1]);
						b4.addBulletListItem(new BulletListItem(tempNum, temp[0]));
						line = inputReader.nextLine();
					}
					furCourList.add(b4);
					FC = new Section("FURTHER COURSES", emptyPar, furCourList); //SECTION ADDED
				}
				
				//NEW SECTION
				if(!line.contains("ADDITIONAL INFORMATION")){
					cvName = "Error";
				}
				line = inputReader.nextLine();
				Section AI = new Section("ADDITIONAL INFORMATION", emptyPar, emptyBull); //section added
				if(line.contains("\t")){
					System.out.println(line);
					parts = line.split("\t");
					Paragraph information = new Paragraph("");
					if(parts.length>0) {
						information.setContents(parts[1]);
					}else {
						information.setContents("");
					}
					ArrayList<Paragraph> infoPar = new ArrayList<Paragraph>();
					infoPar.add(information);
					AI = new Section("ADDITIONAL INFORMATION", infoPar, emptyBull); //section added
					line = inputReader.nextLine();
				}
				
				//NEW SECTION
				if(!line.contains("INTERESTS")){
					cvName = "Error";
				}
				if(inputReader.hasNextLine()){
					line = inputReader.nextLine();
				}
				Section I = new Section("INTERESTS", emptyPar, emptyBull); //section added
				if(line.contains("\t")){
					parts = line.split("\t");
					Paragraph interests = new Paragraph("");
					if(parts.length>0) {
						interests.setContents(parts[1]);
					}else {
						interests.setContents("");
					}
					ArrayList<Paragraph> interPar = new ArrayList<Paragraph>();
					interPar.add(interests);
					I = new Section("INTERESTS", interPar, emptyBull); //section added
				}
				
				//Add CV
				ArrayList<Section> sectionList = new ArrayList<Section>();
				sectionList.add(GI);
				sectionList.add(PP);
				sectionList.add(SaE);
				sectionList.add(PE);
				sectionList.add(EaT);
				sectionList.add(FC);
				sectionList.add(AI);
				sectionList.add(I);
				this.listSection = sectionList;
				this.name = cvName;
				
			}
		}else if(fileName.endsWith(".tex")){
			String line = inputReader.nextLine();
			if(line.startsWith("\\"+"documentclass")){
				line = inputReader.nextLine();
				while(!line.startsWith("\\"+"begin{document}")){
					line = inputReader.nextLine();
				}
				line = inputReader.nextLine();
				while(!line.contains("CV")){
					line = inputReader.nextLine();
				}
				if(line.contains("Functional")){
					String cvName = "Functional CV";
					line = inputReader.nextLine();
					while(!line.startsWith("\\"+"section{GENERAL INFORMATION}")){
						line = inputReader.nextLine();
					}
					line = inputReader.nextLine();
					String[] parts;
					ArrayList<Paragraph> parList = new ArrayList<Paragraph>();
					ArrayList<Paragraph> emptyPar = new ArrayList<Paragraph>();
					ArrayList<BulletList> emptyBull = new ArrayList<BulletList>();
					while(line.contains("\\\\")){
						parts = line.split("\\\\");
						if(parts.length>0) {
							parList.add(new Paragraph(parts[0]));
						}else {
							parList.add(new Paragraph(""));
						}
						line = inputReader.nextLine();
					}
					Section GI = new Section("GENERAL INFORMATION", parList, emptyBull ); // added section
					//NEW SECTION
					if(!line.contains("PROFESSIONAL PROFILE")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					Section PP = new Section("PROFESSIONAL PROFILE", emptyPar, emptyBull);
					if(line.contains("\\\\")){
						parts = line.split("\\\\");
						Paragraph profile = new Paragraph("");
						if(parts.length>0) {
							profile.setContents(parts[0]);
						}else{
							profile.setContents("");
						}
						//Section added
						ArrayList<Paragraph> profPar = new ArrayList<Paragraph>();
						profPar.add(profile);
						PP = new Section("PROFESSIONAL PROFILE", profPar, emptyBull);
						line = inputReader.nextLine();
					}
					
					
					
					//NEW SECTION
					if(!line.contains("SKILLS AND EXPERIENCE")){
						cvName = "Error";
					}
					
					line = inputReader.nextLine();
					ArrayList<BulletList> skillList = new ArrayList<BulletList>();
					int num =0;
					while(line.startsWith("\\"+"subsection")){
						parts = line.split("\\{");
						String[] temp = parts[1].split("}");
						line = inputReader.nextLine();  //begin itemize
						line = inputReader.nextLine();
						skillList.add(new BulletList(new ArrayList<BulletListItem>(), temp[0]));
						while(line.startsWith("\\"+"item")){
							parts = line.split("item ");
							temp = parts[1].split(":");
							int tempNum = Integer.parseInt(temp[1]);
							skillList.get(num).getBulletList().add(new BulletListItem(tempNum, temp[0]));
							line = inputReader.nextLine();
						}
						num++;
						line = inputReader.nextLine();
					}
					Section SaE = new Section("SKILLS AND EXPERIENCE", emptyPar, skillList); //Section added
					
					
					if(!line.contains("CAREER SUMMARY")){
						cvName = "Error";
						return;
					}
					line = inputReader.nextLine();
					ArrayList<BulletList> careerList = new ArrayList<BulletList>();
					careerList.add(new BulletList(new ArrayList<BulletListItem>(), ""));
					if(!line.contains("section")){
						line = inputReader.nextLine();
						while(line.startsWith("\\"+"item")){
							parts = line.split("item ");
							String[] temp = parts[1].split(":");
							int tempNum = Integer.parseInt(temp[1]);
							careerList.get(0).addBulletListItem(new BulletListItem(tempNum, temp[0]));
							line = inputReader.nextLine();
						}
						line = inputReader.nextLine();
					}
					Section CS = new Section("CAREER SUMMARY", emptyPar, careerList); //SECTION ADDED
					//NEW SECTION
					if(!line.contains("EDUCATION AND TRAINING")){
						cvName = "Error";
						return;
					}
					line = inputReader.nextLine();
					ArrayList<BulletList> edAndTrList = new ArrayList<BulletList>();
					edAndTrList.add(new BulletList(new ArrayList<BulletListItem>(), ""));
					if(!line.contains("section")){
						line = inputReader.nextLine();
						while(line.startsWith("\\"+"item")){
							parts = line.split("item ");
							String[] temp = parts[1].split(":");
							int tempNum = Integer.parseInt(temp[1]);
							edAndTrList.get(0).addBulletListItem(new BulletListItem(tempNum, temp[0]));
							line = inputReader.nextLine();
						}
						line = inputReader.nextLine();
					}
					Section EaT = new Section("EDUCATION AND TRAINING", emptyPar, edAndTrList); //SECTION ADDED
					//NEW SECTION
					if(!line.contains("FURTHER COURSES")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					ArrayList<BulletList> furCourList = new ArrayList<BulletList>();
					furCourList.add(new BulletList(new ArrayList<BulletListItem>(), ""));
					if(!line.contains("section")){
						line = inputReader.nextLine();
						while(line.startsWith("\\"+"item")){
							parts = line.split("item ");
							String[] temp = parts[1].split(":");
							int tempNum = Integer.parseInt(temp[1]);
							furCourList.get(0).addBulletListItem(new BulletListItem(tempNum, temp[0]));
							line = inputReader.nextLine();
						}
						line = inputReader.nextLine();
					}
					Section FC = new Section("FURTHER COURSES", emptyPar, furCourList); //SECTION ADDED
					
				
					//NEW SECTION
					if(!line.contains("ADDITIONAL INFORMATION")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					Section AI = new Section("ADDITIONAL INFORMATION", emptyPar, emptyBull); //section added
					if(line.contains("\\\\")){
						parts = line.split("\\\\");
						Paragraph information = new Paragraph("");
						if(parts.length>0) {
							information.setContents(parts[0]);
						}else {
							information.setContents("");
						}
						
						ArrayList<Paragraph> infoPar = new ArrayList<Paragraph>();
						infoPar.add(information);
						AI = new Section("ADDITIONAL INFORMATION", infoPar, emptyBull); //section added
						line = inputReader.nextLine();
					}
					
					//NEW SECTION
					
					if(!line.contains("INTERESTS")){
						cvName = "Error";
					}
					Section I = new Section("INTERESTS", emptyPar, emptyBull); //section added
					line = inputReader.nextLine();
					if(line.contains("\\\\")){
						parts = line.split("\\\\");
						Paragraph interests = new Paragraph("");
						if(parts.length>0) {
							interests.setContents(parts[0]);
						}else {
							interests.setContents("");
						}
						ArrayList<Paragraph> interPar = new ArrayList<Paragraph>();
						interPar.add(interests);
						I = new Section("INTERESTS", interPar, emptyBull); //section added
						line = inputReader.nextLine();
					}
					
					
					//Add CV
					ArrayList<Section> sectionList = new ArrayList<Section>();
					sectionList.add(GI);
					sectionList.add(PP);
					sectionList.add(SaE);
					sectionList.add(CS);
					sectionList.add(EaT);
					sectionList.add(FC);
					sectionList.add(AI);
					sectionList.add(I);
					this.listSection = sectionList;
					this.name = cvName;
					
			//Loading a Chronological CV Template
				}else if(line.contains("Chronological")){
					String cvName = "Chronological CV";
					line = inputReader.nextLine();
					while(!line.startsWith("\\"+"section{GENERAL INFORMATION}")){
						line = inputReader.nextLine();
					}
					line = inputReader.nextLine();
					String[] parts;
					ArrayList<Paragraph> parList = new ArrayList<Paragraph>();
					ArrayList<Paragraph> emptyPar = new ArrayList<Paragraph>();
					ArrayList<BulletList> emptyBull = new ArrayList<BulletList>();
					while(line.contains("\\\\")){
						parts = line.split("\\\\");
						parList.add(new Paragraph(parts[0]));
						line = inputReader.nextLine();
					}
					
					Section GI = new Section("GENERAL INFORMATION", parList, emptyBull ); // added section
					//NEW SECTION
					if(!line.contains("PROFESSIONAL PROFILE")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					Section PP = new Section("PROFESSIONAL PROFILE", emptyPar, emptyBull);
					if(line.contains("\\\\")){
						parts = line.split("\\\\");
						Paragraph profile = new Paragraph("");
						profile.setContents(parts[0]);					
						//Section added
						ArrayList<Paragraph> profPar = new ArrayList<Paragraph>();
						profPar.add(profile);
						PP = new Section("PROFESSIONAL PROFILE", profPar, emptyBull);
						line = inputReader.nextLine();
					}
					
					//NEW SECTION
					if(!line.contains("CORE STRENGTHS")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					Section CS = new Section("CORE STRENGTHS", emptyPar, emptyBull);
					if(line.contains("\\\\")){
						parts = line.split("\\\\");
						Paragraph coreStr = new Paragraph("");
						if(parts.length>0) {
							coreStr.setContents(parts[0]);
						}else {
							coreStr.setContents("");
						}										
						//Section added
						ArrayList<Paragraph> coreStrengths = new ArrayList<Paragraph>();
						coreStrengths.add(coreStr);
						CS = new Section("CORE STRENGTHS", coreStrengths, emptyBull);				
						line = inputReader.nextLine();
					}
					
					
					if(!line.contains("PROFESSIONAL EXPERIENCE")){
						cvName = "Error";
					}
					
					line = inputReader.nextLine();
					ArrayList<BulletList> profList = new ArrayList<BulletList>();
					int num =0;
					while(line.startsWith("\\"+"subsection")){
						parts = line.split("\\{");
						String[] temp = parts[1].split("}");
						profList.add(new BulletList(new ArrayList<BulletListItem>(), temp[0]));
						line = inputReader.nextLine();  //begin itemize
						line = inputReader.nextLine();
						
						while(line.startsWith("\\"+"item")){
							parts = line.split("item ");
							temp = parts[1].split(":");
							int tempNum = Integer.parseInt(temp[1]);
							profList.get(num).getBulletList().add(new BulletListItem(tempNum, temp[0]));
							line = inputReader.nextLine();
						}
						num++;
						line = inputReader.nextLine();
					}
					Section PE = new Section("PROFESSIONAL EXPERIENCE", emptyPar, profList); //Section added
					
					
					//NEW SECTION
					if(!line.contains("EDUCATION AND TRAINING")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					ArrayList<BulletList> edAndTrList = new ArrayList<BulletList>();
					edAndTrList.add(new BulletList(new ArrayList<BulletListItem>(), ""));
					if(!line.contains("section")){
						line = inputReader.nextLine();
						while(line.startsWith("\\"+"item")){
							parts = line.split("item ");
							String[] temp = parts[1].split(":");
							int tempNum = Integer.parseInt(temp[1]);
							edAndTrList.get(0).addBulletListItem(new BulletListItem(tempNum, temp[0]));
							line = inputReader.nextLine();
						}
						line = inputReader.nextLine();
					}
					Section EaT = new Section("EDUCATION AND TRAINING", emptyPar, edAndTrList); //SECTION ADDED
					
					
					//NEW SECTION
					if(!line.contains("FURTHER COURSES")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					ArrayList<BulletList> furCourList = new ArrayList<BulletList>();
					furCourList.add(new BulletList(new ArrayList<BulletListItem>(), ""));
					if(!line.contains("section")){
						line = inputReader.nextLine();
						while(line.startsWith("\\"+"item")){
							parts = line.split("item ");
							String[] temp = parts[1].split(":");
							int tempNum = Integer.parseInt(temp[1]);
							furCourList.get(0).addBulletListItem(new BulletListItem(tempNum, temp[0]));
							line = inputReader.nextLine();
						}
						line = inputReader.nextLine();
					}
					Section FC = new Section("FURTHER COURSES", emptyPar, furCourList); //SECTION ADDED
					//NEW SECTION
					if(!line.contains("ADDITIONAL INFORMATION")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					Section AI = new Section("ADDITIONAL INFORMATION", emptyPar, emptyBull); //section added
					if(line.contains("\\\\")){
						parts = line.split("\\\\");
						Paragraph information = new Paragraph("");
						information.setContents(parts[0]);
						ArrayList<Paragraph> infoPar = new ArrayList<Paragraph>();
						infoPar.add(information);
						AI = new Section("ADDITIONAL INFORMATION", infoPar, emptyBull); //section added
						line = inputReader.nextLine();
					}
					
					//NEW SECTION
					
					if(!line.contains("INTERESTS")){
						cvName = "Error";
					}
					Section I = new Section("INTERESTS", emptyPar, emptyBull); //section added
					line = inputReader.nextLine();
					if(line.contains("\\\\")){
						parts = line.split("\\\\");
						Paragraph interests = new Paragraph("");
						if(parts.length > 0) {
							interests.setContents(parts[0]);
						}else {
							interests.setContents("");
						}
						ArrayList<Paragraph> interPar = new ArrayList<Paragraph>();
						interPar.add(interests);
						I = new Section("INTERESTS", interPar, emptyBull); //section added
						line = inputReader.nextLine();
					}
					

					
					//Add CV
					ArrayList<Section> sectionList = new ArrayList<Section>();
					sectionList.add(GI);
					sectionList.add(PP);
					sectionList.add(CS);
					sectionList.add(PE);
					sectionList.add(EaT);
					sectionList.add(FC);
					sectionList.add(AI);
					sectionList.add(I);
					this.listSection = sectionList;
					this.name = cvName;
					
					
			//Loading a Combined CV Template
				}else if(line.contains("Combined")){
					String cvName = "Combined CV";
					line = inputReader.nextLine();
					while(!line.startsWith("\\"+"section{GENERAL INFORMATION}")){
						line = inputReader.nextLine();
					}
					line = inputReader.nextLine();
					String[] parts;
					ArrayList<Paragraph> parList = new ArrayList<Paragraph>();
					ArrayList<Paragraph> emptyPar = new ArrayList<Paragraph>();
					ArrayList<BulletList> emptyBull = new ArrayList<BulletList>();
					while(line.contains("\\\\")){
						parts = line.split("\\\\");
						if(parts.length>0) {
							parList.add(new Paragraph(parts[0]));
						}else {
							parList.add(new Paragraph(""));
						}
						line = inputReader.nextLine();
					}
					
					Section GI = new Section("GENERAL INFORMATION", parList, emptyBull ); // added section
					//NEW SECTION
					if(!line.contains("PROFESSIONAL PROFILE")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					Section PP = new Section("PROFESSIONAL PROFILE", emptyPar, emptyBull);
					if(line.contains("\\\\")){
						parts = line.split("\\\\");
						Paragraph profile = new Paragraph("");
						if(parts.length>0) {
							profile.setContents(parts[0]);
						}else {
							profile.setContents("");
						}					
						//Section added
						ArrayList<Paragraph> profPar = new ArrayList<Paragraph>();
						profPar.add(profile);
						PP = new Section("PROFESSIONAL PROFILE", profPar, emptyBull);
						line = inputReader.nextLine();
					}
					//NEW SECTION
					if(!line.contains("SKILLS AND EXPERIENCE")){
						cvName = "Error";
					}
					
					line = inputReader.nextLine();
					ArrayList<BulletList> skillList = new ArrayList<BulletList>();
					int num =0;
					while(line.startsWith("\\"+"subsection")){
						parts = line.split("\\{");
						String[] temp = parts[1].split("}");
						skillList.add(new BulletList(new ArrayList<BulletListItem>(), temp[0]));
						line = inputReader.nextLine();  //begin itemize
						line = inputReader.nextLine();
						
						while(line.startsWith("\\"+"item")){
							parts = line.split("item ");
							temp = parts[1].split(":");
							int tempNum = Integer.parseInt(temp[1]);
							skillList.get(num).getBulletList().add(new BulletListItem(tempNum, temp[0]));
							line = inputReader.nextLine();
						}
						num++;
						line = inputReader.nextLine();
					}
					Section SaE = new Section("SKILLS AND EXPERIENCE", emptyPar, skillList); //Section added
					
					
					
					if(!line.contains("PROFESSIONAL EXPERIENCE")){
						cvName = "Error";
					}
					
					line = inputReader.nextLine();
					ArrayList<BulletList> profList = new ArrayList<BulletList>();
					num =0;
					while(line.startsWith("\\"+"subsection")){
						parts = line.split("\\{");
						String[] temp = parts[1].split("}");
						line = inputReader.nextLine();  //begin itemize
						line = inputReader.nextLine();
						profList.add(new BulletList(new ArrayList<BulletListItem>(), temp[0]));
						while(line.startsWith("\\"+"item")){
							parts = line.split("item ");
							temp = parts[1].split(":");
							int tempNum = Integer.parseInt(temp[1]);
							profList.get(num).getBulletList().add(new BulletListItem(tempNum, temp[0]));
							line = inputReader.nextLine();
						}
						num++;
						line = inputReader.nextLine();
					}
					Section PE = new Section("PROFESSIONAL EXPERIENCE", emptyPar, profList); //Section added	
					
					//NEW SECTION
					if(!line.contains("EDUCATION AND TRAINING")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					ArrayList<BulletList> edAndTrList = new ArrayList<BulletList>();
					edAndTrList.add(new BulletList(new ArrayList<BulletListItem>(), ""));
					if(!line.contains("section")){
						line = inputReader.nextLine();
						while(line.startsWith("\\"+"item")){
							parts = line.split("item ");
							String[] temp = parts[1].split(":");
							int tempNum = Integer.parseInt(temp[1]);
							edAndTrList.get(0).addBulletListItem(new BulletListItem(tempNum, temp[0]));
							line = inputReader.nextLine();
						}
						line = inputReader.nextLine();
					}
					Section EaT = new Section("EDUCATION AND TRAINING", emptyPar, edAndTrList); //SECTION ADDED
					
					//NEW SECTION
					if(!line.contains("FURTHER COURSES")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					ArrayList<BulletList> furCourList = new ArrayList<BulletList>();
					furCourList.add(new BulletList(new ArrayList<BulletListItem>(), ""));
					if(!line.contains("section")){
						line = inputReader.nextLine();
						while(line.startsWith("\\"+"item")){
							parts = line.split("item ");
							String[] temp = parts[1].split(":");
							int tempNum = Integer.parseInt(temp[1]);
							furCourList.get(0).addBulletListItem(new BulletListItem(tempNum, temp[0]));
							line = inputReader.nextLine();
						}
						line = inputReader.nextLine();
					}
					Section FC = new Section("FURTHER COURSES", emptyPar, furCourList); //SECTION ADDED
					//NEW SECTION
					if(!line.contains("ADDITIONAL INFORMATION")){
						cvName = "Error";
					}
					line = inputReader.nextLine();
					Section AI = new Section("ADDITIONAL INFORMATION", emptyPar, emptyBull); //section added
					if(line.contains("\\\\")){
						parts = line.split("\\\\");
						Paragraph information = new Paragraph("");
						if(parts.length>0) {
							information.setContents(parts[0]);
						}else {
							information.setContents("");
						}
						
						ArrayList<Paragraph> infoPar = new ArrayList<Paragraph>();
						infoPar.add(information);
						AI = new Section("ADDITIONAL INFORMATION", infoPar, emptyBull); //section added
						line = inputReader.nextLine();
					}
					
					//NEW SECTION
					
					if(!line.contains("INTERESTS")){
						cvName = "Error";
					}
					Section I = new Section("INTERESTS", emptyPar, emptyBull); //section added
					line = inputReader.nextLine();
					if(line.contains("\\\\")){
						parts = line.split("\\\\");
						Paragraph interests = new Paragraph("");
						if(parts.length > 0) {
							interests.setContents(parts[0]);
						}else {
							interests.setContents("");
						}
						ArrayList<Paragraph> interPar = new ArrayList<Paragraph>();
						interPar.add(interests);
						I = new Section("INTERESTS", interPar, emptyBull); //section added
						line = inputReader.nextLine();
					}
					
					
					//Add CV
					ArrayList<Section> sectionList = new ArrayList<Section>();
					sectionList.add(GI);
					sectionList.add(PP);
					sectionList.add(SaE);
					sectionList.add(PE);
					sectionList.add(EaT);
					sectionList.add(FC);
					sectionList.add(AI);
					sectionList.add(I);
					this.listSection = sectionList;
					this.name = cvName;
				}	
			}
		}
	}
	
}
