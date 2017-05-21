package windowsBuilder.common;

import java.util.ArrayList;

import javax.swing.text.TabableView;

public class BulletList {
	private ArrayList<BulletListItem> bulletList;
	private String name = "";
	
	public BulletList(ArrayList<BulletListItem> x, String name) {
		bulletList = x;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<BulletListItem> getBulletList() {
		return bulletList;
	}
	
	public void addBulletListItem(BulletListItem x) {
		bulletList.add(x);
	}
	
	public ArrayList<BulletListItem> getArrayList() {
		return bulletList;
	}
	
	public void setName(String x) {
		this.name = x;
	}
	
	public void setArrayList(ArrayList<BulletListItem> x) {
		this.bulletList = x;
	}
	/*public String toString() {
		String str = this.name;
		String Tab = "     "; 
		for(int i = 0;i<this.bulletList.size();i++) {
			str += +'\n'+Tab+this.bulletList.get(i).toString();
		}
		return str;
	}*/
	public String toString() {
		String str = "<html>"+this.name;
		String Tab = "     "; 
		for(int i = 0;i<this.bulletList.size();i++) {
			str += ("<br>&emsp"+Tab+this.bulletList.get(i).toString());
		}
		return str+"</html>";
	}
	public String toText() {
		String str = "\n"+"\t"+this.name;
		for(int i = 0;i<bulletList.size();i++) {
			str += ("\n"+"\t"+"*"+bulletList.get(i).toText());
		}
		return str;
	}

}
