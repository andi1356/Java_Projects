package com.andi.twitter.service;

import com.andi.twitter.model.User;
import com.andi.twitter.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(User user){
        return repository.save(user);
    }

    public User getById(String id){
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

//    public User update TODO

    public void delete(String id){
        repository.deleteById(id);
    }

    public List<User> search(String firstname, String lastname){
        return repository.findAllByFirstnameOrLastname(firstname, lastname);
    }

    public List<User> getAll(){
        return repository.findAll();
    }
}
