package com.Portfolio.AdminPanel.service;


import com.Portfolio.AdminPanel.model.AboutContent;
import com.Portfolio.AdminPanel.repository.AboutContentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AboutContentService {
    private final AboutContentRepository aboutContentRepository;

    // Dependency Injection via Constructor
    public AboutContentService(AboutContentRepository aboutContentRepository) {
        this.aboutContentRepository = aboutContentRepository;
    }

    /**
     * Finds the single AboutContent record (expected to have ID 1).
     * Since this is single-record content, it returns a List<AboutContent>
     * to match the structure expected by the AboutContentController's GET method.
     * In a robust solution, you might wrap this in a DTO and return just the object.
     */
    public List<AboutContent> findAll() {
        // Since findAll() returns all records, and we only expect one, this is straightforward.
        return aboutContentRepository.findAll();
    }

    /**
     * Saves or updates the AboutContent record.
     * We use a fixed ID of 1L in the model, so save acts as update if ID is present.
     */
    public AboutContent save(AboutContent content) {
        // Ensure the ID is set to 1L before saving/updating
        content.setId(1L);
        return aboutContentRepository.save(content);
    }

    /**
     * Finds the single AboutContent by its expected ID.
     */
    public Optional<AboutContent> findById(Long id) {
        return aboutContentRepository.findById(id);
    }
}
