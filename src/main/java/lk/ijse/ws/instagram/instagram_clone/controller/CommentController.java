package lk.ijse.ws.instagram.instagram_clone.controller;


import lk.ijse.ws.instagram.instagram_clone.dto.CommentDto;
import lk.ijse.ws.instagram.instagram_clone.service.CommentService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping(value = "/addcomment", consumes = {"application/json"}, produces = "application/json")
    public ResponseEntity<StandardResponse> register(@RequestBody CommentDto comment) {
        try {
            System.out.println(comment);
            System.out.println("register call : ");

            StandardResponse responseResponse = commentService.createComment(comment);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    @PostMapping(value = "/update", consumes = {"application/json"}, produces = "application/json")
    public ResponseEntity<StandardResponse> updateComment(@RequestBody CommentDto comment) {
        try {
            System.out.println(comment);
            System.out.println("register call : ");
//            this.amazonS3ClientService.uploadFileToS3Bucket(postDto.getImageUrl(), true);
            StandardResponse responseResponse = commentService.createComment(comment);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
