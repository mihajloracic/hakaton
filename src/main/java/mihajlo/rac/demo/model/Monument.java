package mihajlo.rac.demo.model;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class Monument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imageUrl;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "monument")
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "monument")
    private Set<LikeMonument> likes;


    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Monument() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
