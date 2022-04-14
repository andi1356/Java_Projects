package com.andi.twitter.controller;

import com.andi.twitter.service.LikeService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class LikeController {
    private final LikeService service;

    public LikeController(LikeService service) {
        this.service = service;
    }

    @PostMapping("/{userId}/like/{postId}")
    public void like(@PathVariable String userId, @PathVariable String postId){
        service.like(userId, postId);
    }
}
