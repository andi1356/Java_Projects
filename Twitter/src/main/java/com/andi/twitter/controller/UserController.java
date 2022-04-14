package com.andi.twitter.controller;

import com.andi.twitter.model.User;
import com.andi.twitter.service.FollowService;
import com.andi.twitter.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    private final FollowService followService;

    public UserController(UserService service, FollowService followService) {
        this.service = service;
        this.followService = followService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUserById(@PathVariable String id){
        return service.getById(id);
    }

    @PostMapping("/register")
    public void postUser(@RequestBody User user){
        service.register(user);
    }

    @GetMapping("")
    @ResponseBody
    public List<User> GetAll(){
        return service.getAll();
    }

//    @PutMapping TODO

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/search/{name}")
    @ResponseBody
    public List<User> search(@PathVariable String name){
        return service.search(name, name);
    }
}
