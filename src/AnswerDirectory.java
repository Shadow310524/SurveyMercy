import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerDirectory implements AnswerRepository {
    private Map<Integer, List<Answer>> answerList=new HashMap<>();
    private int aid=1;
    @Override
    public void addAnswer(Answer answer) {
        answer.setQuestion_id(aid++);
        answerList.putIfAbsent(answer.getQuestion_id(), new ArrayList<>());
        answerList.get(answer.getQuestion_id()).add(answer);
    }

    @Override
    public List<Answer> displayAnswer() {
        List<Answer> answers=new ArrayList<>();
        for(List<Answer> a:answerList.values()){
            answers.addAll(a);
        }
        return answers;
    }
}
