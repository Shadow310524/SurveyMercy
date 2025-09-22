public class Answer {
    private int id;
    private int question_id;
    private String text;
    private char correct_option;
    private String user_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char getCorrect_option() {
        return correct_option;
    }

    public void setCorrect_option(char correct_option) {
        this.correct_option = correct_option;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
