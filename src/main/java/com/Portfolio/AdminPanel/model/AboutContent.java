package com.Portfolio.AdminPanel.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "about_content")
public class AboutContent {

    @Id
    private Long id = 1L;

    @Column(columnDefinition = "TEXT")
    private String paragraph1;

    @Column(columnDefinition = "TEXT")
    private String paragraph2;
}
