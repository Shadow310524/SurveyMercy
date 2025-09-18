import java.util.List;

public interface QuestionRepository {
    void addQuestion(Question question);
    List<Question> displayQuestions();
}
