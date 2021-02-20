package lk.ijse.ws.instagram.instagram_clone.controller;

import lk.ijse.ws.instagram.instagram_clone.dto.PostDto;
import lk.ijse.ws.instagram.instagram_clone.service.AmazonS3ClientService;
import lk.ijse.ws.instagram.instagram_clone.service.PostService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    @Autowired
    PostService postService;


    @Autowired
    private AmazonS3ClientService amazonS3ClientService;

    @PostMapping(value = "/create", consumes = {"multipart/form-data"})
    public ResponseEntity<StandardResponse> register(PostDto postDto, @RequestPart(value = "imageUrl") MultipartFile file) {
        try {
            System.out.println(postDto);
            System.out.println(file);
            System.out.println("register call : ");
//            this.amazonS3ClientService.uploadFileToS3Bucket(postDto.getImageUrl(), true);
            StandardResponse responseResponse = postService.createPost(postDto);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    @PutMapping(value = "/update/{postId}", consumes = {"multipart/form-data"})
    public ResponseEntity<StandardResponse> update(PostDto postDto, @RequestPart(value = "imageUrl") MultipartFile file, @PathVariable int postId) {
        try {
            System.out.println(postDto);
            System.out.println(file);
            System.out.println("register call : ");
//            this.amazonS3ClientService.uploadFileToS3Bucket(postDto.getImageUrl(), true);
            StandardResponse responseResponse = postService.updatePost(postDto,postId);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(value = "/getAll")
    public StandardResponse getAllPost() {
        try {
            System.out.println("calling*********************");
            StandardResponse responseResponse = postService.getAllPosts();
            return responseResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping(value = "/delete/{postId}")
    public StandardResponse deletePost(@PathVariable  int postId) {
        try {
            StandardResponse standardResponse = postService.deletePost(postId);
            return standardResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
