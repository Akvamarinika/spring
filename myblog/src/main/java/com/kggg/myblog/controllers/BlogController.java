package com.kggg.myblog.controllers;

import com.kggg.myblog.models.Post;
import com.kggg.myblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String announce, @RequestParam String full_text, Model model){
        Post post = new Post(title, announce, full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{post_id}")
    public String blogDetails(@PathVariable(value = "post_id") long postId, Model model){
        if (!postRepository.existsById(postId)){
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(postId);
        List<Post> posts = new ArrayList<>();
        post.ifPresent(posts::add);
        //post.ifPresent(p -> posts.add(p));
        model.addAttribute("post", posts);
        return "blog-details";
    }

    @GetMapping("/blog/{post_id}/edit")
    public String blogEdit(@PathVariable(value = "post_id") long postId, Model model){
        if (!postRepository.existsById(postId)){
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(postId);
        List<Post> posts = new ArrayList<>();
        post.ifPresent(posts::add);
        //post.ifPresent(p -> posts.add(p));
        model.addAttribute("post", posts);
        return "blog-edit";
    }

    @PostMapping("/blog/{post_id}/edit")
    public String blogPostUpdate(@PathVariable(value = "post_id") long postId, @RequestParam String title, @RequestParam String announce, @RequestParam String full_text, Model model){
        Post post = postRepository.findById(postId).orElseThrow(IllegalStateException::new);
       /* Post post = postRepository.findById(postId).<RuntimeException>orElseThrow(() -> {
            throw new AssertionError();
        });*/
        post.setTitle(title);
        post.setAnnouncement(announce);
        post.setFullText(full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

}
