package com.example.demo.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements Validator {
    @Id
    private int id;
    private String name;
    private String gender;
    private int age;
    private String address;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO studentDTO = (StudentDTO) target;
        if (studentDTO.getName().equals("")){
            errors.rejectValue("name",null,"Tên không được để trống");
        }else if(studentDTO.getAge() > 16){
            errors.rejectValue("age",null,"Tuổi không đuược dưới 16");
        }
        if (studentDTO.getAddress().equals("")) {
            errors.rejectValue("address",null,"Không được để trống");
        }
    }
}
