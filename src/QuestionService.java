public class QuestionService {
    private SurveyRepository surveyRepository;
    private UserRepository userRepository;
    private QuestionRepository questionRepository;

    public QuestionService(SurveyRepository repository, UserRepository repo, QuestionRepository questionRepository) {
        this.questionRepository=questionRepository;
        this.userRepository=repo;
        this.surveyRepository=repository;
    }
    public void addQuestion(String Question){
        return;
    }
}
