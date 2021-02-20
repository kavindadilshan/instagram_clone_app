package lk.ijse.ws.instagram.instagram_clone.service.impl;


import lk.ijse.ws.instagram.instagram_clone.dto.ReactDto;
import lk.ijse.ws.instagram.instagram_clone.entity.React;
import lk.ijse.ws.instagram.instagram_clone.repository.ReactRepo;
import lk.ijse.ws.instagram.instagram_clone.service.ReactService;
import lk.ijse.ws.instagram.instagram_clone.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReactServiceImpl implements ReactService {

    @Autowired
    ReactRepo reactRepo;

    @Override
    public StandardResponse reactPost(ReactDto reactDto) throws Exception {
        System.out.println(reactDto);
        React react = new React();
        react.setReactor(reactDto.getReactor());
        react.setPost(reactDto.getPost());
        react.setReaction(reactDto.getReaction());
        react.setTime(new Date());
        React save = reactRepo.save(react);
        System.out.println(react);
        if (save != null) {
            return new StandardResponse(200, "Added Successful", save);

        }
        return new StandardResponse(415, "Not Added", null);
    }

    @Override
    public StandardResponse updateReact(ReactDto reactDto, int reactId) throws Exception {
        Optional<React> react = reactRepo.findById((long) reactId);
        if (react != null) {
            React newReact = new React(
                    react.get().getId(),
                    react.get().getReactor(),
                    react.get().getPost(),
                    reactDto.getReaction(),
                    new Date()
            );
            React update = reactRepo.save(newReact);

            if (update != null) {
                return new StandardResponse(200, "Update Successful", update);

            }
            return new StandardResponse(415, "Not Update", null);
        } else {
            return new StandardResponse(500, "Record not found", "");
        }
    }

    @Override
    public StandardResponse getAllReactionsToPost(int postId) throws Exception {
        List<React> allById = reactRepo.findAllByPostId(postId);
        if (allById.size() > 0) {
            return new StandardResponse(200, "Reactions", allById.toString());
        } else {
            return new StandardResponse(415, "Not Reactions to Post", null);
        }
    }

    @Override
    public StandardResponse deleteReact(int reactId) throws Exception {
        reactRepo.deleteById((long) reactId);
        return new StandardResponse(200, "Deleted Successful",null);
    }

}
