package com.Portfolio.AdminPanel.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String imageSrc;

    @Column(columnDefinition = "TEXT")
    private String demoUrl;

    @Column(columnDefinition = "TEXT")
    private String codeUrl;

}
