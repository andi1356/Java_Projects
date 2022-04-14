package com.andi.twitter.repository;

import com.andi.twitter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

//    @Query("select u from User u where u.firstname = ?1 or u.lastname = ?2")
//    public List<User> findAllByFirstnameOrLastname(String firstname, String lastname);

    @Query("select u from User u where u.firstname = ?1 or u.lastname = ?2")
    public List<User> findAllByFirstnameOrLastname(String firstname, String lastname);

    @Query("select u from User u")
    public List<User> findAll();
}
