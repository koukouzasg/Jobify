import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class CareerSummaryTest {

    private CareerSummary test = new CareerSummary("Career Summary", 4,"Jobify","Developer","6/4/2017");

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
    public void setCN() throws Exception {
        test.setCN("Google");
        assertEquals("Google",test.getCN());
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

}