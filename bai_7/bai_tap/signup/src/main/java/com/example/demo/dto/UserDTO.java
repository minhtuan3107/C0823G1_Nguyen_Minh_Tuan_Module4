package com.example.demo.dto;

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
public class UserDTO implements Validator {
    private String firstName;
    private String lastName;
    private String phone;
    private int age;
    private String email;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
       if(userDTO.getAge() < 18){
           errors.rejectValue("age",null,"Vui lòng nhập tuổi trên 18");
       }if (userDTO.getFirstName().equals("")){
           errors.rejectValue("firstName",null,"Vui lòng nhập không được để trống");
        }else if (userDTO.getFirstName().length() < 5 || userDTO.getFirstName().length() > 46){
           errors.rejectValue("firstName",null,"Vui lòng nhập trên 5 kí tự và dưới 46 kí tự");
        }if (userDTO.getLastName().equals("")){
           errors.rejectValue("lastName",null,"Vui lòng nhập không được để trống");
        }else if(userDTO.getLastName().length() < 5 || userDTO.getLastName().length() > 46){
           errors.rejectValue("lastName", null, "Vui lòng nhập trên 5 kí tự và dưới 46 kí tự");
        }if (userDTO.getPhone().equals("")){
           errors.rejectValue("phone",null,"Vui lòng nhập không được để trống");
        }else if (!(userDTO.getPhone().matches("(84|0[3|5|7|8|9])+([0-9]{8})"))){
           errors.rejectValue("phone",null, "Vui lòng nhập đúng định dạng số điện thoại");
        }if (userDTO.getEmail().equals("")){
           errors.rejectValue("email",null,"Vui lòng nhập không được để trống");
        }else if (!(userDTO.getEmail().matches("^[a-zA-Z0-9_!#$%&’*+=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))){
           errors.rejectValue("email",null,"Vui lòng nhập đúng định dạng email");
        }
    }
}
