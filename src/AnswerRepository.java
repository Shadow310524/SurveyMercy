import java.util.List;

public interface AnswerRepository {
    void addAnswer(Answer answer);
    List<Answer> displayAnswer();
}
