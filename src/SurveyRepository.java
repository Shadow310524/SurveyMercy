import java.util.List;

public interface SurveyRepository {
    void addSurvey(String username,Survey survey);
    List<Survey> viewAllSurveys();
    List<Survey> viewAllSurveys(String username);
}
