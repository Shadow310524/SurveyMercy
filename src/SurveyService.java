import java.util.List;
import java.util.UUID;

public class SurveyService {
    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;

    public SurveyService(SurveyRepository surveyRepository,UserRepository userRepository){
        this.surveyRepository=surveyRepository;
        this.userRepository=userRepository;
    }

    public boolean addSurvey(String currentUser, String title) {
        String id= UUID.randomUUID().toString();
        Survey survey=new Survey(id,currentUser,title);
        Users user=userRepository.checkuser(currentUser);
        if(user!=null){
        surveyRepository.addSurvey(currentUser,survey);
        return true;
        }
        return false;
    }

    public List<Survey> viewSurveys(String currentUser) {
        Users user=userRepository.checkuser(currentUser);
        if(user!=null){
            List<Survey> surveyList=surveyRepository.viewAllSurveys(currentUser);
            if(surveyList!=null)
                return surveyList;
        }
        return null;
    }
    public List<Survey> viewSurveys(){
        return surveyRepository.viewAllSurveys();
    }
}
