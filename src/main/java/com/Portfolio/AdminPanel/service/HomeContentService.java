package com.Portfolio.AdminPanel.service;

import com.Portfolio.AdminPanel.model.HomeContent;
import com.Portfolio.AdminPanel.repository.HomeContentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HomeContentService {
    private final HomeContentRepository homeContentRepository;

    // Dependency Injection via Constructor
    public HomeContentService(HomeContentRepository homeContentRepository) {
        this.homeContentRepository = homeContentRepository;
    }

    /**
     * Finds all HomeContent records. Since this entity is intended to hold
     * a single record (ID 1), it effectively retrieves the main home content.
     */
    public List<HomeContent> findAll() {
        return homeContentRepository.findAll();
    }

    /**
     * Saves or updates the HomeContent record.
     * Ensures the ID is set to 1L before saving/updating.
     */
    public HomeContent save(HomeContent content) {
        // Enforce the fixed ID of 1L for single-record update logic
        content.setId(1L);
        return homeContentRepository.save(content);
    }

    /**
     * Finds the single HomeContent by its expected ID.
     */
    public Optional<HomeContent> findById(Long id) {
        return homeContentRepository.findById(id);
    }
}
