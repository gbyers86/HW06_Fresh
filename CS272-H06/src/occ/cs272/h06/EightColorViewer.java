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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class EightColorViewer extends JPanel
{
    // TODO: You must fill these in correctly to get credit
    public static final String STUDENT = "gbyers";
    public static final String ASSIGNMENT = "H06-B";

    // TODO: Place your instance variables here
private JCheckBox r;
private JCheckBox g;
private JCheckBox b;
private JPanel panelA;
    
    /**
     * You'll put your GUI starter code in the constructor
     */
    public EightColorViewer()
    {
   	this.setLayout(new BorderLayout());	
    	
    	 panelA = new JPanel();
    	JPanel panelB = new JPanel();
    
    	r = new JCheckBox("Red");
    	r.setName("RED");
    	g = new JCheckBox("Green");
    	g.setName("GREEN");
    	b = new JCheckBox("Blue");
    	b.setName("BLUE");
    
    	BoxItemListener bh = new BoxItemListener();
    	r.addItemListener(bh);
    	g.addItemListener(bh);
    	b.addItemListener(bh);
    	
    	panelB.add(r);
    	panelB.add(g);
    	panelB.add(b);
     	this.add(panelB, BorderLayout.SOUTH);
    
     	panelA.setName("PANEL");
    //	panelA.setBackground(Color.RED);
    	this.add(panelA);
    	
    
     	// TODO: PLACE YOUR CODE HERE
        
        

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
    
    private class BoxItemListener implements ItemListener
    {
  
		public void itemStateChanged(ItemEvent e) {

    	if (r.isSelected() && (g.isSelected() && b.isSelected()))
    		panelA.setBackground(Color.WHITE);
    	else if (!b.isSelected() && (r.isSelected() && g.isSelected()))
    		panelA.setBackground(Color.YELLOW);
    	else if (r.isSelected() &&(!g.isSelected() && b.isSelected()))
    		panelA.setBackground(Color.MAGENTA);
    		else if (r.isSelected() && (!g.isSelected() && !b.isSelected()))
    			panelA.setBackground(Color.RED);
    	else if (!r.isSelected() && (g.isSelected() && b.isSelected()))
    		panelA.setBackground(Color.CYAN);
    	else if (!r.isSelected() && (!g.isSelected() && b.isSelected()))
    			panelA.setBackground(Color.BLUE);
    	else if (!r.isSelected() && (g.isSelected() && !b.isSelected()))
    		panelA.setBackground(Color.GREEN);
    	else if (!r.isSelected() && (!g.isSelected() && !b.isSelected()))
    	panelA.setBackground(Color.BLACK);

		}

    	
    }

    //////// YOU MAY ADD OTHER METHODS HERE /////////////////////////
    

    // Other stuff you can customize
    private static String appName = "CS 272 H06-B - Eight Color Viewer";
    private static int DEFAULT_WIDTH = 400;
    private static int DEFAULT_HEIGHT = 250;

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
                new EightColorViewer();
            }
        });
    }
}
