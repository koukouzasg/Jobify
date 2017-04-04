import java.util.ArrayList;

public class ChronologicalCVTemplate {

	public ChronologicalCVTemplate() {
		GeneralInformation GenInfo = 
				new GeneralInformation("GENERAL INFORMATION", 1, "Name", "Address", "Home", "Mobile", "Email");
		ProfessionalProfil ProfProf = 
				new ProfessionalProfil("PROFESSIONAL PROFIL", 2, "...");
		CoreStrengths CoreStr = 
				new CoreStrengths("CORE STRENGTHS", 3, "...");
		ArrayList<String> list = new ArrayList<String>();
		list.add("Achievement X");
		list.add("Achievement Y");
		ProfessionalExperience ProfXp = 
				new ProfessionalExperience("PROFESSIONAL EXPERIENCE", 4, "Company Name", "Job Title", "Date", "Paragraph Of Responsibilities", "List of achievements", list);
		EducationAndTraining EdAndTrain = 
				new EducationAndTraining("EDUCATION AND TRAINING", 5, "Qualification", "Establishment", "Location", "Date");
		FurtherCourses FurCour = 
				new FurtherCourses("FURTHER COURSES", 6, "Course", "Establishment", "Location", "Date");
		AdditionalInformation AddInfo = 
				new AdditionalInformation("ADDITIONAL INFORMATION", 7, "...");
		Interests interests = 
				new Interests("INTERESTS", 8, "...");
	}
}
