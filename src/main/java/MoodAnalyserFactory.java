import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    //RETURN CLASS OBJECT
    public static Constructor<?> getConstructor(String className,Class argument) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(argument);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_CLASS_FOUND, "No such class found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD_FOUND, "No such method found");
        }
    }

    //DEFAULT CONSTRUCTOR
    public static MoodAnalyzer createMoodAnalyser() {
        try {
            Constructor<?> moodConstructor = Class.forName("MoodAnalyzer").getConstructor();
            //CONSTRUCTOR CLASS IS USED TO CREATE A NEW INSTANCE OF CLASS
            Object instance = moodConstructor.newInstance();
            return (MoodAnalyzer) instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //PARAMETERIZED CONSTRUCTOR
    public static MoodAnalyzer createMoodAnalyser(String mood) {
        try {
            Constructor<?> moodConstructor = Class.forName("MoodAnalyzer").getConstructor(String.class);
            //CONSTRUCTOR CLASS IS USED TO CREATE A NEW INSTANCE OF CLASS
            Object instance = moodConstructor.newInstance(mood);
            return (MoodAnalyzer) instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    }
