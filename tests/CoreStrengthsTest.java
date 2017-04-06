import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class CoreStrengthsTest {

    private CoreStrengths test = new CoreStrengths("Core Strengths", 5, "Leadership");

    @Test
    public void getText() throws Exception {
        assertEquals("Leadership",test.getText());
    }

    @Test
    public void setText() throws Exception {
        test.setText("Team spirited");
        assertEquals("Team spirited",test.getText());
    }

}