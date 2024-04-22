package com.freddie.spring_boot_mvc_project.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ClubDto {
    private Integer id;
    @NotEmpty(message = "Field Should Not Be Empty!")
    private String title;
    @NotEmpty(message = "Field Should Not Be Empty!")
    private String photoUrl;
    @NotEmpty(message = "Field Should Not Be Empty!")
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}