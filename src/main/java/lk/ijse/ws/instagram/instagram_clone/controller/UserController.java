package lk.ijse.ws.instagram.instagram_clone.controller;

import lk.ijse.ws.instagram.instagram_clone.dto.UserDto;
import lk.ijse.ws.instagram.instagram_clone.entity.User;
import lk.ijse.ws.instagram.instagram_clone.service.AmazonS3ClientService;
import lk.ijse.ws.instagram.instagram_clone.service.UserService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private AmazonS3ClientService amazonS3ClientService;

    @PostMapping(value = "/register", consumes = {"multipart/form-data"})
    public ResponseEntity<StandardResponse> register(UserDto userDto, @RequestPart(value = "profilePicUrl") MultipartFile file) {
        try {
            System.out.println(userDto);
            System.out.println(file);
            System.out.println("register call : ");
//            this.amazonS3ClientService.uploadFileToS3Bucket(userDto.getProfilePicUrl(), true);
            StandardResponse responseResponse = userService.registerUser(userDto);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @PutMapping(value = "/update/{userId}", consumes = {"multipart/form-data"})
    public ResponseEntity<StandardResponse> update(@RequestBody UserDto userDto, @RequestPart(value = "profilePicUrl") MultipartFile file, @PathVariable int userId) {
        try {
            System.out.println(userDto);
            System.out.println(file);
            System.out.println("register call : ");
//            this.amazonS3ClientService.uploadFileToS3Bucket(userDto.getProfilePicUrl(), true);
            StandardResponse responseResponse = userService.updateUserDetails(userDto,userId);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @RequestMapping(value = "/getuser/{userId}")
    public ResponseEntity<StandardResponse> getUserById(@PathVariable  int userId) {
        System.out.println("get call");
        StandardResponse standardResponse = null;
        try {
            standardResponse = userService.getUserbyId(userId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (e.getMessage().equals("Invalid user Id:"+userId)){
                return new ResponseEntity<>(standardResponse, HttpStatus.OK);
            }
            e.printStackTrace();
        }
        return new ResponseEntity<>(standardResponse, HttpStatus.OK);
    }
}
