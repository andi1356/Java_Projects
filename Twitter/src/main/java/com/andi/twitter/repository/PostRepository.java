package com.andi.twitter.repository;

import com.andi.twitter.model.Post;
import com.andi.twitter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    @Query("select p from Post p where p.author = ?1")
    List<Post> findAllByAuthor(User users);


    @Query("select p from Post p")
    List<Post> findAll();
}
