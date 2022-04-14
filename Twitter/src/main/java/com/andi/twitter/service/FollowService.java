package com.andi.twitter.service;

import com.andi.twitter.model.Follow;
import com.andi.twitter.model.User;
import com.andi.twitter.repository.FollowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowService {
    private final FollowRepository repository;
    private final UserService userService;

    public FollowService(FollowRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public void startFollowing(User user,User follow){
        repository.save(new Follow(user, follow));
    }

    public void startFollowing(String userId, String followId){
        User user = userService.getById(userId);
        User follow = userService.getById(followId);
        repository.save(new Follow(user, follow));
    }

    public void stopFollowing(User user, User follow){
        Follow userAndFollow = repository.findByUserAndFollow(user, follow);
        repository.delete(userAndFollow);
    }

    public void stopFollowing(String userId, String followId){
        User user = userService.getById(userId);
        User follow = userService.getById(followId);
        Follow byUserAndFollow = repository.findByUserAndFollow(user, follow);
        repository.delete(byUserAndFollow);
    }

    public List<User> getFollowing(String userId){
        List<Follow> allByUser = repository.findAllByUser(userService.getById(userId));
        return allByUser.stream()
                .map(Follow::getFollow)
                .collect(Collectors.toList());
    }

    public List<User> getFollowers(String userId){
        List<Follow> allByFollow = repository.findAllByFollow(userService.getById(userId));
        return allByFollow.stream()
                .map(Follow::getUser)
                .collect(Collectors.toList());
    }
}
