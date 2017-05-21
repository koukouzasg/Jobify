package windowsBuilder.common;

public class BulletListItem {
	private  int date;
	private  String contents;
	
	public  BulletListItem(int date, String contents) {
		this.date = date;
		this.contents = contents;
	}
	
	public int getDate() {
		return this.date;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setDate(int x) {
		date = x;
	}
	
	public void  setContents(String co) {
		contents = co;
	}
	
	public String toString() {
		return(contents+':'+date);
	}
	public String toText() {
		return("\t"+contents+':'+date);
	}
	
}
