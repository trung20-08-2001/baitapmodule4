package com.appplaymusicsimp.controller;


import com.appplaymusicsimp.dao.SongDAO;
import com.appplaymusicsimp.model.Song;
import com.appplaymusicsimp.service.MusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MusicAppController {
    @Autowired
    MusicAppService musicAppService;

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("/index","songs", musicAppService.getAll());
    }

    @GetMapping("/create")
    public String  create(Model model){
        model.addAttribute("type","/create");
        model.addAttribute("song",new Song());
        return "/create";
    }


    @PostMapping("/create")
    public String create(Song song, MultipartFile fileSong, Model model){
        if(!musicAppService.checkFile(fileSong)){
            model.addAttribute("message","File invalid");
            model.addAttribute("song",song);
            return "/create";
        }else{
            musicAppService.save(song,fileSong);
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        musicAppService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(Song song,MultipartFile fileSong,Model model){
        if(!musicAppService.checkFile(fileSong)){
            model.addAttribute("message","File invalid");
            model.addAttribute("song",song);
            return "/create";
        }else{
            musicAppService.edit(song,fileSong);
            return "redirect:/";
        }
    }


    @GetMapping("/edit")
    public String edit(@RequestParam int id,Model model){
        Song song=musicAppService.findById(id);
        model.addAttribute("song",song);
        model.addAttribute("type","/edit");
        return "/create";
    }

}
