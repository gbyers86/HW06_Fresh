package checkresults.junit;

import static checkresults.ReflectionSupport.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

import checkresults.AbstractBasicTest;

public class FindTest extends AbstractBasicTest
{
    @BeforeClass
    public static void initializeTests() throws Exception
    {
        className = "occ.cs272.h06.Find";
        init();
    }

    @Override
    /**
     * Run a test.
     */
    protected void runWithArgs(String...args)
    {
        // CANNOT RUN UNLESS CLASS AND MAIN METHOD ARE CORRECT.
        if(thisClass == null) fail("Class NOT public. Can't test.");
        
        PrintStream oldOut = System.out;
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        final Object[] params = new Object[] {args};
        try {
            try {
                obj = create(thisClass);                // Create an instance
                if (args[0].length() > 0)
                    invoke(obj, "main", params);                     // Run the program
                else
                    invoke(obj, "main", new Object[]{new String[0]});
                Thread.sleep(100);
            }
            finally {
                System.setOut(oldOut);
                m_results = out.toString().split("\n|\r\n");
            }
        }
        catch (Exception e)
        {
            fail("FAIL: cannot run your program. (Check input)");
        }
   }
    
    // ------------- BEHAVIOR ---------------------------------------

    @Test
    public void t1()
    {
        runWithArgs("");
        assertEquals("Usage: Find keyword sourcefile1 sourcefile2 . . .", m_results[0]);
        out("Correctly catches lack of arguments.");
    }
    
    private int indexOf(String[] a, String value) {
        int pos = -1;
        for (int i = 0; i < a.length; i++)
            if (a[i].indexOf(value) >= 0)
                return i;
        return pos;
    }
    
    @Test
    public void t2()
    {
        runWithArgs("lamb", "mary1.txt", "mary2.txt");
        String expected = "mary1.txt:     Mary had a little lamb,";
        int pos = indexOf(m_results, expected);
        assertTrue("Looking for lamb:", pos >= 0);
        out("Looking for lamb: Line " + (pos + 1) + "->\"" + m_results[pos] + "\"");
    }

    @Test
    public void t3()
    {
        runWithArgs("lamb", "mary1.txt", "mary2.txt");
        String expected = "mary1.txt:     little lamb, little lamb,"; 
        int pos = indexOf(m_results, expected);
        assertTrue("Looking for lamb:", pos >= 0);
        out("Looking for lamb: Line " + (pos + 1) + "->\"" + m_results[pos] + "\"");
    }
    
    @Test
    public void t4()
    {
        runWithArgs("lamb", "mary1.txt", "mary2.txt");
        String expected = "mary1.txt:     Mary had a little lamb, its fleece was white as snow."; 
        int pos = indexOf(m_results, expected);
        assertTrue("Looking for lamb:", pos >= 0);
        out("Looking for lamb: Line " + (pos + 1) + "->\"" + m_results[pos] + "\"");
    }

    @Test
    public void t5()
    {
        runWithArgs("lamb", "mary1.txt", "mary2.txt");
        String expected = "mary1.txt:     and everywhere that Mary went, the lamb was sure to go."; 
        int pos = indexOf(m_results, expected);
        assertTrue("Looking for lamb:", pos >= 0);
        out("Looking for lamb: Line " + (pos + 1) + "->\"" + m_results[pos] + "\"");
    }
    
    @Test
    public void t6()
    {
        runWithArgs("lamb", "mary1.txt", "mary2.txt");
        String expected = "mary2.txt:     it made the children laugh and play to see a lamb at school."; 
        int pos = indexOf(m_results, expected);
        assertTrue("Looking for lamb:", pos >= 0);
        out("Looking for lamb: Line " + (pos + 1) + "->\"" + m_results[pos] + "\"");
    }
    
    @Test
    public void t7()
    {
        runWithArgs("children", "mary1.txt", "mary2.txt");
        String expected = "mary2.txt:     It made the children laugh and play,"; 
        int pos = indexOf(m_results, expected);
        assertTrue("Looking for children:", pos >= 0);
        out("Looking for children: Line " + (pos + 1) + "->\"" + m_results[pos] + "\"");
    }
    
    @Test
    public void t8()
    {
        runWithArgs("children", "mary1.txt", "mary2.txt");
        String expected = "mary2.txt:     it made the children laugh and play to see a lamb at school."; 
        int pos = indexOf(m_results, expected);
        assertTrue("Looking for children:", pos >= 0);
        out("Looking for children: Line " + (pos + 1) + "->\"" + m_results[pos] + "\"");
    }
    
    @Test
    public void t9()
    {
        runWithArgs("xylophone", "mary1.txt", "mary2.txt");
        out("Looking for xylophone: no ouput->" + m_results[0]);
    }
    
    @Test
    public void t10()
    {
        runWithArgs("fleece", "mary1.txt", "marty2.txt");
        String expected = "mary1.txt:     Mary had a little lamb, its fleece was white as snow."; 
        int pos = indexOf(m_results, expected);
        assertTrue("Looking for fleece:", pos >= 0);
        out("Looking for fleece in mary1.txt and marty1.txt: Line " 
                + (pos + 1) + "->\"" + m_results[pos] + "\"");
    }
    
    @Test
    public void t11()
    {
        runWithArgs("fleece", "mary1.txt", "marty2.txt");
        String expected = "File marty2.txt could not be found."; 
        int pos = indexOf(m_results, expected);
        assertTrue("Looking for fleece:", pos >= 0);
        out("Looking for fleece in mary1.txt and marty1.txt: Line " 
                + (pos + 1) + "->\"" + m_results[pos] + "\"");
    }

 }
