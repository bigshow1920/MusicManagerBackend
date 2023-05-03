package com.example.musicmanagerbackend.repository;

import com.example.musicmanagerbackend.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
    Music findByName(String name);
    @Modifying
    @Query("delete from Music u where u.name = ?1")
    void removeByName(String name);
}
