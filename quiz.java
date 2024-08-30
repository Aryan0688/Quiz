import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class quiz {
    private List<question> questions;
    private int score;

    public quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(question question) {
        questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (question question : questions) {
            System.out.println(question.getQuestionText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ": " + options.get(i));
            }

            int userAnswer = getUserInput(scanner, options.size());
            if (question.isCorrect(userAnswer)) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect. The correct answer was option " + question.getCorrectOption() + ".\n");
            }
        }
        System.out.println("Quiz finished! Your score is: " + score + "/" + questions.size());
    }

    private int getUserInput(Scanner scanner, int numberOfOptions) {
        int userInput = -1;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter your answer (1-" + numberOfOptions + "): ");
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if (userInput >= 1 && userInput <= numberOfOptions) {
                    validInput = true;
                } else {
                    System.out.println("Invalid option. Please enter a number between 1 and " + numberOfOptions + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
        }
        return userInput;
    }
}
