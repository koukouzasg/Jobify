
public class Section {
	
	private String title;
	private int number;
	
	public Section(String title, int number){
		this.title = title;
		this.number = number;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String x){
		title = x;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int x){
		number = x;
	}

}
