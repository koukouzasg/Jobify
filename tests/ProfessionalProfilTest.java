import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class ProfessionalProfilTest {

    private ProfessionalProfil test = new ProfessionalProfil("Professional Profil",8,"HardWorker");

    @Test
    public void getText() throws Exception {
        assertEquals("HardWorker",test.getText());
    }

    @Test
    public void setText() throws Exception {
        test.setText("Worker");
        assertEquals("Worker",test.getText());
    }

}