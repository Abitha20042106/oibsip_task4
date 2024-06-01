import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String password;
    private String profile;
    private String name;
    private List<String> attemptedExams;
    private List<Integer> scores;

    public User(String userId, String password, String profile, String name) {
        this.userId = userId;
        this.password = password;
        this.profile = profile;
        this.name = name;
        this.attemptedExams = new ArrayList<>();
        this.scores = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }

    public List<String> getAttemptedExams() {
        return attemptedExams;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void addExamResult(String examId, int score) {
        attemptedExams.add(examId);
        scores.add(score);
    }
}
