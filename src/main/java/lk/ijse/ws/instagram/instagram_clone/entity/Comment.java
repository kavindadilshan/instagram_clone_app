package lk.ijse.ws.instagram.instagram_clone.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private User commenter;
    @ManyToOne()
    private Post post;
    private String comment;
    private Date time;

    public Comment() {
    }

    public Comment(User commenter, Post post, String comment) {
        this.commenter = commenter;
        this.post = post;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commenter=" + commenter +
                ", post=" + post +
                ", comment='" + comment + '\'' +
                ", time=" + time +
                '}';
    }
}
