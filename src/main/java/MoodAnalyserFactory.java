
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    //RETURN CLASS OBJECT (FOR DEFAULT CONSTRUCTOR)
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

    //RETURN CLASS OBJECT (FOR PARAMETER CONSTRUCTOR)
    public static Object  getConstructor(String className, Class argument, String message) throws MoodAnalysisException {
        try {
            Constructor<?> moodAnalyserClass = Class.forName(className).getConstructor(argument);
            return moodAnalyserClass.newInstance(message);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_CLASS_FOUND, "No such class found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD_FOUND, "No such method found");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
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

    //INVOKE METHOD AND RETURN OUTPUT
    public static String invokeMoodAnalyser(MoodAnalyzer mood,String methodName) throws MoodAnalysisException {
        try {
            return (String) mood.getClass().getMethod(methodName).invoke(mood);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NO_SUCH_METHOD_FOUND, "No such method found");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //SET METHOD THAT SET MOOD
    public static String setFieldMoodAnalyser(MoodAnalyzer mood,String fieldName,String fieldValue) {
        try {
            Field field = mood.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(mood,fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}