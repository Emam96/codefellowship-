package codefellowship.example.codefellowship.controllers;

import codefellowship.example.codefellowship.models.ApplicationUser;
import codefellowship.example.codefellowship.repos.ApplicationUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.security.Principal;

import java.util.Optional;

@Controller
public class Index {

    @Autowired
    ApplicationUserRepo repo;

//    @GetMapping("/")
//    public String getIndex(){
//
//        return "index";
//
//    }


    @GetMapping("/")
    public  String addAlbum(Model model, Principal principal){

        model.addAttribute("username", principal.getName());
        return "index";
    }



    @GetMapping("/profile/{username}")
    public String getProfile(Model model, @PathVariable String username){
    ApplicationUser data =  repo.findByUsername(username);
    model.addAttribute("user", data);
        return "profile";
}








}
