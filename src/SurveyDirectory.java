import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyDirectory implements SurveyRepository{
    private Map<String,List<Survey>> surveys=new HashMap<>();

    @Override
    public void addSurvey(String username,Survey survey) {
            surveys.putIfAbsent(username,new ArrayList<>());
            surveys.get(username).add(survey);

    }
    public List<Survey> viewAllSurveys(){
        List<Survey> surveyList=new ArrayList<>();
        for (List<Survey> survey: surveys.values())
            surveyList.addAll(survey);
        return surveyList;
    }

    @Override
    public List<Survey> viewAllSurveys(String username) {
        return surveys.get(username);
    }

}
