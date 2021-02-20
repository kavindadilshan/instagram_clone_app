package lk.ijse.ws.instagram.instagram_clone.service;

import lk.ijse.ws.instagram.instagram_clone.dto.ShareDto;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;

public interface ShareService {
    StandardResponse sharePost(ShareDto share) throws Exception;

    StandardResponse deleteSharedPost(int shareId) throws Exception;
}
