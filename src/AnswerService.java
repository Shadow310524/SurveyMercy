import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void submitAnswer(String currentUser, Question q,String ans) {
        Answer answer=new Answer();
        answer.setQuestion_id(q.getId());
        answer.setText(ans);
        answerRepository.addAnswer(answer);
    }
    public void submitAnswer(String currentUser, Question q,char option) {
        Answer answer=new Answer();
        answer.setQuestion_id(q.getId());
        answer.setCorrect_option(option);
        answerRepository.addAnswer(answer);
    }

    public void respondToSurvey(String current_user, int sid, Scanner inp) {
        int qid;
        QuestionService questionService=new QuestionService(surveyRepository,userRepository,questionRepository);
        SurveyService surveyService=new SurveyService(surveyRepository,userRepository);
        List<Survey> surveyList=surveyService.viewSurveys();
        Survey s=null;
        Question question=null;
        if(surveyList!=null) {
            for (Survey survey : surveyList) {
                if (survey.getId() == sid) {
                    s = survey;
                    break;
                }
            }
            if (s == null)
                System.out.println("Survey ID not found");
            else {
                List<Question> questions = questionService.displayQuestion();
                if (questions != null) {
                    System.out.println("Enter Question ID to respond");
                    qid = inp.nextInt();
                    inp.nextLine();
                    List<Question> questionList = questionService.displayQuestion();
                    for (Question qu : questionList) {
                        if (qu.getId() == qid) {
                            question = qu;
                            break;
                        } else {
                            System.out.println("No Questions Available");
                        }
                    }
                    if (question == null)
                        System.out.println("Question ID not found");
                    else {
                        if (question.getType() == QuestionTypes.TEXT) {
                            System.out.println(question.getId() + ")" + question.getText());
                            System.out.println("Enter correct answer");
                            String answer = inp.nextLine();
                            submitAnswer(current_user, question, answer);
                        } else {
                            int idx = 0;
                            System.out.println(question.getId() + ")" + question.getText());
                            for (String opt : question.getOptions()) {
                                System.out.println((char) (idx + 'a') + ")" + opt);
                                idx++;
                            }
                            System.out.println("Enter correct option");
                            char option = inp.next().charAt(0);
                            submitAnswer(current_user, question, option);
                        }
                        System.out.println("Answer added successfully");
                    }
                }
            }
        }
        else {
            System.out.println("No Surveys Available");
        }
    }
}
