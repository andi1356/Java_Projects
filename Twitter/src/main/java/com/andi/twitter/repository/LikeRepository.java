package com.andi.twitter.repository;

import com.andi.twitter.model.Like;
import com.andi.twitter.model.Post;
import com.andi.twitter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {
    @Query("select l from Like l where l.user = ?1 and l.post = ?2")
    public Like findByUserAndPost(User user, Post post);
}
