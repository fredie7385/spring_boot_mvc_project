package com.freddie.spring_boot_mvc_project.controllers;

import com.freddie.spring_boot_mvc_project.DTO.ClubDto;
import com.freddie.spring_boot_mvc_project.models.Club;
import com.freddie.spring_boot_mvc_project.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/clubs")
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
    public String saveClubForm(@ModelAttribute("club") Club club) {
        clubService.saveClub(club);
        return "redirect:/clubList";
    }

    @GetMapping("/clubs/{clubId}/update")
    public String updateClubForm(@PathVariable("clubId") Long clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "updateClub";
    }

    @PostMapping("/clubs/{clubId}/update")
    public String updateClubFormData(@PathVariable("clubId") Long clubId, @ModelAttribute("club") ClubDto club) {
        club.setId(Math.toIntExact(clubId));
        clubService.updateClub(club);
        return "redirect:/clubs";
    }
}
