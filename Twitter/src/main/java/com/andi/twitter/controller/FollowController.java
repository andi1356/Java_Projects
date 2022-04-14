package com.andi.twitter.controller;


import com.andi.twitter.model.User;
import com.andi.twitter.service.FollowService;
import com.andi.twitter.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class FollowController {
    private final UserService userService;
    private final FollowService followService;

    public FollowController(UserService userService, FollowService followService) {
        this.userService = userService;
        this.followService = followService;
    }

    @PostMapping("/{userId}/follow/{followId}")
    public void startFollowing(@PathVariable String userId, @PathVariable String followId){
        followService.startFollowing(userId, followId);
    }

    @DeleteMapping("/{userId}/unfollow/{followId}")
    public void stopFollowing(@PathVariable String userId, @PathVariable String followId){
        followService.stopFollowing(userId, followId);
    }

    @GetMapping("/{userId}/followers")
    public List<User> getFollowers(@PathVariable String userId){
        return followService.getFollowers(userId);
    }

    @GetMapping("/{userId}/following")
    public List<User> getFollowing(@PathVariable String userId){
        return followService.getFollowing(userId);
    }


}
