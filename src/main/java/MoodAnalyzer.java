import java.util.Objects;

public class MoodAnalyzer {

    //DECLARE VARIABLE
    private String message;

    //DEFAULT CONSTRUCTOR
    public MoodAnalyzer() {
    }

    //PARAMETERIZED CONSTRUCTOR
    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String moodAnalyzer(String message) throws MoodAnalysisException {
        this.message = message;
        return moodAnalyzer();
    }

    public static void main(String[] args) throws MoodAnalysisException {
        System.out.println("Welcome to Mood Analyzer Problem");

    }

    //METHOD THAT RETURN THE MOOD OR THROW EXCEPTION
    public String moodAnalyzer() throws MoodAnalysisException {
        try {
            if (message.isEmpty()) {
                throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.EMPTY, "You entered empty,please enter valid mood");
            }
            if (message.contains("sad"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NULL, "You entered null,please enter valid mood");
        }
    }

    //CHECK IF BOTH OBJECTS ARE EQUAL
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }

}