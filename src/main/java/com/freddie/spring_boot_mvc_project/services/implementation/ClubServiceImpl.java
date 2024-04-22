package com.freddie.spring_boot_mvc_project.services.implementation;

import com.freddie.spring_boot_mvc_project.DTO.ClubDto;
import com.freddie.spring_boot_mvc_project.models.Club;
import com.freddie.spring_boot_mvc_project.repositories.ClubRepository;
import com.freddie.spring_boot_mvc_project.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(this::mapToClubDto).collect(Collectors.toList());
    }

    @Override
    public void saveClub(Club club) {
        clubRepository.save(club);
    }


    private ClubDto mapToClubDto(Club club) {
        ClubDto clubDto;
        clubDto = ClubDto.builder().id(club.getId()).title(club.getTitle()).photoUrl(club.getPhotoUrl()).description(club.getDescription()).createdOn(club.getCreatedOn()).updatedOn(club.getUpdatedOn()).build();
        return clubDto;

    }
}
