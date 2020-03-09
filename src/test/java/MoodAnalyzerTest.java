import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    //CREATE OBJECT OF MOODANALYZER CLASS
    MoodAnalyzer mood=new MoodAnalyzer();

    //TEST CASE TO CHECK SAD MOOD
    @Test
    public void givenMessage_whenValid_thenReturnMood() {
        MoodAnalyzer mood=new MoodAnalyzer("I am in sad mood");
        String reaction=mood.moodAnalyzer();
        Assert.assertEquals("Sad",reaction);
    }

    //TEST CASE TO CHECK HAPPY MOOD
    @Test
    public void givenMessage_whenInvalid_thenReturnMood() {
        MoodAnalyzer mood=new MoodAnalyzer("I am in happy mood");
        String reaction=mood.moodAnalyzer();
        Assert.assertEquals("Happy",reaction);
    }

    //TEST CASE TO HANDLE EXCEPTION IF USER PROVIDE NULL MOOD
    @Test
    public void givenNullMood_whenValid_thenThrowException() {
        MoodAnalyzer mood = new MoodAnalyzer(null);
            String reaction = mood.moodAnalyzer();
            Assert.assertEquals("HappyNull",reaction);
    }

}
