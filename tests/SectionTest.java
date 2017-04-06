import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class SectionTest {

    private Section test = new Section("Title",0);

    @Test
    public void getTitle() throws Exception {
        assertEquals("Title",test.getTitle());
    }

    @Test
    public void setTitle() throws Exception {
        test.setTitle("Section");
        assertEquals("Section",test.getTitle());
    }

    @Test
    public void getNumber() throws Exception {
        assertEquals(0,test.getNumber());
    }

    @Test
    public void setNumber() throws Exception {
        test.setNumber(5);
        assertEquals(5,test.getNumber());
    }

}