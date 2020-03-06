public class MoodAnalyzer {

    //DECLARE VARIABLE
    String mood;
    public static void main(String[] args) {
        System.out.println("Welcome to Mood Analyzer Problem");
    }

    //METHOD THAT RETURN THE MOOD
    public String moodAnalyzer(String recentMood) {
        if (recentMood.equals("I am in sad mood"))
        {
            mood="Sad";
        }
        else if (recentMood.equals("I am in any mood"))
        {
            mood="Happy";
        }
        return mood;
    }
}