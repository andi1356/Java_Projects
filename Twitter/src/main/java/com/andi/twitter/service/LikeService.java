package com.andi.twitter.service;

import com.andi.twitter.model.Like;
import com.andi.twitter.repository.LikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private final LikeRepository repository;
    private final UserService userService;
    private final PostService postService;

    public LikeService(LikeRepository repository, UserService userService, PostService postService) {
        this.repository = repository;
        this.userService = userService;
        this.postService = postService;
    }

    public void like(String userId, String postId){

        Like like = new Like(userService.getById(userId), postService.getById(postId));
        repository.save(like);
    }

    public void unlike(String userId, String postId){
        Like like = repository.findByUserAndPost(userService.getById(userId), postService.getById(postId));
        repository.delete(like);
    }
}
