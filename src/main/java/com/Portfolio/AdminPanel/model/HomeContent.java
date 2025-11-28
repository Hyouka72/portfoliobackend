package com.Portfolio.AdminPanel.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "home_content")
public class HomeContent {

    // Using a fixed ID (1) for single-record configuration tables
    @Id
    private Long id = 1L;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String heroImage;
}
