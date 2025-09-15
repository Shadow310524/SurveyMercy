import java.util.List;
import java.util.UUID;

public class SurveyService {
    private SurveyRepository surveyRepository;
    private UserRepository userRepository;

    public SurveyService(SurveyRepository surveyRepository,UserRepository userRepository){
        this.surveyRepository=surveyRepository;
        this.userRepository=userRepository;
    }

    public boolean addSurvey(String currentUser, String title) {
        String id= UUID.randomUUID().toString();
        Survey survey=new Survey(id,currentUser,title);
        Users user=userRepository.checkuser(currentUser);
        if(user!=null){
        user.getSurveys().add(survey);
        surveyRepository.addSurvey(survey);
        return true;
        }
        return false;
    }

    public void viewSurveys(String currentUser) {
        Users user=userRepository.checkuser(currentUser);
        if(user!=null){
            List<Survey> surveyList=user.getSurveys();
            for(Survey survey:surveyList){
                System.out.println(survey.getId()+" "+survey.getCreatedBy()+" "+survey.getTitle());
            }
        }

    }
}
