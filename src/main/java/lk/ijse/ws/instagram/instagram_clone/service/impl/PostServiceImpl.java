package lk.ijse.ws.instagram.instagram_clone.service.impl;

import lk.ijse.ws.instagram.instagram_clone.dto.PostDto;
import lk.ijse.ws.instagram.instagram_clone.entity.Post;
import lk.ijse.ws.instagram.instagram_clone.repository.PostRepo;
import lk.ijse.ws.instagram.instagram_clone.service.PostService;
import lk.ijse.ws.instagram.instagram_clone.util.S3FileUploader;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private S3FileUploader fileUploader;

    @Override
    public StandardResponse createPost(PostDto postDto) throws Exception {
        System.out.println(postDto);
        Post post = new Post();
        String s = this.fileUploader.uploadFile(postDto.getImageUrl());
        System.out.println("file name is : " + s);
        post.setImageUrl(this.fileUploader.uploadFile(postDto.getImageUrl()));
        post.setPostTime(new Date());
        post.setText(postDto.getText());
        post.setUser(postDto.getUser());
        Post save = postRepo.save(post);
        System.out.println(post);
        if (save != null) {
            return new StandardResponse(200, "Added Sucessful", save);

        }
        return new StandardResponse(415, "Not Added", null);

    }

    @Override
    public StandardResponse getAllPosts() throws Exception {
        List<Post> all = postRepo.findAll();
        if (all.size() > 0) {
            return new StandardResponse(200, "", all);
        } else {
            return new StandardResponse(200, "", null);
        }
    }

    @Override
    public StandardResponse deletePost(int postId) throws Exception {
        postRepo.deleteById((long) postId);
        return new StandardResponse(200, "Deleted Successful", null);
    }

    @Override
    public StandardResponse updatePost(PostDto postDto, int postId) throws Exception {
        Optional<Post> isExists = postRepo.findById((long) postId);
        if (isExists == null) {
            return new StandardResponse(200, "Record not found", "");
        }
        String imageUrl;

        imageUrl = this.fileUploader.uploadFile(postDto.getImageUrl());

        Post newPost = new Post(
                isExists.get().getId(),
                postDto.getText(),
                "https://myawsimagebucket.s3.us-east-2.amazonaws.com/" + postDto.getImageUrl().getOriginalFilename(),
                new Date(),
                postDto.getUser()

        );
        Post update = postRepo.save(newPost);
        System.out.println(update);
        if (update != null) {
            return new StandardResponse(200, "Update Successful", update);
        }
        return new StandardResponse(415, "Not Updated", null);

    }
}
