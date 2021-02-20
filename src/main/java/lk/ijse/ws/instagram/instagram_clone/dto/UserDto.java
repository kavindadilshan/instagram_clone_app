package lk.ijse.ws.instagram.instagram_clone.dto;


import org.springframework.web.multipart.MultipartFile;

public class UserDto {
    private String name;
    private String username;
    private String password;
    private MultipartFile profilePicUrl;

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

    public MultipartFile getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(MultipartFile profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profilePicUrl=" + profilePicUrl +
                '}';
    }
}
