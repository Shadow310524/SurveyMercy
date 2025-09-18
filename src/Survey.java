import java.util.List;

public class Survey {
    private int id;
    private String title;
    private String createdBy;

    public Survey(int id, String currentUser, String title) {
        this.id=id;
        this.createdBy=currentUser;
        this.title=title;
    }

    public int getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }
}
