package lk.ijse.ws.instagram.instagram_clone.dto;

import lk.ijse.ws.instagram.instagram_clone.entity.Post;
import lk.ijse.ws.instagram.instagram_clone.entity.User;


public class ReactDto {

    private User reactor;
    private Post post;
    private String reaction;

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
}
