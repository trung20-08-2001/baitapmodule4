package com.musicplayapp.controller;

import com.musicplayapp.model.Sing;
import com.musicplayapp.service.MusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MusicAppController {
    @Autowired
    MusicAppService musicAppService;
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("/index","sings",musicAppService.getAll());
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/create","sing",new Sing());
    }

    @PostMapping("/create")
    public ModelAndView create(Sing sing, MultipartFile fileSing){
        if(!musicAppService.checkFile(fileSing)){
            return new ModelAndView("/create","message","File invalid");
        }else{
            musicAppService.saveSing(sing,fileSing);
            return new ModelAndView("/index","sings",musicAppService.getAll());
        }
    }
}
