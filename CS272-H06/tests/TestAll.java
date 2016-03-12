public class TestAll
{
    public static void main(String[] args)
    {
        System.setProperty("hwPackage", "occ.cs272.h06");
        System.setProperty("hwDescription", "CS 272 HW06");
        final double totalPoints = 15.0;
        String[] classes = {"Find", "EightColorViewer", 
                "SixteenMillionColorViewer"};
        checkresults.TestRunner.runTests(classes, totalPoints);
    }
}
