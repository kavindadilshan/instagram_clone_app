package lk.ijse.ws.instagram.instagram_clone.controller;


import lk.ijse.ws.instagram.instagram_clone.dto.CommentDto;
import lk.ijse.ws.instagram.instagram_clone.dto.PostDto;
import lk.ijse.ws.instagram.instagram_clone.dto.ShareDto;
import lk.ijse.ws.instagram.instagram_clone.service.ShareService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/share")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShareController {

    @Autowired
    ShareService shareService;

    @PostMapping(value = "/post", consumes = {"application/json"}, produces = "application/json")
    public ResponseEntity<StandardResponse> register(@RequestBody ShareDto share) {
        try {
            System.out.println(share);

            System.out.println("post call : ");
//            this.amazonS3ClientService.uploadFileToS3Bucket(postDto.getImageUrl(), true);
            StandardResponse responseResponse = shareService.sharePost(share);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @DeleteMapping(value = "/delete/{shareId}")
    public StandardResponse deleteSharePost(@PathVariable  int shareId) {
        try {
            StandardResponse standardResponse = shareService.deleteSharedPost(shareId);
            return standardResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
