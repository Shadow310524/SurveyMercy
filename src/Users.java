import java.util.ArrayList;
import java.util.List;

public class Users {
    private String name;
    private String password;
    private List<Survey> Surveys;

    Users(String name,String password){
        this.name=name;
        this.password=password;
        this.Surveys=new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }

    public List<Survey> getSurveys() {
        return Surveys;
    }
}

