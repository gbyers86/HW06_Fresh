package checkresults.junit;

import static checkresults.ReflectionSupport.*;

import javax.swing.*;

import java.awt.Color;
import java.util.Random;

import checkresults.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SixteenMillionColorViewerTest extends AbstractGUIProgramTest
{
    private final static String className 
        = "occ.cs272.h06.SixteenMillionColorViewer";

    private final static String fmt
        = "<html><center>[R:%d, G:%d, B:%d]<br>#%X%X%X";
    
    private static final Random gen = new Random();
    
    /**
     * Creates a new Test object.
     */
    public SixteenMillionColorViewerTest()
    {
        super(className);
    }

    private JLabel colorLabel;
    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;

    @Before
    public void setUp() 
    { 
        obj = create(className);
        colorLabel = getComponent(JLabel.class, "OUTPUT");
        redSlider = getComponent(JSlider.class, "RED");
        greenSlider = getComponent(JSlider.class, "GREEN");
        blueSlider = getComponent(JSlider.class, "BLUE");
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
        out("Correctly created SixteenMillionColorViewer class");
    }

    @Test
    @ScoringWeight(2)
    public void testRed()
    {
        redSlider.setValue(255);
        blueSlider.setValue(0);
        greenSlider.setValue(0);
        assertEquals("Output should be Red",
                Color.RED.toString(),
                colorLabel.getBackground().toString());
        out("Correctly sets red background for output.");
    }

    @Test
    @ScoringWeight(2)
    public void testRedSlider()
    {
        int value = gen.nextInt(255);
        Color color = new Color(value, 0, 0);
        redSlider.setValue(value);
        blueSlider.setValue(0);
        greenSlider.setValue(0);
        assertEquals("Slider red-background should be " + value,
                color.toString(),
                redSlider.getBackground().toString());
        out("Correctly sets red background for slider.");
    }
    
    @Test
    @ScoringWeight(2)
    public void testGreen()
    {
        redSlider.setValue(0);
        greenSlider.setValue(255);
        blueSlider.setValue(0);
        assertEquals("Output should be Green",
                Color.GREEN.toString(),
                colorLabel.getBackground().toString());
        out("Correctly sets green background for output.");
    }

    @Test
    @ScoringWeight(2)
    public void testGreenSlider()
    {
        int value = gen.nextInt(255);
        Color color = new Color(0, value, 0);
        redSlider.setValue(0);
        greenSlider.setValue(value);
        blueSlider.setValue(0);
        assertEquals("Slider green-background should be " + value,
                color.toString(),
                greenSlider.getBackground().toString());
        out("Correctly sets green background for slider.");
    }
    
    @Test
    @ScoringWeight(2)
    public void testBlue()
    {
        redSlider.setValue(0);
        greenSlider.setValue(0);
        blueSlider.setValue(255);
        assertEquals("Output should be Blue",
                Color.BLUE.toString(),
                colorLabel.getBackground().toString());
        out("Correctly sets blue background for output.");
    }

    @Test
    @ScoringWeight(2)
    public void testBlueSlider()
    {
        int value = gen.nextInt(255);
        Color color = new Color(0, 0, value);
        redSlider.setValue(0);
        greenSlider.setValue(0);
        blueSlider.setValue(value);
        assertEquals("Slider blue-background should be " + value,
                color.toString(),
                blueSlider.getBackground().toString());
        out("Correctly sets blue background for slider.");
    }
    
    @Test
    @ScoringWeight(2)
    public void testRedLabel()
    {
        redSlider.setValue(255);
        blueSlider.setValue(0);
        greenSlider.setValue(0);
        assertEquals("Output should be Red",
                String.format(fmt, 255, 0, 0, 255, 0, 0),
                colorLabel.getText());
        out("Correctly formats label values for red.");
    }

    @Test
    @ScoringWeight(2)
    public void testGreenLabel()
    {
        redSlider.setValue(0);
        greenSlider.setValue(255);
        blueSlider.setValue(0);
        assertEquals("Output should be Green",
                String.format(fmt, 0, 255, 0, 0, 255, 0),
                colorLabel.getText());
        out("Correctly formats label values for green.");
    }

    @Test
    @ScoringWeight(2)
    public void testBlueLabel()
    {
        redSlider.setValue(0);
        greenSlider.setValue(0);
        blueSlider.setValue(255);
        assertEquals("Output should be Blue",
                String.format(fmt, 0, 0, 255, 0, 0, 255),
                colorLabel.getText());
        out("Correctly formats label values for blue.");
    }

    @Test
    @ScoringWeight(2)
    public void testWhiteLabel()
    {
        redSlider.setValue(255);
        greenSlider.setValue(255);
        blueSlider.setValue(255);
        assertEquals("Output should be White",
                String.format(fmt, 255, 255, 255, 255, 255, 255),
                colorLabel.getText());
        out("Correctly formats label values for white.");
    }

    @Test
    @ScoringWeight(2)
    public void testBlackLabel()
    {
        redSlider.setValue(0);
        greenSlider.setValue(0);
        blueSlider.setValue(0);
        assertEquals("Output should be Black",
                String.format(fmt, 0, 0, 0, 0, 0, 0),
                colorLabel.getText());
        out("Correctly formats label values for black.");
    }
    
    @Test
    @ScoringWeight(2)
    public void testWhite()
    {
        redSlider.setValue(255);
        greenSlider.setValue(255);
        blueSlider.setValue(255);
        assertEquals("Output should be White",
                Color.WHITE.toString(),
                colorLabel.getBackground().toString());
        out("Correctly sets white background for output.");
    }

    @Test
    @ScoringWeight(2)
    public void testBlack()
    {
        redSlider.setValue(0);
        greenSlider.setValue(0);
        blueSlider.setValue(0);
        assertEquals("Output should be Black",
                Color.BLACK.toString(),
                colorLabel.getBackground().toString());
        out("Correctly sets black background for output.");
    }
    
}
