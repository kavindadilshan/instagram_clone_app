package lk.ijse.ws.instagram.instagram_clone.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    private String profilePicUrl;
    @OneToMany
    @MapKey(name = "post")
    private List<Post> allPosts;
    @OneToMany
    @MapKey(name = "share")
    private List<Share> allShares;
    @OneToMany
    @MapKey(name = "react")
    private List<React> allReacts;
    @OneToMany
    @MapKey(name = "comment")
    private List<Comment> allComments;

    public User() {
    }

    public User(String name, String username, String password, String profilePicUrl) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.profilePicUrl = profilePicUrl;
    }

    public User(int userId, String name, String username, String password, String profilePicUrl) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.profilePicUrl = profilePicUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profilePicUrl='" + profilePicUrl + '\'' +
                ", allPosts=" + allPosts +
                ", allShares=" + allShares +
                ", allReacts=" + allReacts +
                ", allComments=" + allComments +
                '}';
    }
}
