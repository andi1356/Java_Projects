package com.andi.twitter.controller;

import com.andi.twitter.model.Post;
import com.andi.twitter.model.User;
import com.andi.twitter.service.FollowService;
import com.andi.twitter.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService service;
    private final FollowService followService;

    public PostController(PostService service, FollowService followService) {
        this.service = service;
        this.followService = followService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Post getUserById(@PathVariable String id){
        return service.getById(id);
    }

    @PostMapping("/create")
    public void createPost(@RequestBody Post post){
        service.create(post);
    }

    @GetMapping("")
    @ResponseBody
    public List<Post> getAll(){
        return service.getAll();
    }

//    @PutMapping TODO

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/{userId}/mine")
    @ResponseBody public List<Post> getOwnPosts(@PathVariable String userId){
        return service.getOwnPosts(userId);
    }

    @GetMapping("/{userId}/feed")
    @ResponseBody public List<Post> getFeed(@PathVariable String userId){
        List<User> followingUsers = followService.getFollowing(userId);
        return service.findAllPostsFromUsers(followingUsers);
    }

    @PostMapping("/{userId}/repost/{postId}")
    public void repost(@PathVariable String userId,@PathVariable String postId){
        service.repost(userId, postId);
    }
}
