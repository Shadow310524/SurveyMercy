import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDirectory implements QuestionRepository {
    private Map<Integer, List<Question> questionList=new HashMap<>();
    @Override
    public void addQuestion(String type, Question question) {
        if(questionList.containsKey(question.getId()))
    }

}
