package com.example.quan_ly_dien_thoai.service;

import com.example.quan_ly_dien_thoai.model.SmartPhone;
import com.example.quan_ly_dien_thoai.repository.ISmartPhoneRepository;
import com.example.quan_ly_dien_thoai.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneService implements ISmartPhoneService {
    @Autowired
    private ISmartPhoneRepository iSmartphoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return iSmartphoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return iSmartphoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return iSmartphoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        iSmartphoneRepository.deleteById(id);
    }
}