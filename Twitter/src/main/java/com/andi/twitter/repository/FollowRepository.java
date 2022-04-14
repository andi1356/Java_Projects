package com.andi.twitter.repository;

import com.andi.twitter.model.Follow;
import com.andi.twitter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Query("select f from Follow f where f.user = ?1")
    public List<Follow> findAllByUser(User user);

    @Query("select f from Follow f where f.follow = ?1")
    public List<Follow> findAllByFollow(User user);

    @Query("select f from Follow f where f.user = ?1 and f.follow = ?2")
    public Follow findByUserAndFollow(User user, User follow);


}
