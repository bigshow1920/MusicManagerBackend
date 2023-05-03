package com.example.musicmanagerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MusicManagerBackEndApplication {
    @RequestMapping("index")
    public static void main(String[] args) {
        SpringApplication.run(MusicManagerBackEndApplication.class, args);
    }
}
