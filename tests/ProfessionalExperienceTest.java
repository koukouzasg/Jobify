import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class ProfessionalExperienceTest {

    private ArrayList<String> array = new ArrayList<String>();
    private ProfessionalExperience test = new ProfessionalExperience("Professional Experience", 4,"Jobify","Developer","6/4/2017","Developing stuff","Stuff",array);

    @Test
    public void getCN() throws Exception {
        assertEquals("Jobify",test.getCN());
    }

    @Test
    public void getJobTitle() throws Exception {
        assertEquals("Developer",test.getJobTitle());
    }

    @Test
    public void getDate() throws Exception {
        assertEquals("6/4/2017",test.getDate());
    }

    @Test
    public void getResponsibilities() throws Exception {
        assertEquals("Developing stuff",test.getResponsibilities());
    }

    @Test
    public void getAchievements() throws Exception {
        assertEquals("Stuff",test.getAchievements());
    }

    @Test
    public void setCN() throws Exception {
        test.setCN("Google");
        assertEquals("Google",test.getCN());
    }

    @Test
    public void setAchievements() throws Exception {
        test.setAchievements("More Stuff");
        assertEquals("More Stuff",test.getAchievements());
    }

    @Test
    public void setJobTitle() throws Exception {
        test.setJobTitle("Software Engineer");
        assertEquals("Software Engineer",test.getJobTitle());
    }

    @Test
    public void setDate() throws Exception {
        test.setDate("7/4/2017");
        assertEquals("7/4/2017",test.getDate());
    }

    @Test
    public void setResponsibilities() throws Exception {
        test.setResponsibilities("Working");
        assertEquals("Working",test.getResponsibilities());
    }

}