package com.freddie.spring_boot_mvc_project.repositories;

import com.freddie.spring_boot_mvc_project.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {}
