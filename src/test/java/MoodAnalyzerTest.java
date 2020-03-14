import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Handler;

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
        try {
            String   result = mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.EMPTY, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassNameDefaultConstructor_WhenProper_ShouldReturnObject()  {
        try {
            MoodAnalyzer mood = new MoodAnalyzer();
            MoodAnalyzer analyseMood = MoodAnalyserFactory.createMoodAnalyser();
            boolean resultMood = analyseMood.equals(mood);
            Assert.assertEquals(true, resultMood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClassName_WhenImproper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyserFactory.getConstructor("oodAnalyzer",String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_CLASS_FOUND, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenConstructorImproper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyzer",Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD_FOUND, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassNameParameterizedConstructor_WhenProper_ShouldReturnObject()  {
        try {
            MoodAnalyzer mood = new MoodAnalyzer("I am in happy mood");
            MoodAnalyzer analyseMood = MoodAnalyserFactory.createMoodAnalyser("I am in happy mood");
            boolean resultMood = analyseMood.equals(mood);
            Assert.assertEquals(true, resultMood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClassNameWithParameter_WhenImproper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyserFactory.getConstructor("oodAnalyzer",String.class,"I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_CLASS_FOUND, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassWithParameter_WhenConstructorImproper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyserFactory.getConstructor("MoodAnalyzer",Integer.class,"I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD_FOUND, e.type);
        }
    }

    @Test
    public void givenMessageUsingReflection_WhenProper_ShouldReturnMood() {

        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
            Object instance  = constructor.newInstance("I am in happy mood");
            String analyser = MoodAnalyserFactory.invokeMoodAnalyser((MoodAnalyzer)instance, "moodAnalyzer");
            Assert.assertEquals("Happy",analyser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessageUsingReflection_WhenMethodImproper_ShouldThrowMoodAnalysisException() {

        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
            Object instance = constructor.newInstance("I am in happy mood");
            String analyser = MoodAnalyserFactory.invokeMoodAnalyser((MoodAnalyzer)instance, "wrongMoodAnalyzer");
            Assert.assertEquals("Happy",analyser);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD_FOUND, e.type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setMessageUsingReflector_WhenProper_ShouldReturnMood() {
        try {
            MoodAnalyzer moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
            MoodAnalyserFactory.setFieldMoodAnalyser(moodAnalyser,"message","I am in happy mood");
            String moodResult = MoodAnalyserFactory.invokeMoodAnalyser( moodAnalyser, "moodAnalyzer");
            Assert.assertEquals("Happy",moodResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setMessageField_WhenImproper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyzer moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
            MoodAnalyserFactory.setFieldMoodAnalyser(moodAnalyser,"messge","I am in happy mood");
            String moodResult = MoodAnalyserFactory.invokeMoodAnalyser( moodAnalyser, "moodAnalyzer");
            Assert.assertEquals("Happy",moodResult);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_FIELD, e.type);
        }
    }

    @Test
    public void setNullMessageField_WhenImproper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyzer moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
            MoodAnalyserFactory.setFieldMoodAnalyser(moodAnalyser,"message",null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NULL_VALUE, e.type);
        }
    }
}

