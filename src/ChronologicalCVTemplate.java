import java.util.ArrayList;

public class ChronologicalCVTemplate {
	
	private GeneralInformation GenInfo = 
			new GeneralInformation("GENERAL INFORMATION", 1, "Name", "Address", "Home", "Mobile", "Email");
	private ProfessionalProfil ProfProf = 
			new ProfessionalProfil("PROFESSIONAL PROFIL", 2, "...");
	private CoreStrengths CoreStr = 
			new CoreStrengths("CORE STRENGTHS", 3, "...");
	private ArrayList<String> list = new ArrayList<String>();
	private ProfessionalExperience ProfXp = 
			new ProfessionalExperience("PROFESSIONAL EXPERIENCE", 4, "Company Name", "Job Title", "Date", "Paragraph Of Responsibilities", "List of achievements", list);
	private EducationAndTraining EdAndTrain = 
			new EducationAndTraining("EDUCATION AND TRAINING", 5, "Qualification", "Establishment", "Location", "Date");
	private FurtherCourses FurCour = 
			new FurtherCourses("FURTHER COURSES", 6, "Course", "Establishment", "Location", "Date");
	private AdditionalInformation AddInfo = 
			new AdditionalInformation("ADDITIONAL INFORMATION", 7, "...");
	private Interests interests = 
			new Interests("INTERESTS", 8, "...");
	public ChronologicalCVTemplate() {
		list.add("Achievement X");
		list.add("Achievement Y");
		ProfXp.setListOfAchievements(list);
	}
	public GeneralInformation getGenInfo() {
		return GenInfo;
	}
	public ProfessionalProfil getProfProf() {
		return ProfProf;
	}
	public CoreStrengths getCoreStr() {
		return CoreStr;
	}
	public ProfessionalExperience getProfXp() {
		return ProfXp;
	}
	public EducationAndTraining getEdAndTrain() {
		return EdAndTrain;
	}
	public FurtherCourses getFurCour() {
		return FurCour;
	}
	public AdditionalInformation getAddInfo() {
		return AddInfo;
	}
	public Interests getInterests() {
		return interests;
	}

}
