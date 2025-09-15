import java.util.ArrayList;
import java.util.List;

public class SurveyDirectory implements SurveyRepository{
    private List<Survey> surveys=new ArrayList<>();

    @Override
    public boolean addSurvey(Survey survey) {
        if(surveys.add(survey));
        return false;
    }


}
