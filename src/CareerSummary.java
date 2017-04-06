
public class CareerSummary extends Section{
	private String CompanyName = "Company Name";
	private String JobTitle = "Job Title";
	private String Date = "Date";
	
	public CareerSummary(String title,
			int number,
			String CompanyName,
			String JobTitle,
			String Date) {
		super(title, number);
		this.CompanyName = CompanyName;
		this.JobTitle = JobTitle;
		this.Date = Date;
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
	
	public void setCN(String x) {
		CompanyName = x;
	}
	
	public void setJobTitle(String x) {
		JobTitle = x;
	}
	
	public void setDate(String x) {
		Date = x;
	}
	
	public String toString() {
		return CompanyName + JobTitle + Date;
	}
}
