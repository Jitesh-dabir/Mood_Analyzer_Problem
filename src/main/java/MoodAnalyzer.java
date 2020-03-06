public class MoodAnalyzer {

    //DECLARE VARIABLE
    String mood;
    String message;

    //DEFAULT CONSTRUCTOR
    MoodAnalyzer()
    {
        message="";
    }
    //PARAMETERIZED CONSTRUCTOR
    MoodAnalyzer(String message)
    {
        this.message=message;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyzer Problem");
    }

    //METHOD THAT RETURN THE MOOD
    public String moodAnalyzer() {
        if (message.contains("sad"))
        {
            mood="Sad";
        }
        else if (message.contains("happy"))
        {
            mood="Happy";
        }
        return mood;
    }
}