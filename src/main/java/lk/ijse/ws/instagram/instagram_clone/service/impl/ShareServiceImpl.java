package lk.ijse.ws.instagram.instagram_clone.service.impl;


import lk.ijse.ws.instagram.instagram_clone.dto.ShareDto;
import lk.ijse.ws.instagram.instagram_clone.entity.Post;
import lk.ijse.ws.instagram.instagram_clone.entity.Share;
import lk.ijse.ws.instagram.instagram_clone.repository.ShareRepo;
import lk.ijse.ws.instagram.instagram_clone.service.ShareService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class ShareServiceImpl implements ShareService {
    @Autowired
    ShareRepo shareRepo;

    @Override
    public StandardResponse sharePost(ShareDto shareDto) throws Exception {
        System.out.println(shareDto);
        Share share = new Share();
        share.setSharedUser(shareDto.getSharedUser());
        share.setPost(shareDto.getPost());
        share.setTime(new Date());
        Share save = shareRepo.save(share);
        System.out.println(share);
        if (save != null) {
            return new StandardResponse(200, "Added Sucessful", save);

        }
        return new StandardResponse(415, "Not Added", null);
    }

    @Override
    public StandardResponse deleteSharedPost(int shareId) throws Exception {
        shareRepo.deleteById((long) shareId);
        return new StandardResponse(200, "Deleted Successful",null);
    }
}
