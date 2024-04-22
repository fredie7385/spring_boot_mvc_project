package com.freddie.spring_boot_mvc_project.controllers;

import com.freddie.spring_boot_mvc_project.DTO.ClubDto;
import com.freddie.spring_boot_mvc_project.models.Club;
import com.freddie.spring_boot_mvc_project.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.attribute.standard.PresentationDirection;
import java.util.List;

@Controller
//@RequestMapping("/club")
public class ClubController {
    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubList")
    public String ListClubs(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubList";
    }

    @GetMapping("/clubs/new")
    public String CreateClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "createClub";
    }

    @PostMapping("/clubs/new")
    public String saveClubData(@ModelAttribute("club") Club club) {
        clubService.saveClub(club);
        return "redirect:/clubList";
    }
}
