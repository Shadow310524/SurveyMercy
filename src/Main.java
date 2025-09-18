import java.util.*;
public class Main {
//    static int survey_id=1;
//    static int question_id=1;
//    static int answer_id=1;
    public static void main(String[] args) {
        System.out.println("------------------------");
        System.out.println("User Registration page");
        System.out.println("------------------------");
        Scanner inp=new Scanner(System.in);
        UserRepository repo=new UserDirectory();
        UserService userService=new UserService(repo);
        SurveyRepository repository=new SurveyDirectory();
        SurveyService surveyService=new SurveyService(repository,repo);
        QuestionRepository questionRepository=new QuestionDirectory();
        QuestionService questionService=new QuestionService(repository,repo,questionRepository);
        AnswerRepository answerRepository=new AnswerDirectory();
        AnswerService answerService=new AnswerService(repository,repo,questionRepository,answerRepository);
        boolean current=false;
        int val,sid;
        String name;
        String password;
        String current_user="";
        String title,type;
        List<Survey> surveyList;
        while(true){
            System.out.println("1)Add User");
            System.out.println("2)Login");
            System.out.println("3)Exit");
            val=inp.nextInt();
            inp.nextLine();
            switch (val) {
                case 1:
                    System.out.println("Enter Username");
                    name=inp.nextLine();
                    System.out.println("Enter Password");
                    password=inp.nextLine();
                    userService.add(name,password);
                    break;
                case 2:
                    System.out.println("Enter Username");
                    name=inp.nextLine();
                    System.out.println("Enter Password");
                    password=inp.nextLine();
                    if(userService.check(name,password)) {
                        current_user=name;
                        current = true;
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bye byee");
                    break;
            }
            while(current){
                System.out.println("Hello "+current_user);
                System.out.println("1)Create Survey");
                System.out.println("2)View Surveys");
                System.out.println("3)Add Questions");
                System.out.println("4)View All Surveys");
                System.out.println("5)View Questions");
                System.out.println("6)Respond to Survey");
                System.out.println("7)Logout");
                val= inp.nextInt();
                inp.nextLine();
                switch (val){
                    case 1:
                        System.out.println("Title");
                        title= inp.nextLine();
                        if(surveyService.addSurvey(current_user,title)){
                            System.out.println("Survey added");
                        }
                        else
                            System.out.println("Survey not added");
                        break;
                    case 2:
                        System.out.println("---------------------------------------");
                        System.out.println("Displaying Survey List -> "+current_user);
                        System.out.println("---------------------------------------");
                        surveyList=surveyService.viewSurveys(current_user);
                        if(surveyList!=null)
                            for(Survey survey:surveyList){
                                System.out.println(survey.getId()+")"+survey.getTitle());
                            }
                        System.out.println("---------------------------------------");
                        break;
                    case 3:
                        System.out.println("Enter Survey id");
                        sid=inp.nextInt();
                        inp.nextLine();
                        if(questionService.checkQuestion(current_user,sid)) {
                            System.out.println("Enter question Type(TEXT/MCQ)");
                            type = inp.nextLine();
                            if (questionService.addQuestion(sid, type, inp))
                                System.out.println("Question Successfully added");
                        }
                        else
                            System.out.println("Survey id not found!!");
                        break;
                    case 4:
                        System.out.println("---------------------------------------");
                        System.out.println("Displaying Survey List of all users");
                        System.out.println("---------------------------------------");
                        surveyList=surveyService.viewSurveys();
                        for(Survey survey:surveyList){
                            System.out.println(survey.getId()+")"+survey.getCreatedBy()+" "+survey.getTitle());
                        }
                        System.out.println("---------------------------------------");
                        break;
                    case 5:
                        System.out.println("---------------------------------------");
                        System.out.println("Displaying Questions");
                        System.out.println("---------------------------------------");
                        List<Question> questionList=questionService.displayQuestion();
                        for(Question question:questionList){
                            System.out.println(question.getSurveyId());
                            if(question.getType()==QuestionTypes.TEXT) {
                                System.out.println(question.getId() + ")" + question.getText());
                            }
                            else{
                                int idx=0;
                                System.out.println(question.getId() + ")" + question.getText());
                                for(String opt:question.getOptions()){
                                    System.out.println((char)(idx+'a')+")"+opt);
                                    idx++;
                                }
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Logging out!!");
                        current=false;
                        break;
                }
            }
        }
    }
}
