import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {

    //CREATE OBJECT OF MOOD ANALYZER CLASS
    MoodAnalyzer mood = new MoodAnalyzer();

    @Test
    public void givenMessage_whenValid_thenReturnMood() {
        MoodAnalyzer mood = new MoodAnalyzer("I am in sad mood");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Sad", e.getMessage());
        }
    }

    @Test
    public void givenMessage_whenInvalid_thenReturnMood() {
        MoodAnalyzer mood = new MoodAnalyzer("I am in happy mood");
        try {
            String reaction = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Happy", e.getMessage());
        }
    }

    @Test
    public void givenNullMood_whenValid_thenThrowException() {
        MoodAnalyzer mood = new MoodAnalyzer(null);
        String result = null;
        try {
            result = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NULL, e.type);
        }
    }

    @Test
    public void givenEmptyMood_whenValid_thenThrowException() {
        MoodAnalyzer mood = new MoodAnalyzer("");
        String result = null;
        try {
            result = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.EMPTY, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassNameDefaultConstructor_Proper_ShouldReturnObject()  {
       try {
           MoodAnalyzer mood = new MoodAnalyzer();
           MoodAnalyzer analyseMood = MoodAnalyserFactory.createMoodAnalyser();
           boolean resultMood = analyseMood.equals(mood);
           Assert.assertEquals(true, resultMood);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
