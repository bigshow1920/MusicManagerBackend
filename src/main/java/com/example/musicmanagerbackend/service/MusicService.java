package com.example.musicmanagerbackend.service;

import com.example.musicmanagerbackend.models.Music;
import com.example.musicmanagerbackend.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MusicService {
    @Autowired // need to check
    private MusicRepository repository;

    public String saveMusic(Music music) {
        if (repository.findByName(music.getName())==null)
        return repository.save(music).toString();
        else return ("This name is duplicated");
    }

    public List<Music> saveMusics(List<Music> musics) {
        return repository.saveAll(musics);
    }

    public List<Music> getMusics() {
        return repository.findAll();
    }

    public Music getMusicById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteMusic(Long id)
    {
        repository.deleteById(id);
        return "Music has been removed";
    }
    @Transactional
    public String removeByName(String name)
    {
       repository.removeByName(name);
       return "Music has been removed";


    }
    public Music updateMusic(Music music)
    {
        Music musicUpdate= repository.findByName(music.getName());
        musicUpdate.setGenre(music.getGenre());
        musicUpdate.setFilename(music.getFilename());
        return repository.save(musicUpdate);
    }
    public String deleteAllMusic()
    {
        repository.deleteAll();
        return "All music has been removed";
    }
}
