package lk.ijse.ws.instagram.instagram_clone.dto;

import lk.ijse.ws.instagram.instagram_clone.entity.User;
import org.springframework.web.multipart.MultipartFile;



public class PostDto {
    private String text;
    private MultipartFile imageUrl;
    private User user;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MultipartFile getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(MultipartFile imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    @Override
//    public String toString() {
//        return "PostDto{" +
//                "text='" + text + '\'' +
//                ", user=" + user +
//                '}';
//    }

        @Override
    public String toString() {
        return "PostDto{" +
                "text='" + text + '\'' +
                ", imageUrl=" + imageUrl +
                ", user=" + user +
                '}';
    }
}
