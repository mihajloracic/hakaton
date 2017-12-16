package mihajlo.rac.demo.model;



public class LikeMonument {

    private int id;

    private User user;

    private Monument monument;

    public LikeMonument() {

    }

    public LikeMonument(User user, Monument monument) {
        this.user = user;
        this.monument = monument;
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

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", user=" + user +
                ", monument=" + monument +
                '}';
    }
}
