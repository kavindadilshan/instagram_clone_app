package lk.ijse.ws.instagram.instagram_clone.service;

import lk.ijse.ws.instagram.instagram_clone.dto.CommentDto;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;

public interface CommentService {
    StandardResponse createComment(CommentDto commentDto) throws Exception;
}
