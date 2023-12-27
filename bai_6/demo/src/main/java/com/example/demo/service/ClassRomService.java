package com.example.demo.service;

import com.example.demo.model.ClassRoom;
import com.example.demo.repository.ClassRomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassRomService implements IClassRomService {
    @Autowired
    private ClassRomRepository classRomRepository;

    @Override
    public List<ClassRoom> getList() {
        return classRomRepository.findAll();
    }

    @Override
    public void save(ClassRoom classRoom) {
        classRomRepository.save(classRoom);
    }

    @Override
    public ClassRoom findMyId(int id) {
        return classRomRepository.findById(id).get();
    }
}
