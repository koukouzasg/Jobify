import java.util.ArrayList;

public class FunctionalCVTemplate {

	private GeneralInformation GenInfo = 
			new GeneralInformation("GENERAL INFORMATION", 1, "Name", "Address", "Home", "Mobile", "Email");
	private ProfessionalProfil ProfProf = 
			new ProfessionalProfil("PROFESSIONAL PROFIL", 2, "...");
	private ArrayList<SkillsAndExperience> array = new ArrayList<SkillsAndExperience>();
	private SkillsAndExperience SkillsAndXp = 
			new SkillsAndExperience("SKILLS AND EXPERIENCE", null, 3, array, null);
	private CareerSummary CarSum = 
			new CareerSummary("CAREER SUMMARY", 4, "Company Name", "Job Title", "Date");
	private EducationAndTraining EdAndTrain = 
			new EducationAndTraining("EDUCATION AND TRAINING", 5, "Qualification", "Establishment", "Location", "Date");
	private FurtherCourses FurCour = 
			new FurtherCourses("FURTHER COURSES", 6, "Course", "Establishment", "Location", "Date");
	private AdditionalInformation AddInfo = 
			new AdditionalInformation("ADDITIONAL INFORMATION", 7, "...");
	private Interests interests = 
			new Interests("INTERESTS", 8, "...");
	public FunctionalCVTemplate() {
		SkillsAndExperience SkillsAndXp1 = 
				new SkillsAndExperience("SKILLS AND EXPERIENCE ON", "X", 1, null, "...");
		SkillsAndExperience SkillsAndXp2 = 
				new SkillsAndExperience("SKILLS AND EXPERIENCE ON", "Y", 2, null, "...");
		SkillsAndExperience SkillsAndXp3 = 
				new SkillsAndExperience("SKILLS AND EXPERIENCE ON", "Z", 3, null, "...");
		array.add(SkillsAndXp1);
		array.add(SkillsAndXp2);
		array.add(SkillsAndXp3);
		SkillsAndXp.setSubSections(array);
	}
	public GeneralInformation getGenInfo() {
		return GenInfo;
	}

	public ProfessionalProfil getProfProf() {
		return ProfProf;
	}

	public SkillsAndExperience getSkillsAndXp() {
		return SkillsAndXp;
	}

	public CareerSummary getCarSum() {
		return CarSum;
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
