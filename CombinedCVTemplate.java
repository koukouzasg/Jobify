import java.util.ArrayList;

public class CombinedCVTemplate {

	public CombinedCVTemplate() {
		GeneralInformation GenInfo = 
				new GeneralInformation("GENERAL INFORMATION", 1, "Name", "Address", "Home", "Mobile", "Email");
		ProfessionalProfil ProfProf = 
				new ProfessionalProfil("PROFESSIONAL PROFIL", 2, "...");
		SkillsAndExperience SkillsAndXp1 = 
				new SkillsAndExperience("SKILLS AND EXPERIENCE ON", "X", 1, null, "...");
		SkillsAndExperience SkillsAndXp2 = 
				new SkillsAndExperience("SKILLS AND EXPERIENCE ON", "Y", 2, null, "...");
		SkillsAndExperience SkillsAndXp3 = 
				new SkillsAndExperience("SKILLS AND EXPERIENCE ON", "Z", 3, null, "...");
		ArrayList<SkillsAndExperience> array = new ArrayList<SkillsAndExperience>();
		array.add(SkillsAndXp1);
		array.add(SkillsAndXp2);
		array.add(SkillsAndXp3);
		SkillsAndExperience SkillsAndXp = 
				new SkillsAndExperience("SKILLS AND EXPERIENCE", null, 3, array, null);
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
