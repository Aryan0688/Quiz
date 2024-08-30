import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        quiz quiz = new quiz();

        // Add questions to the quiz
        quiz.addQuestion(new question("What is the capital of France?", Arrays.asList("Berlin", "Madrid", "Paris", "Rome"), 3));
        quiz.addQuestion(new question("What is 2 + 2?", Arrays.asList("3", "4", "5", "6"), 2));
        quiz.addQuestion(new question("What is the largest planet in our solar system?", Arrays.asList("Earth", "Jupiter", "Mars", "Venus"), 2));

        // Start the quiz
        quiz.start();
    }
}
