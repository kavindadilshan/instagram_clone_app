package lk.ijse.ws.instagram.instagram_clone.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String imageUrl;
    private Date postTime;
    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public Post() {
    }

    public Post(Long id, String text, String imageUrl, Date postTime, User user) {
        this.id = id;
        this.text = text;
        this.imageUrl = imageUrl;
        this.postTime = postTime;
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", postTime=" + postTime +
                ", user=" + user +
                '}';
    }
}
