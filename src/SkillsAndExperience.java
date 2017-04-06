import java.util.ArrayList;
public class SkillsAndExperience extends Section{

	private ArrayList<SkillsAndExperience> subSections = new ArrayList<SkillsAndExperience>(); 
	private String text;
	private String field;
	
	public SkillsAndExperience(String title,String field,int number,ArrayList<SkillsAndExperience> subSections,String text) {
		super(title, number);
		this.subSections = subSections;
		this.text = text;
		this.field = field;
	}
	
	public ArrayList<SkillsAndExperience> getSubSections() {
		return subSections;
	}
	
	public String getText() {
		return text;
	}
	
	public String getField() {
		return field;
	}
	
	public void setSubSections(ArrayList<SkillsAndExperience> x) {
		subSections = x;
	}
	
	public void setText(String x) {
		text = x;
	}
	
	public void setField(String x) {
		field = x;
	}

	public String toString() {
		return text + field + subSections;
	}
}
