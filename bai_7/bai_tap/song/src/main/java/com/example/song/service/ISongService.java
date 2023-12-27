package com.example.song.service;

import com.example.song.model.Song;

import java.util.List;

public interface ISongService {
    void save(Song song);

    List<Song> getList();

    Song findById(int id);
}
