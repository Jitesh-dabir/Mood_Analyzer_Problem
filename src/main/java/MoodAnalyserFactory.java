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

    public static MoodAnalyzer createMoodAnalyser() {
        try {
            //RETURN CLASS OBJECT
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
            //RETURN CONSTRUCTOR OBJECT
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor();
            //CONSTRUCTOR CLASS IS USED TO CREATE A NEW INSTANCE OF CLASS
            Object instance = moodConstructor.newInstance();
            return (MoodAnalyzer) instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    }
