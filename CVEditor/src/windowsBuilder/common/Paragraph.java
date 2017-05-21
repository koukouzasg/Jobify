package windowsBuilder.common;

public class Paragraph {
	private String contents;
		
	public Paragraph(String contents) {
		this.contents = contents;
	}
	
	public void  setContents(String co) {
		contents = co;
	}
	
	public String getContents(){
		return this.contents;
	}
	
	public String toString() {
		return contents;
	}
	
	public String toText() {
		return  "\t"+contents;
	}
}
