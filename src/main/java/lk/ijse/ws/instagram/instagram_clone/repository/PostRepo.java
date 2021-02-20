package lk.ijse.ws.instagram.instagram_clone.repository;

import lk.ijse.ws.instagram.instagram_clone.entity.Post;
import lk.ijse.ws.instagram.instagram_clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface PostRepo extends JpaRepository<Post,Long> {

//    @Query(value = "UPDATE Post p SET p.imageUrl=:imageUrl, p.postTime=:postTime,p.text=:text WHERE p.id IN (:id)")
//    Post updatePost(@Param("text")String text, @Param("imageUrl")String imageUrl, @Param("postTime")Date postTime, @Param("id")int postId);
}
