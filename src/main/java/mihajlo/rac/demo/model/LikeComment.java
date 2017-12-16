package mihajlo.rac.demo.model;


public class LikeComment {

    private int id;

    private User user;

    private Comment comment;

    public LikeComment() {
    }

    public LikeComment(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "LikeComment{" +
                "id=" + id +
                ", user=" + user +
                ", comment=" + comment +
                '}';
    }
}
