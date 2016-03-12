package occ.cs272.h06;

/**
 * Write a graphical application with three check boxes 
 * labeled "Red", "Green", and "Blue" that adds a red, green, 
 * or blue component to the background color of a panel 
 * in the center of the frame. This application can 
 * display a total of eight color combinations.
 * 
 * Notice that the organization is a little unusual
 * to allow me to test your code.
 * 
 * You can make your controls instance variables or local
 * variables, but you must use setName() to give each control
 * a name for testing. 
 * 
 * Please use the following names for your controls:
 *  > RED: the red checkbox
 *  > GREEN: the green checkbox
 *  > BLUE: the blue checkbox
 *  > PANEL: the panel that changes color
 *
 *  After you've created the control, just do something like this:
 *  
 *      checkBox1.setName("RED");
 *  
 *  Please fill in the STUDENT and ASSIGNEMENT FIELDS.
 */
import java.awt.*;
import javax.swing.*;

public class SixteenMillionColorViewer extends JPanel
{
    // TODO: You must fill these in correctly to get credit
    public static final String STUDENT = "Put your login ID here";
    public static final String ASSIGNMENT = "H06-C";

    // Use this to format your label
    @SuppressWarnings("unused")
    private final String fmtString = 
            "<html><center>[R:%d, G:%d, B:%d]<br>#%X%X%X";

    // TODO: Add your instance variables here
    
    /**
     * You'll put your GUI starter code in the constructor
     */
    public SixteenMillionColorViewer()
    {
        // TODO: Set up the user interface here

        
        
        
        
        // /////////////////////////////////////////////////////////////////
        // ///////////////// DON'T CHANGE THIS /////////////////////////////
        /**
         * Frame created here instead of in main(). This is just for testing.
         */
        JFrame mainFrame = new JFrame(appName);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().add(this);
        mainFrame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        mainFrame.setVisible(true);
    }

    // TODO: You may add new (inner) classes and methods here
    
    // Other stuff you can customize
    private static String appName = "CS 272 H06-C - 16 Million Color Viewer";
    private static int DEFAULT_WIDTH = 400;
    private static int DEFAULT_HEIGHT = 300;

    /**
     * DON'T CHANGE THIS.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { /* do nothing */ }
        // Always start Swing programs on the event queue
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new SixteenMillionColorViewer();
            }
        });
    }
}
