package windowsBuilder.common;

import java.util.ArrayList;

public  class Section {
	
	private String title;
	private ArrayList<Paragraph> paragraphs;
	private ArrayList<BulletList> bulletArrays;    //We may need a bulletList array for CombinedCV 4 	
	
	public Section(String title,ArrayList<Paragraph> paragraphs,ArrayList<BulletList> bulletArrays){
		this.title = title;
		this.paragraphs = paragraphs;
		this.bulletArrays = bulletArrays;
		
	}
	
	public ArrayList<BulletList> getBulletLists(){
		return this.bulletArrays;
	}
	
	public ArrayList<Paragraph> getParagraphs(){
		return this.paragraphs;
	}
	
	public ArrayList<BulletList> getBulletArrays(){
		return this.bulletArrays;
	}
	
	public void addParagraph(Paragraph x) {
		this.paragraphs.add(x);
	}	
	
	public void setParagraph(Paragraph x) {
		ArrayList<Paragraph> array = new ArrayList<Paragraph>(); 
		array.add(x);
		this.paragraphs = array;
	}
	
	public void setParagraphs(ArrayList<Paragraph> array) {
		this.paragraphs = array;
	}
	public void  addBulletList(BulletList x) {
		this.bulletArrays.add(x);
	}
	
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String x){
		this.title = x;
	}	

	public String toString() {
		String str = title;
		for(int i = 0;i<paragraphs.size();i++) {
			str += '\n'+paragraphs.get(i).toString();
		}
		for(int i = 0;i<bulletArrays.size();i++) {
			str += bulletArrays.get(i).toString();
		}
		return str;
	}
	
	public String toText() {
		String str = title;
		for(int i = 0;i<paragraphs.size();i++) {
			str += "\n"+paragraphs.get(i).toText();
		}
		for(int i = 0;i<bulletArrays.size();i++) {
			str += bulletArrays.get(i).toText();
		}
		return str;
	}
}
