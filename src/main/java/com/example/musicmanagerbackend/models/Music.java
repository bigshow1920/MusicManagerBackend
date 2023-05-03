package com.example.musicmanagerbackend.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.transaction.Transactional;

@Getter
@Setter
@Table(name="Music")
@NoArgsConstructor //need to check
@Component
@Data
@ToString
@Entity
public class Music {
    @Id
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;
    @Column(name="genre")
    private String genre;
    @Column(name="filename")
    private String filename;
    public Music(long id,String name,String genre,String filename)
    {
        this.id=id;
        this.name=name;
        this.genre=genre;
        this.filename=filename;
    }
    public Music(String name,String genre, String filename)
    {
        this.name=name;
        this.genre=genre;
        this.filename=filename;
    }

}
