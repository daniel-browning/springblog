package services;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Service;


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

    public Post saveOrUpdate(Post post) {
        return postRepo.save(post);
    }

    public void delete(long id) {
        postRepo.delete(id);
    }

}