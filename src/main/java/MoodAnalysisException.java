public class MoodAnalysisException extends Exception {
    // REPRESENT A FIXED SET OF CONSTANTS
    enum MyException_Type {
        EMPTY,NULL,NO_SUCH_CLASS_FOUND,NO_SUCH_METHOD_FOUND;
    }
    MyException_Type type;
    MoodAnalysisException(MyException_Type type,String message) {
        super(message);
        this.type=type;
        System.out.println(message);
    }
}