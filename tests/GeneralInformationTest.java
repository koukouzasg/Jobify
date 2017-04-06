import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralInformationTest {

    private GeneralInformation test = new GeneralInformation("General Info",3,"George","Narnia","123","321","kouk@");

    @Test
    public void getName() throws Exception {
        assertEquals("George",test.getName());
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals("Narnia",test.getAddress());
    }

    @Test
    public void getPhone() throws Exception {
        assertEquals("123",test.getPhone());
    }

    @Test
    public void getMobile() throws Exception {
        assertEquals("321",test.getMobile());
    }

    @Test
    public void getEmail() throws Exception {
        assertEquals("kouk@",test.getEmail());
    }

    @Test
    public void setName() throws Exception {
        test.setName("Koukou");
        assertEquals("Koukou",test.getName());
    }

    @Test
    public void setAddress() throws Exception {
        test.setAddress("Mordor");
        assertEquals("Mordor",test.getAddress());
    }

    @Test
    public void setPhone() throws Exception {
        test.setPhone("321");
        assertEquals("321",test.getPhone());
    }

    @Test
    public void setMobile() throws Exception {
        test.setMobile("123");
        assertEquals("123",test.getMobile());
    }

    @Test
    public void setEmail() throws Exception {
        test.setEmail("hello@cs.uoi.gr");
        assertEquals("hello@cs.uoi.gr",test.getEmail());
    }

}