package com.example.demo.service;

import com.example.demo.model.ClassRoom;

import java.util.List;

public interface IClassRomService {
    List<ClassRoom> getList();

    void save(ClassRoom classRoom);

    ClassRoom findMyId(int id);
}
