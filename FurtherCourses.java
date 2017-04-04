
public class FurtherCourses extends Section{

	private String Course;
	private String Establishment;
	private String Location;
	private String Date;
	
	
	public FurtherCourses(String title,
			int number,
			String Course,
			String Establishment,
			String Location,
			String Date) {
		super(title, number);
		this.Course = Course;
		this.Establishment = Establishment;
		this.Location = Location;
		this.Date = Date;
	}
	
	public String getCourse() {
		return Course;
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
	
	public void setCourse(String x) {
		Course = x;
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
		return Course + Establishment + Location + Date;
	}
}
