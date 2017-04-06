import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class AdditionalInformationTest {
    @Test
    public void getText() throws Exception {
        AdditionalInformation par = new AdditionalInformation("Additional Information",7,"Music enthusiast");
        assertEquals("Music enthusiast",par.getText());
    }

    @Test
    public void setText() throws Exception {
        AdditionalInformation par = new AdditionalInformation("Additional Information",7,"Music enthusiast");
        par.setText("Music lover");
        assertEquals("Music lover",par.getText());
    }

}