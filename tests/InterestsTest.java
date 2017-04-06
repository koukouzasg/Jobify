import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class InterestsTest {

    private Interests test = new Interests("Interests",1,"Guitar");

    @Test
    public void getText() throws Exception {
        assertEquals("Guitar",test.getText());
    }

    @Test
    public void setText() throws Exception {
        test.setText("Music lover");
        assertEquals("Music lover",test.getText());
    }

}