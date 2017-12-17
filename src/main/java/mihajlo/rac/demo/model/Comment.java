package mihajlo.rac.demo.model;


import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Comment implements Serializable {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
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
