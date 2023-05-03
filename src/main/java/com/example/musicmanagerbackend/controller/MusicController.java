package com.example.musicmanagerbackend.controller;

import com.example.musicmanagerbackend.models.Music;
import com.example.musicmanagerbackend.repository.MusicRepository;
import com.example.musicmanagerbackend.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {
    @Autowired
    private MusicService musicService;
     @Autowired
     private MusicRepository musicRepository;
    @PostMapping("/music/addMusic")
    public String addMusic(@RequestBody Music music)
    {
        return musicService.saveMusic(music);
    }

    @GetMapping("/music")
    public List<Music> findAllMusic()
    {
        return musicService.getMusics();
    }
    @PutMapping("/music/update")
    public Music updateMusic(@RequestBody Music music)
    {
        return musicService.updateMusic(music);
    }
    @DeleteMapping("/music/delete/{id}")
    public String deleteMusic(@PathVariable Long id)
    {
        return musicService.deleteMusic(id);
    }
    @DeleteMapping("/music/deleteByName/{name}")
    public String deleteMusicByName(@PathVariable String name)
    {
       musicService.removeByName(name);
       return "Music has been removed";
    }
    @DeleteMapping("/music/deleteAll")
    public  String deleteAllMusic()
    {
        return musicService.deleteAllMusic();
    }




}
