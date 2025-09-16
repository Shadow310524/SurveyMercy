public class AnswerService {
    private SurveyRepository surveyRepository;
    private UserRepository userRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    public AnswerService(SurveyRepository repository, UserRepository repo, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository=questionRepository;
        this.userRepository=repo;
        this.surveyRepository=repository;
        this.answerRepository=answerRepository;
    }
}
