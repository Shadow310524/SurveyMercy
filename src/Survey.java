import java.util.List;

public class Survey {
    private String id;
    private String title;
    private String createdBy;
//    private List<Question> questions;

    public Survey(String id, String currentUser, String title) {
        this.id=id;
        this.createdBy=currentUser;
        this.title=title;
    }

    public String getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getTitle() {
        return title;
    }


}
