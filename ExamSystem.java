import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamSystem {
    private Map<String, User> users;
    private Map<String, Exam> exams;
    private Scanner scanner;

    public ExamSystem() {
        users = new HashMap<>();
        exams = new HashMap<>();
        scanner = new Scanner(System.in);
        initializeData();
    }

    private void initializeData() {
        users.put("Abitha", new User("Abitha", "973497boo", "Photographer", "User One"));
        users.put("Riya", new User("Riya", "880724", "Graphic Designer", "User Two"));

        // Dummy questions for testing
        Question q1 = new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2);
        Question q2 = new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 1);
        exams.put("exam1", new Exam(Arrays.asList(q1, q2), 30000)); // 30 seconds for the exam
    }

    public void login() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        User user = users.get(userId);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful!");
            userMenu(user);
        } else {
            System.out.println("Invalid User ID or Password.");
        }
    }

    private void userMenu(User user) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nUser Menu:");
            System.out.println("1. View Profile");
            System.out.println("2. Update Profile");
            System.out.println("3. Update Password");
            System.out.println("4. Take Exam");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    viewProfile(user);
                    break;
                case 2:
                    updateProfile(user);
                    break;
                case 3:
                    updatePassword(user);
                    break;
                case 4:
                    takeExam(user);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void viewProfile(User user) {
        System.out.println("Profile Information:");
        System.out.println("Name: " + user.getName());
        System.out.println("User ID: " + user.getUserId());
        System.out.println("Profile: " + user.getProfile());
        System.out.println("Exams Attempted: " + user.getAttemptedExams().size());
        for (int i = 0; i < user.getAttemptedExams().size(); i++) {
            System.out.println("Exam: " + user.getAttemptedExams().get(i) + ", Score: " + user.getScores().get(i));
        }
    }

    private void updateProfile(User user) {
        System.out.print("Enter new profile information: ");
        String profile = scanner.nextLine();
        user.setProfile(profile);
        System.out.println("Profile updated successfully.");
    }

    private void updatePassword(User user) {
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        user.setPassword(password);
        System.out.println("Password updated successfully.");
    }

    private void takeExam(User user) {
        System.out.print("Enter exam ID: ");
        String examId = scanner.nextLine();

        Exam exam = exams.get(examId);
        if (exam != null) {
            System.out.println("Starting exam...");
            int score = exam.start();
            user.addExamResult(examId, score);
        } else {
            System.out.println("Invalid exam ID.");
        }
    }
}

