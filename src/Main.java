import java.util.*;
public class Main {
    static int survey_id=1;
    static int question_id=1;
    static int answer_id=1;
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
        int val;
        String name;
        String password;
        String current_user="";
        String title;
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
                System.out.println("3)View All Surveys");
                System.out.println("4)Respond to Survey");
                System.out.println("5)Logout");
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
                                System.out.println(survey.getId()+" "+survey.getTitle());
                            }
                        System.out.println("---------------------------------------");
                        break;
                    case 3:
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
                        System.out.println("Logging out!!");
                        current=false;
                        break;
                }
            }
        }
    }
}