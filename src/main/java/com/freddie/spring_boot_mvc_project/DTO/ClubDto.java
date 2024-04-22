package com.freddie.spring_boot_mvc_project.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ClubDto {
    private Integer id;
    private String title;
    private String photoUrl;
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}