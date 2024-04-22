package com.freddie.spring_boot_mvc_project.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Annotations for Lombok to generate boilerplate code
@Data // Generates getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Generates a constructor with no arguments
@AllArgsConstructor // Generates a constructor with all fields as arguments
@Builder // Generates a builder pattern for easier object creation
// Annotations for JPA entity mapping
@Entity // Marks this class as a JPA entity
@Table(name = "Club") // Maps this entity to the "Club" database table
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String photoUrl;
    private String description;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

}
