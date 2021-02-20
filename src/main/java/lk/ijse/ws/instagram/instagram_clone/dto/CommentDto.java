package lk.ijse.ws.instagram.instagram_clone.dto;

import lk.ijse.ws.instagram.instagram_clone.entity.Post;
import lk.ijse.ws.instagram.instagram_clone.entity.User;


public class CommentDto {

    private User commenter;
    private Post post;
    private String comment;

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

    @Override
    public String toString() {
        return "CommentDto{" +
                "commenter=" + commenter +
                ", post=" + post +
                ", comment='" + comment + '\'' +
                '}';
    }
}
