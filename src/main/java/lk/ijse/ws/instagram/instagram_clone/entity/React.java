package lk.ijse.ws.instagram.instagram_clone.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class React {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User reactor;
    @ManyToOne
    private Post post;
    private String reaction;
    private Date time;

    public React() {
    }

    public React(Long id, User reactor, Post post, String reaction, Date time) {
        this.id = id;
        this.reactor = reactor;
        this.post = post;
        this.reaction = reaction;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getReactor() {
        return reactor;
    }

    public void setReactor(User reactor) {
        this.reactor = reactor;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "React{" +
                "id=" + id +
                ", reactor=" + reactor +
                ", post=" + post +
                ", reaction='" + reaction + '\'' +
                ", time=" + time +
                '}';
    }
}
