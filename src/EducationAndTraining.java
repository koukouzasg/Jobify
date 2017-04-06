
public class EducationAndTraining extends Section{

	private String Qualification;
	private String Establishment;
	private String Location;
	private String Date;
	public EducationAndTraining(String title,
			int number,
			String Qualification,
			String Establishment,
			String Location,
			String Date) {
		super(title, number);
		this.Qualification = Qualification;
		this.Establishment = Establishment;
		this.Location = Location;
		this.Date = Date;
	}
	public String getQualification() {
		return Qualification;
	}
	
	public String getEstablishment() {
		return Establishment;
	}
	
	public String getLocation() {
		return Location;
	}
	
	public String getDate() {
		return Date;
	}
	
	public void setQualification(String x) {
		Qualification = x;
	}
	
	public void setEstablishment(String x) {
		Establishment = x;
	}
	
	public void setLocation(String x) {
		Location = x;
	}
	
	public void setDate(String x) {
		Date = x;
	}

	public String toString() {
		return Qualification + Establishment + Location + Date;
	}
}
