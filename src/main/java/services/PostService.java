package com.codeup.blog;

import services.PostRepository;
import com.codeup.springblog.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private PostRepository postRepo;

    public PostService(PostRepository postRepo) {
        this.postRepo = postRepo;

    }

    public Iterable<Post> findAll() {

        return postRepo.findAll();
    }

    public Post findOne(long id) {

        return postRepo.findOne(id);
    }

    public Post edit(Post post) {
        return postRepo.save(post);
    }

    public void delete(long id) {
        postRepo.delete(id);
    }

}