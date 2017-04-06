
public class Interests extends Section{
	private String text;
	
	
	public Interests(String title,int number,String text) {
		super(title, number);
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String x) {
		text = x;
	}
	
	public String toString() {
		return text;
	}
}