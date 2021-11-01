package codefellowship.example.codefellowship.controllers;

import codefellowship.example.codefellowship.models.ApplicationUser;
import codefellowship.example.codefellowship.models.Post;
import codefellowship.example.codefellowship.repos.ApplicationUserRepo;
import codefellowship.example.codefellowship.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.security.Principal;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class Index {

    @Autowired
    ApplicationUserRepo repo;

    @Autowired
    PostRepo postRepo;


    @GetMapping("/")
    public String getHome(Principal principal, Model model) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "index";
    }



    @GetMapping("/profile/{username}")
    public String getProfile(Model model, @PathVariable String username){
    ApplicationUser data =  repo.findByUsername(username);
    model.addAttribute("user", data);
        return "profile";
}


    @GetMapping("/profile")
    public String getUserPosts(Model model, @PathVariable String username){
        ApplicationUser data =  repo.findByUsername(username);
        model.addAttribute("posts", data.getPosts());
        return "profile";
    }



    @GetMapping("/index")
    public  String addAlbum(Model model){
        List<Post> data = (ArrayList<Post>) postRepo.findAll();
        model.addAttribute("posts", data);
        return "index";
    }

//    @PostMapping("/post")
//    public RedirectView greetingSubmit(@ModelAttribute Post post, Model model) {
//        model.addAttribute("post", post);
////        model.addAttribute("time", Instant.now().toString());
//        postRepo.save(post);
//        return new RedirectView("/index");
//    }


    @PostMapping("/post")
    public RedirectView addPostToDB(Model model , @RequestParam String body, Principal principal) {

        ApplicationUser user =  repo.findByUsername(principal.getName());
        model.addAttribute("user", user);
        Post post = new Post(body,user);
        postRepo.save(post);
        return new RedirectView("/index");

    }

    }


