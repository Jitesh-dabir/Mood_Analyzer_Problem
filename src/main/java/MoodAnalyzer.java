public class MoodAnalyzer {

    //DECLARE VARIABLE
    private String message;

    //DEFAULT CONSTRUCTOR
    MoodAnalyzer() {
    }

    //PARAMETERIZED CONSTRUCTOR
    MoodAnalyzer(String message) {
        this.message = message;
    }

    public static void main(String[] args) throws MoodAnalysisException {
        System.out.println("Welcome to Mood Analyzer Problem");
    }

    //METHOD THAT RETURN THE MOOD OR THROW EXCEPTION
    public String moodAnalyzer() throws MoodAnalysisException {
        try {
            if (message.contains("sad"))
                return "Sad";
            else
                return "Happy";
        } catch(NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NULL,"You entered null,Please enter valid mood");
        }
    }
}