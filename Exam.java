import java.util.List;
import java.util.Scanner;

public class Exam {
    private List<Question> questions;
    private long duration;

    public Exam(List<Question> questions, long duration) {
        this.questions = questions;
        this.duration = duration;
    }

    public int start() {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + duration;

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Your answer: ");
            int userOption = Integer.parseInt(scanner.nextLine());

            if (question.isCorrect(userOption - 1)) {
                score++;
            }

            if (System.currentTimeMillis() > endTime) {
                System.out.println("Time is up!");
                break;
            }
        }

        System.out.println("Your score: " + score + "/" + questions.size());
        return score;
    }
}

