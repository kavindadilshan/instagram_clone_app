package lk.ijse.ws.instagram.instagram_clone.repository;

import lk.ijse.ws.instagram.instagram_clone.entity.React;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReactRepo extends JpaRepository<React, Long> {
    @Query(value = "SELECT * from React e where e.post_id =:post_id ", nativeQuery = true)
     List<React> findAllByPostId(@Param("post_id") int postId);
}
