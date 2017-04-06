import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;



public class SkillsAndExperienceTest {

    private ArrayList<SkillsAndExperience> subSections = new ArrayList<SkillsAndExperience>();
    private SkillsAndExperience test = new SkillsAndExperience("SkillsAndExperience", "Computers",2,subSections,"Text");

    @Test
    public void getText() throws Exception {
        assertEquals("Text",test.getText());
    }

    @Test
    public void getField() throws Exception {
        assertEquals("Computers",test.getField());
    }

    @Test
    public void setText() throws Exception {
        test.setText("Music lover");
        assertEquals("Music lover",test.getText());
    }

    @Test
    public void setField() throws Exception {
        test.setField("Software");
        assertEquals("Software",test.getField());
    }

}