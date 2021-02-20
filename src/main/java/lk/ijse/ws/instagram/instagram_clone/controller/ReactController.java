package lk.ijse.ws.instagram.instagram_clone.controller;


import lk.ijse.ws.instagram.instagram_clone.dto.ReactDto;
import lk.ijse.ws.instagram.instagram_clone.service.ReactService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/react")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReactController {

    @Autowired
    ReactService reactService;

    @PostMapping(value = "/save", consumes = {"application/json"}, produces = "application/json")
    public ResponseEntity<StandardResponse> save(@RequestBody ReactDto reactDto) {
        try {
            System.out.println(reactDto);
            System.out.println("react call : ");
//            this.amazonS3ClientService.uploadFileToS3Bucket(postDto.getImageUrl(), true);
            StandardResponse responseResponse = reactService.reactPost(reactDto);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PutMapping(value = "/update/{reactId}", consumes = {"application/json"}, produces = "application/json")
    public ResponseEntity<StandardResponse> update(@RequestBody ReactDto reactDto,@PathVariable int reactId) {
        try {
            System.out.println(reactDto);
            System.out.println("react call : ");
//            this.amazonS3ClientService.uploadFileToS3Bucket(postDto.getImageUrl(), true);
            //            this.amazonS3ClientService.uploadFileToS3Bucket(postDto.getImageUrl(), true);
            StandardResponse responseResponse = reactService.updateReact(reactDto,reactId);
            return new ResponseEntity<>(responseResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(value = "/getAlltopost/{postId}")
    public StandardResponse getAllReactionsToPost(@PathVariable int postId) {
        try {
            System.out.println("calling*********************");
            StandardResponse responseResponse = reactService.getAllReactionsToPost(postId);
            return responseResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping(value = "/delete/{reactId}")
    public StandardResponse deletePost(@PathVariable  int reactId) {
        try {
            StandardResponse standardResponse = reactService.deleteReact(reactId);
           return standardResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
