import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    //CREATE OBJECT OF MOOD ANALYZER CLASS
    MoodAnalyzer mood=new MoodAnalyzer();

    //TEST CASE TO CHECK SAD MOOD
    @Test
    public void givenMessage_whenValid_thenReturnMood() {
        MoodAnalyzer mood=new MoodAnalyzer("I am in sad mood");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e)
        {
            Assert.assertEquals("Sad", e.getMessage());
        }
    }

    //TEST CASE TO CHECK HAPPY MOOD
    @Test
    public void givenMessage_whenInvalid_thenReturnMood() {
        MoodAnalyzer mood=new MoodAnalyzer("I am in happy mood");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e)
        {
            Assert.assertEquals("Happy", e.getMessage());
        }
    }

    //TEST CASE TO HANDLE EXCEPTION IF USER PROVIDE NULL MOOD
    @Test
    public void givenNullMood_whenValid_thenThrowException() {
        MoodAnalyzer mood = new MoodAnalyzer(null);
        String result=null;
        try {
            result=mood.moodAnalyzer();
        } catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NULL,e.type);
        }
    }

    //TEST CASE TO HANDLE EXCEPTION IF USER PROVIDE EMPTY MOOD
    @Test
    public void givenEmptyMood_whenValid_thenThrowException() {
        MoodAnalyzer mood = new MoodAnalyzer("");
        String result=null;
        try {
            result=mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.EMPTY,e.type);
        }
    }
}
