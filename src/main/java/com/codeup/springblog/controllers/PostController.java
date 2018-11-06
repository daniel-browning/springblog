package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.UserRepo;

@SpringBootApplication
@ComponentScan("services")
@EnableJpaRepositories("services")
@Controller
public class PostController {

    //    List<Post> posts = new ArrayList<>();
    private PostService postService;
    private UserRepo userRepo;

    public PostController(PostService service, UserRepo userRepo){
        this.postService = service;
        this.userRepo = userRepo;
    }

    //    GET	/ads	ads index page
    @GetMapping("/posts")
    public String postsIndex(Model vModel) {
        vModel.addAttribute("posts", postService.findAll());
        return "posts/index";
    }

    //    GET	/ads/{id}	view an individual post
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model vModel) {
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/show";
    }

    //    GET	/ads/create	view the form for creating a post
    @GetMapping("/posts/create")
    public String sendPostForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }


    //    POST	/ads/create	create a new post
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        post.setUser(userRepo.findOne(1L));
        postService.saveOrUpdate(post);
        return "redirect:/posts/"+ post.getId();
    }

    //    GET	/ads/create	view the form for creating a post
    @GetMapping("/posts/{id}/update")
    public String showUpdateForm(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/edit";
    }

    //    POST	/ads/create	create a new post
    @PostMapping("/posts/{id}/update")
    public String updatePost(@ModelAttribute Post post) {
        postService.saveOrUpdate(post);
        return "redirect:/posts/"+ post.getId();
    }

    @PostMapping("/posts/{id}/delete")
    public void rmPost(@PathVariable long id) {
        postService.delete(id);
    }


}