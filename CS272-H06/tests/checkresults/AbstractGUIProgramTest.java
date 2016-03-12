package checkresults;
import org.junit.Test;
import student.GUITestCase;

import java.lang.reflect.*;

import java.util.*;

/**
 *  Abstract test base for GUI programs
 *
 *  @author  Stephen Gilbert
 *  @version Spring 2016
 */
public class AbstractGUIProgramTest extends GUITestCase
{
    protected final String className;
    protected Class<?> thisClass;
    protected Field[] fields;
    protected ArrayList<String> fieldNames = new ArrayList<String>();
    protected Constructor<?>[] constructors;
    protected Method[] methods;
    protected ArrayList<String> methodNames = new ArrayList<String>();
    protected Object obj;
    
    /**
     * Creates a new object.
     */
    public AbstractGUIProgramTest(String className)
    {
        this.className = className;
        try {
            thisClass = Class.forName(className);

            fields = thisClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fieldNames.add(fields[i].getName());
            }

            constructors = thisClass.getDeclaredConstructors();
            methods = thisClass.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                methodNames.add(methods[i].getName());
            }
        }
        catch (ClassNotFoundException e) {
            /* Nothing to catch */
        }
    }

    // Test Programs
    /**
     * 1. Test to make sure that the class exists.
     */
    @Test
    @ScoringWeight(0.5)
    public void testClassExists()
    {
        assertTrue("Program " + className + " NOT defined.", thisClass != null);
        out("Create the " + className + " program.");    
    }

    /**
     * Class must be public.
     */
    @Test
    @ScoringWeight(0.5)
    public void testClassIsPublic()
    {
        assertTrue("Class " + className + " NOT defined.", thisClass != null);
        assertTrue("The class is NOT public.",
            Modifier.isPublic(thisClass.getModifiers()));
        out(className + " is public.");    
    }

    
     //~ Methods ...............................................................

   
    /**
     *  Private methods for testing fields.
     *  Returns field given a name.
     */
    protected Field getField(String fname) {
        int pos = fieldNames.indexOf(fname);
        return (pos < 0) ? null : fields[pos];
    }

    /**
     * Checks if the field is the correct type.
     */
    protected void assertFieldIsType(String fname, String desiredType) {
        assertFieldExists(fname);
        Field f = getField(fname);
        assertTrue("Field " + fname + "not correct type (" + desiredType + ")", 
            f.getType().getSimpleName().equals(desiredType));
    }

    /**
     * Asserts that the field is exists.
     */
    protected void assertFieldExists(String fname) {
        assertTrue("Field " + fname + " does not exist.", 
            fieldNames.contains(fname));
    }

    /**
     * Asserts that the field is private.
     */
    protected void assertFieldIsPrivate(String fname) {
        assertFieldExists(fname);
        Field f = getField(fname);
        assertTrue("Field " + fname + " is not private.", 
            Modifier.isPrivate(f.getModifiers()));
    }

    /**
     * Asserts that the field is public.
     */
    protected void assertFieldIsPublic(String fname) {
        assertFieldExists(fname);
        Field f = getField(fname);
        assertTrue("Field " + fname + " is not public.", 
            Modifier.isPublic(f.getModifiers()));
    }

    /**
     * Asserts that the field is static.
     */
    protected void assertFieldIsStatic(String fname) {
        assertFieldExists(fname);
        Field f = getField(fname);
        assertTrue("Field " + fname + " is not static.", 
            Modifier.isStatic(f.getModifiers()));
    }

    /**
     * Asserts that the field is final.
     */
    protected void assertFieldIsFinal(String fname) {
        assertFieldExists(fname);
        Field f = getField(fname);
        assertTrue("Field " + fname + " is not final.", 
            Modifier.isFinal(f.getModifiers()));
    }

    /**
     *  Private methods for testing methods.
     *  Returns field given a name.
     */
    protected Method getMethod(String name) {
        int pos = methodNames.indexOf(name);
        return (pos < 0) ? null : methods[pos];
    }

    /**
     * Checks if the method has the correct return type.
     */
    protected void assertMethodReturnTypeIs(String mname, String desiredType) {
        assertMethodExists(mname);
        Method m = getMethod(mname);
        assertTrue("Not correct return type.", 
            m.getReturnType().getSimpleName().equals(desiredType));
    }

    /**
     * Asserts that the method exists.
     */
    protected void assertMethodExists(String name) {
        assertTrue("Method " + name + " does not exist.", 
            methodNames.contains(name));
    }

    /**
     * Asserts that the method is private.
     */
    protected void assertMethodIsPrivate(String mname) {
        assertMethodExists(mname);
        Method m = getMethod(mname);
        assertTrue("Method " + mname + " is not private.", 
            Modifier.isPrivate(m.getModifiers()));
    }

    /**
     * Asserts that the method is public.
     */
    protected void assertMethodIsPublic(String mname) {
        assertMethodExists(mname);
        Method m = getMethod(mname);
        assertTrue("Method " + mname + " is not public.", 
            Modifier.isPublic(m.getModifiers()));
    }

    /**
     * Asserts that the method is static.
     */
    protected void assertMethodIsStatic(String mname) {
        assertMethodExists(mname);
        Method m = getMethod(mname);
        assertTrue("Method " + mname + " is not static.",
            Modifier.isStatic(m.getModifiers()));
    }

    /**
     * Asserts that the method is final.
     */
    protected void assertMethodIsFinal(String mname) {
        assertMethodExists(mname);
        Method m = getMethod(mname);
        assertTrue("Method " + mname + " is not final.", 
            Modifier.isFinal(m.getModifiers()));
    }

    /**
     * Check type of each method parameter.
     */
    protected void assertParameters(String mname, Class<?>...specifiedParams)
    {
        assertMethodExists(mname);
        Method m = getMethod(mname);
        Class<?>[] declaredParams = m.getParameterTypes();
        if (specifiedParams.length != declaredParams.length)
            fail("Wrong number of parameters passed to " + mname);
        else
        {
            for (int i = 0; i < specifiedParams.length; i++)
                assertEquals("Parameter " + i + " should be type " 
                    + specifiedParams[i].getSimpleName()
                    + " but it is actually "
                    + declaredParams[i].getSimpleName(),
                    declaredParams[i].getSimpleName(),
                    specifiedParams[i].getSimpleName());
        }
    }
    
    /**
     * Report on a successful test.
     */
    protected void out(String s)
    {
        System.out.print(" + " + s);
    }

}
