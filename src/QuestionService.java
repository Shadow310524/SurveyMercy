import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionService {
        private final SurveyRepository surveyRepository;
        private final UserRepository userRepository;
        private final QuestionRepository questionRepository;

        public QuestionService(SurveyRepository repository, UserRepository repo, QuestionRepository questionRepository) {
            this.questionRepository=questionRepository;
            this.userRepository=repo;
            this.surveyRepository=repository;
        }

        public boolean checkQuestion(String current_user, int sid) {
            List<Survey> surveyList=surveyRepository.viewAllSurveys(current_user);
            for(Survey survey:surveyList){
                if(survey.getId()==sid)
                    return true;
            }
            return false;

        }

    public boolean addQuestion(int sid, String typeInput, Scanner inp) {
        try {
            QuestionTypes type = QuestionTypes.valueOf(typeInput.toUpperCase());
            System.out.println("Enter Question");
            String question=inp.nextLine();
            Question question_builder=new Question();
            question_builder.setSurveyId(sid);
            question_builder.setText(question);
            question_builder.setType(type);
            if(type==QuestionTypes.MCQ){
                List<String> options=new ArrayList<>();
                for (int i=0;i<4;i++){
                    System.out.println("Enter Option "+(i+1));
                    String opt=inp.nextLine();
                    options.add(opt);
                }
                question_builder.setOptions(options);
            }
            questionRepository.addQuestion(question_builder);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid type! Please enter TEXT or MCQ.");
            return false;
        }
    }

    public List<Question> displayQuestion() {
            return questionRepository.displayQuestions();
    }
}
