package com.freddie.spring_boot_mvc_project.services;

import com.freddie.spring_boot_mvc_project.DTO.ClubDto;
import com.freddie.spring_boot_mvc_project.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    void saveClub(Club club);
}
