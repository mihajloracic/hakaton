package mihajlo.rac.demo.model;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    private int id;

    private User user;

    private Monument monument;

    private String content;

    private int likeNumbers;

    private String timestamp;

    public Comment() {

    }

    public Comment(User user, Monument monument, String content) {
        this.user = user;
        this.monument = monument;
        this.content = content;
        this.likeNumbers = 0;
        this.timestamp = sdf.format(new Date());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Monument getMonument() {
        return monument;
    }

    public void setMonument(Monument monument) {
        this.monument = monument;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeNumbers() {
        return likeNumbers;
    }

    public void setLikeNumbers(int likeNumbers) {
        this.likeNumbers = likeNumbers;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
