public class MoodAnalyzer {

    //DECLARE VARIABLE
    String mood;
    String message;

    //DEFAULT CONSTRUCTOR
    MoodAnalyzer() {
    }

    //PARAMETERIZED CONSTRUCTOR
    MoodAnalyzer(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyzer Problem");
    }

    //METHOD THAT RETURN THE MOOD
    public String moodAnalyzer() {
        try {
            if (message.contains("sad"))
                return "Sad";
            else
                return "Happy";
        } catch(NullPointerException e) {
            return "HappyNull";
        }
    }
}