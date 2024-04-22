package com.freddie.spring_boot_mvc_project.services;

import com.freddie.spring_boot_mvc_project.DTO.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    void saveClub(ClubDto club);

    ClubDto findClubById(Long clubId);

    void updateClub(ClubDto club);

    void delete(Long clubId);
}
