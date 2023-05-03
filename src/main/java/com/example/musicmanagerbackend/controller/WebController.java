package com.example.musicmanagerbackend.controller;

import com.example.musicmanagerbackend.models.Music;
import com.example.musicmanagerbackend.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class WebController {
    @Autowired
    private MusicService musicService;
    @Autowired
    private MusicController musicController;
    @GetMapping("/")
    public String showEditMusic(Model model){
        List<Music> m= musicController.findAllMusic();
        model.addAttribute("listm",m);
        return "index";

    }
    @PostMapping("/new_music")
    public String saveData(@ModelAttribute @RequestBody Music music, HttpServletRequest request) {
        String name=request.getParameter("name");
        String genre=request.getParameter("genre");
        String filename=request.getParameter("filename");
        music= new Music(name,genre,filename);
        musicController.addMusic(music);
        return "redirect:/";
    }
    @PostMapping("/delete_music")
    public String deleteData(@RequestBody @ModelAttribute Music music,HttpServletRequest request)
    {
        String name=request.getParameter("name");
        musicController.deleteMusicByName(name);
        return "redirect:/";
    }
    @PostMapping("/deleteall_music")
    public String deleteallData(@RequestBody @ModelAttribute Music music,HttpServletRequest request)
    {
        musicController.deleteAllMusic();
        return "redirect:/";
    }
    @PostMapping("/edit/{name}")
    public  String showEditForm(@PathVariable("name") String name,Model model,HttpServletRequest request)
    {
        String genre=request.getParameter("genre");
        String filename=request.getParameter("filename");
        System.out.println(name);
        Music music= new Music(name,genre,filename);
        Music musicUpdate =musicController.updateMusic(music);
        return "redirect:/";
    }



}
