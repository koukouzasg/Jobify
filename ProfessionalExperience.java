import java.util.ArrayList;

public class ProfessionalExperience extends Section{
	private String CompanyName = "Company Name";
	private String JobTitle = "Job Title";
	private String Date = "Date";
	private String responsibilities = "";
	private String achievements;
	private ArrayList<String> listOfAchievements = new ArrayList<String>();
	
	public ProfessionalExperience(String title,
			int number,
			String CompanyName,
			String JobTitle,
			String Date,
			String responsibilities,
			String achievements,
			ArrayList<String> listofachievements) {
		super(title, number);
		this.CompanyName = CompanyName;
		this.JobTitle = JobTitle;
		this.Date = Date;
		this.responsibilities = responsibilities;
		this.achievements = achievements;
		listOfAchievements = listofachievements;
	}
	
	
	public String getCN() {
		return CompanyName;
	}
	
	public String getJobTitle() {
		return JobTitle;
	}
	
	public String getDate() {
		return Date;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public String getAchievements() {
		return achievements;
	}
	
	public ArrayList<String> getListOfAchievements() {
		return listOfAchievements;
	}
	
	public void setCN(String x) {
		CompanyName = x;
	}
	
	public void setAchievements(String x) {
		achievements = x;
	}
	
	public void setJobTitle(String x) {
		JobTitle = x;
	}
	
	public void setDate(String x) {
		Date = x;
	}
	
	public void setResponsibilities(String x) {
		responsibilities = x;
	}

	public String toString() {
		return CompanyName + JobTitle + Date + responsibilities + achievements + listOfAchievements;
	}
}