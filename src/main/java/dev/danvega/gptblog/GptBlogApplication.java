package dev.danvega.gptblog;

import dev.danvega.gptblog.model.Post;
import dev.danvega.gptblog.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GptBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(GptBlogApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository repository) {
		return args -> {
			Post post = new Post();
			post.setTitle("My First Post");
			post.setContent("This is the content of my first post.");
			post.setSlug("my-first-post");
			post.setDateCreated(LocalDateTime.now());
			repository.save(post);

			System.out.println("Inserted a post: " + post);
		};
	}
}
