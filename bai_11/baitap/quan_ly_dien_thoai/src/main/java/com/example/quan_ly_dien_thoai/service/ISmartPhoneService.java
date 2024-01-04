package com.example.quan_ly_dien_thoai.service;

import com.example.quan_ly_dien_thoai.model.SmartPhone;

import java.util.List;
import java.util.Optional;

public interface ISmartPhoneService {
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
