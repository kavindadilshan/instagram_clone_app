package lk.ijse.ws.instagram.instagram_clone.dto;

import lk.ijse.ws.instagram.instagram_clone.entity.Post;
import lk.ijse.ws.instagram.instagram_clone.entity.User;


public class ShareDto {

    private User sharedUser;
    private Post post;

    public User getSharedUser() {
        return sharedUser;
    }

    public void setSharedUser(User sharedUser) {
        this.sharedUser = sharedUser;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "ShareDto{" +
                "sharedUser=" + sharedUser +
                ", post=" + post +
                '}';
    }
}
