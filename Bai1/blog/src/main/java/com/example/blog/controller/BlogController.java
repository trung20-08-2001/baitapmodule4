package com.example.blog.controller;

import com.example.blog.dao.HistoryDeletePostDAO;
import com.example.blog.dao.PostDAO;
import com.example.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {
    @Autowired
    PostDAO postDAO;
    @Autowired
    HistoryDeletePostDAO historyDeletePostDAO;

    @GetMapping("/index")
    public String displayAll(Model model) {
        model.addAttribute("postList", postDAO.getAllPost());
        return "/index";
    }

    @GetMapping("/detail")
    public String displayDetail(@RequestParam int idPost, Model model) {
        model.addAttribute("post", postDAO.findPostById(idPost));
        return "/detail";
    }

    @GetMapping("/edit")
    public String update(@RequestParam int idPost, Model model) {
        model.addAttribute("post", postDAO.findPostById(idPost));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Post post) {
        postDAO.updatePost(post);
        return "redirect:/index";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute Post post) {
        postDAO.addPost(post);
        return "redirect:/index";
    }

    @GetMapping("/create")
    public String add() {
        return "/create";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int idPost) {
        postDAO.deletePost(idPost);
        return "redirect:/index";
    }

    @GetMapping("/historyDelete")
    public String displayHistory(Model model) {
        model.addAttribute("historyDeletedList", historyDeletePostDAO.getDeletePost());
        return "/historyDelete";
    }

    @GetMapping("/restore")
    public String restore(int idPost) {
        postDAO.restore(idPost);
        historyDeletePostDAO.restore(idPost);
        return "redirect:/index";
    }
}
