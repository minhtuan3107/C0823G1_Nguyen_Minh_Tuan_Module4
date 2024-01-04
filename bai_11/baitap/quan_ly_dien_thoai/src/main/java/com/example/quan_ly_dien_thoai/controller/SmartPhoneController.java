package com.example.quan_ly_dien_thoai.controller;

import com.example.quan_ly_dien_thoai.model.SmartPhone;
import com.example.quan_ly_dien_thoai.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/smartphones")
public class SmartPhoneController {
    @Autowired
    private ISmartPhoneService smartphoneService;

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> listSmartphones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping()
    public ResponseEntity<SmartPhone> deleteSmartphone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(smartphoneService.save(smartPhone), HttpStatus.OK);
    }
}