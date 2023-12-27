package com.example.song.dto;

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
public class SongDTO implements Validator {
    private int id;
    private String nameSong;
    private String authorSong;
    private String typeSong;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        if (songDTO.getNameSong().equals("")) {
            errors.rejectValue("nameSong", null, "Tên nhạc không được để trống");
        } else if (songDTO.getNameSong().length() > 800) {
            errors.rejectValue("nameSong", null, "Không được vượt quá 800 kí tự");
        } else if (!(songDTO.getNameSong().matches("^[a-zA-Z0-9]{1,}$"))) {
            errors.rejectValue("nameSong", null, "Không được nhập kí tự đặc biệt");
        }
        if (songDTO.getAuthorSong().equals("")) {
            errors.rejectValue("authorSong", null, "Không được để trống");
        } else if (songDTO.getAuthorSong().length() > 300) {
            errors.rejectValue("authorSong", null, "Không được quá 300 kí tự");
        } else if (!(songDTO.getAuthorSong().matches("^[a-zA-Z0-9]{1,}$"))) {
            errors.rejectValue("authorSong", null, "Không được nhập kí tự đặc biệt");
        }
        if (songDTO.getTypeSong().equals("")) {
            errors.rejectValue("typeSong", null, "Không được để trống");
        } else if (songDTO.getTypeSong().length() > 1000) {
            errors.rejectValue("typeSong", null, "Không được quá 1000 kí tự");
        } else if (!(songDTO.getTypeSong().matches("^[a-zA-Z0-9\\\\\\\\,]{1,}$"))) {
            errors.rejectValue("typeSong", null, "Ngoại trừ dấu phẩy “,” , các ký tự đặc biệt còn lại không được phép nhap");
        }
    }
}
