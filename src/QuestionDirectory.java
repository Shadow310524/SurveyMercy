import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDirectory implements QuestionRepository {
    private Map<Integer, List<Question>>questionList=new HashMap<>();
    private int qid=1;
    @Override
    public void addQuestion(Question question) {
        question.setId(qid++);
        questionList.putIfAbsent(question.getSurveyId(),new ArrayList<>());
        questionList.get(question.getSurveyId()).add(question);
    }

    @Override
    public List<Question> displayQuestions() {
        List<Question> questions=new ArrayList<>();
        for(List<Question> question:questionList.values()){
            questions.addAll(question);
        }
        return questions;

    }

}
