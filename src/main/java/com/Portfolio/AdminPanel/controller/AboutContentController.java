package com.Portfolio.AdminPanel.controller;


import com.Portfolio.AdminPanel.model.AboutContent;
import com.Portfolio.AdminPanel.repository.AboutContentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/about")
public class AboutContentController {
    private final AboutContentRepository aboutContentRepository;

    public AboutContentController(AboutContentRepository aboutContentRepository) {
        this.aboutContentRepository = aboutContentRepository;
    }

    // GET: Always returns the content (creates a default if none exists)
    @GetMapping
    public List<AboutContent> getAboutContent() {
        if (aboutContentRepository.findAll().isEmpty()) {
            // Initialize with default content if the table is empty
            return List.of(aboutContentRepository.save(new AboutContent()));
        }
        return aboutContentRepository.findAll();
    }

    // PUT: Updates the content (only supports ID 1)
    @PutMapping("/1")
    public ResponseEntity<AboutContent> updateAboutContent(@RequestBody AboutContent aboutDetails) {
        AboutContent content = aboutContentRepository.findById(1L).orElse(new AboutContent());

        content.setParagraph1(aboutDetails.getParagraph1());
        content.setParagraph2(aboutDetails.getParagraph2());

        final AboutContent updatedContent = aboutContentRepository.save(content);
        return ResponseEntity.ok(updatedContent);
    }
}
