package com.andi.twitter;

import com.andi.twitter.model.Post;
import com.andi.twitter.model.User;
import com.andi.twitter.repository.PostRepository;
import com.andi.twitter.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class TwitterApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(TwitterApplication.class, args);

//		Post post = context.getBean(Post.class);
//		User user = context.getBean(User.class);
//
//		UserRepository userRepository = context.getBean(UserRepository.class);
//		PostRepository postRepository = context.getBean(PostRepository.class);
//
//
////		user.setId("drew");
//		user.setEmail("raa@gmail.com");
//		user.setFirstname("Andi");
//		user.setLastname("Robu");
//		user.setPassword("pass");
//		userRepository.save(user);
//
////		post.setId("post01");
//		post.setAuthor(user);
//		post.setMessage("Hi! I use twitter.");
//		post.setTimestamp(LocalDateTime.now());
//		postRepository.save(post);
//
////		user.getPosts().add(post);
////		userRepository.save(user);
//
//		System.out.println(post);
//		System.out.println(user);

	}

}
