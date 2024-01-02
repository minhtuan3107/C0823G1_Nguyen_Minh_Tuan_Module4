package com.example.demo.dto;

import com.example.demo.model.ClassRoom;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private int age;
    @NotBlank
    private String address;
    private ClassRoom classRoom;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO studentDTO = (StudentDTO) target;
        if (studentDTO.getName().equals("")) {
            errors.rejectValue("name", null, "Tên không được để trống");
        }
        if (studentDTO.getAge() < 16) {
            errors.rejectValue("age", null, "Tuổi không đuược dưới 16");
        }
        if (studentDTO.getAddress().equals("")) {
            errors.rejectValue("address", null, "Không được để trống");
        }
        if (studentDTO.getAge() == 0) {
            errors.rejectValue("age", null, "Ngay sinh khong duoc de trong");
        }
    }
}
