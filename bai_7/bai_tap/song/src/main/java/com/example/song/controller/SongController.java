package com.example.song.controller;

import com.example.song.dto.SongDTO;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    private String home(Model model) {
        model.addAttribute("songDTO", songService.getList());
        return "index";
    }

    @GetMapping("add")
    private String formAdd(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "add";
    }

    @GetMapping("addSong")
    public String save(@Valid @ModelAttribute SongDTO songDTO, BindingResult bindingResult, RedirectAttributes attributes) {
        Song song = new Song();
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "add";
        }
        BeanUtils.copyProperties(songDTO, song);
        songService.save(song);
        attributes.addFlashAttribute("mess", "add new Success");
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    private String formEdit(Model model, @PathVariable int id) {
        Song song = songService.findById(id);
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(song, songDTO);
        model.addAttribute("songDTO", songDTO);
        return "edit";
    }

    @PostMapping("editSong")
    public String edit(@Valid @ModelAttribute SongDTO songDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        System.out.println(song.toString());
        this.songService.save(song);
        return "redirect:/";
    }
}
