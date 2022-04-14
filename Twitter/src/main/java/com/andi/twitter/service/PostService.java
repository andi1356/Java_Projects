package com.andi.twitter.service;

import com.andi.twitter.model.Post;
import com.andi.twitter.model.User;
import com.andi.twitter.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository repository;
    private final UserService userService;

    public PostService(PostRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Post create(Post post){
        return repository.save(post);
    }

    public Post getById(String id){
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Post> getAll(){
        return repository.findAll();
    }

    // TODO update

    public List<Post> findAll(){
        return repository.findAll();
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public List<Post> getOwnPosts(String userId){
        List<Post> filteredPosts = findAll().stream()
                .filter(post -> post.getAuthor().equals(userService.getById(userId)))
                .collect(Collectors.toList());
        return filteredPosts;
    }

    public List<Post> findAllPostsFromUsers(List<User> users){
        return users.stream()
                .map(repository::findAllByAuthor)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public Post repost(String userId, String postId){
        User user = userService.getById(userId);
        Post post = repository.getById(postId);
        Post post1 = new Post();
        post1.setAuthor(user);
        post1.setMessage(post.getMessage());
        return repository.save(post1);
    }


}
