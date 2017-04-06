import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sora on 6/4/2017.
 */
public class FurtherCoursesTest {

    private FurtherCourses test = new FurtherCourses("Further Courses", 4,"VLSI","UOI","Ioannina","2017");

    @Test
    public void getCourse() throws Exception {
        assertEquals("VLSI",test.getCourse());
    }

    @Test
    public void getEstablishment() throws Exception {
        assertEquals("UOI",test.getEstablishment());
    }

    @Test
    public void getLocation() throws Exception {
        assertEquals("Ioannina",test.getLocation());
    }

    @Test
    public void getDate() throws Exception {
        assertEquals("2017",test.getDate());
    }

    @Test
    public void setCourse() throws Exception {
        test.setCourse("Software Engineering");
        assertEquals("Software Engineering",test.getCourse());
    }

    @Test
    public void setEstablishment() throws Exception {
        test.setEstablishment("Uoi");
        assertEquals("Uoi",test.getEstablishment());
    }

    @Test
    public void setLocation() throws Exception {
        test.setLocation("Giannena");
        assertEquals("Giannena",test.getLocation());
    }

    @Test
    public void setDate() throws Exception {
        test.setDate("5/4/2017");
        assertEquals("5/4/2017",test.getDate());
    }

}