package lk.ijse.ws.instagram.instagram_clone.service;

import lk.ijse.ws.instagram.instagram_clone.dto.UserDto;
import lk.ijse.ws.instagram.instagram_clone.entity.User;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;

public interface UserService {
    StandardResponse registerUser(UserDto userDto) throws Exception;

    StandardResponse getUserbyId(int userId) throws Exception;

    StandardResponse updateUserDetails(UserDto userDto, int userId) throws Exception;

    User loadUsernameAndPassword(String username) throws Exception;
}
