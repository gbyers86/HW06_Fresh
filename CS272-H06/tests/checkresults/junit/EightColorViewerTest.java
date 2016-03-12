package checkresults.junit;

import static checkresults.ReflectionSupport.*;

import javax.swing.*;

import java.awt.Color;
import checkresults.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EightColorViewerTest extends AbstractGUIProgramTest
{
    private final static String className = "occ.cs272.h06.EightColorViewer";

    /**
     * Creates a new Test object.
     */
    public EightColorViewerTest()
    {
        super(className);
    }

    private JPanel colorPanel;
    private JCheckBox redButton;
    private JCheckBox greenButton;
    private JCheckBox blueButton;

    @Before
    public void setUp() 
    { 
        obj = create(className);
        colorPanel = getComponent(JPanel.class, "PANEL");
        redButton = getComponent(JCheckBox.class, "RED");
        greenButton = getComponent(JCheckBox.class, "GREEN");
        blueButton = getComponent(JCheckBox.class, "BLUE");
    }
    
    @After
    public void cleanUp() { obj = null; }

    // Test to make sure that class runs
    @Test
    @ScoringWeight(2)
    public void makeSureTheProgramRuns()
    {
        assertNotNull(className + " not correctly created.", 
                thisClass);
        out("Correctly created EightColorViewer class");
    }

    @Test
    public void testRed()
    {
        click(redButton);
        assertEquals("Red button checked",
                colorPanel.getBackground().toString(),
                Color.RED.toString());
        out("Correctly sets red.");
    }

    @Test
    public void testGreen()
    {
        click(greenButton);
        assertEquals("Green button checked",
                colorPanel.getBackground().toString(),
                Color.GREEN.toString());
        out("Correctly sets green.");
    }

    @Test
    public void testBlue()
    {
        click(blueButton);
        assertEquals("Blue button checked",
                colorPanel.getBackground().toString(),
                Color.BLUE.toString());
        out("Correctly sets blue.");
    }
    
    @Test
    public void testYellow()
    {
        click(redButton);
        click(greenButton);
        assertEquals("Red and green buttons checked",
                colorPanel.getBackground().toString(),
                Color.YELLOW.toString());
        out("Correctly sets yellow.");
    }
    
    @Test
    public void testMagenta()
    {
        click(redButton);
        click(blueButton);
        assertEquals("Red and blue buttons checked",
                colorPanel.getBackground().toString(),
                Color.MAGENTA.toString());
        out("Correctly sets magenta.");
    }
    
    @Test
    public void testCyan()
    {
        click(greenButton);
        click(blueButton);
        assertEquals("Green and blue buttons checked",
                colorPanel.getBackground().toString(),
                Color.CYAN.toString());
        out("Correctly sets cyan.");
    }

    @Test
    public void testWhite()
    {
        click(redButton);
        click(greenButton);
        click(blueButton);
        assertEquals("Red, green and blue buttons checked",
                colorPanel.getBackground().toString(),
                Color.WHITE.toString());
        out("Correctly sets white.");
    }

    @Test
    public void testBlack()
    {
        click(redButton);
        click(redButton);
        assertEquals("Red button checked and then unchecked.",
                colorPanel.getBackground().toString(),
                Color.BLACK.toString());
        out("Correctly sets black.");
    }
}
