import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    //CREATE OBJECT OF MOODANALYZER CLASS
    MoodAnalyzer mood=new MoodAnalyzer();

    //TEST CASE TO CHECK SAD MOOD
    @Test
    public void givenMeassage_whenValid_thenReturnMood() {
        String recentMood="I am in sad mood";
        String reaction=mood.moodAnalyzer(recentMood);
        Assert.assertEquals("Sad",reaction);
    }

    //TEST CASE TO CHECK HAPPYgit  MOOD
    @Test
    public void givenMeassage_whenInvalid_thenReturnMood() {
        String recentMood="I am in any mood";
        String reaction=mood.moodAnalyzer(recentMood);
        Assert.assertEquals("Happy",reaction);
    }
}
