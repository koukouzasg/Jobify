import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sora on 6/4/2017.
 */
public class EducationAndTrainingTest {

    private EducationAndTraining test = new EducationAndTraining("Education And Training", 6,"CS","Uoi","Ioannina","4/6/2017");

    @Test
    public void getQualification() throws Exception {
        assertEquals("CS",test.getQualification());
    }

    @Test
    public void getEstablishment() throws Exception {
        assertEquals("Uoi",test.getEstablishment());
    }

    @Test
    public void getLocation() throws Exception {
        assertEquals("Ioannina",test.getLocation());
    }

    @Test
    public void getDate() throws Exception {
        assertEquals("4/6/2017",test.getDate());
    }

    @Test
    public void setQualification() throws Exception {
        test.setQualification("Math");
        assertEquals("Math",test.getQualification());
    }

    @Test
    public void setEstablishment() throws Exception {
        test.setEstablishment("UOI");
        assertEquals("UOI",test.getEstablishment());
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