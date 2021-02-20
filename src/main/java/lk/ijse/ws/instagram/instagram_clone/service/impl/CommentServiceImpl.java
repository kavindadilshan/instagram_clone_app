package lk.ijse.ws.instagram.instagram_clone.service.impl;

import lk.ijse.ws.instagram.instagram_clone.dto.CommentDto;
import lk.ijse.ws.instagram.instagram_clone.entity.Comment;
import lk.ijse.ws.instagram.instagram_clone.entity.Post;
import lk.ijse.ws.instagram.instagram_clone.repository.CommentRepo;
import lk.ijse.ws.instagram.instagram_clone.service.CommentService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;


@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Override
    public StandardResponse createComment(CommentDto commentDto) throws Exception {
        System.out.println(commentDto);
        Comment comment = new Comment();
        comment.setTime(new Date());
        comment.setCommenter(commentDto.getCommenter());
        comment.setComment(commentDto.getComment());
        comment.setPost(commentDto.getPost());

        System.out.println("comment : " + comment);
        Comment save = commentRepo.save(comment);
        System.out.println(save);
        if (save != null) {
            return new StandardResponse(200, "Added Sucessful", save);

        }
        return new StandardResponse(415, "Not Added", null);
    }
}
