package com.Portfolio.AdminPanel.controller;
import com.Portfolio.AdminPanel.model.HomeContent;
import com.Portfolio.AdminPanel.repository.HomeContentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/home")
public class HomeContentController {

    private final HomeContentRepository homeContentRepository;

    public HomeContentController(HomeContentRepository homeContentRepository) {
        this.homeContentRepository = homeContentRepository;
    }

    // GET: Always returns the content (creates a default if none exists)
    @GetMapping
    public List<HomeContent> getHomeContent() {
        if (homeContentRepository.findAll().isEmpty()) {
            // Initialize with default content if the table is empty
            return List.of(homeContentRepository.save(new HomeContent()));
        }
        return homeContentRepository.findAll();
    }

    // PUT: Updates the content (only supports ID 1)
    @PutMapping("/1")
    public ResponseEntity<HomeContent> updateHomeContent(@RequestBody HomeContent homeDetails) {
        HomeContent content = homeContentRepository.findById(1L).orElse(new HomeContent());

        content.setTitle(homeDetails.getTitle());
        content.setDescription(homeDetails.getDescription());
        content.setHeroImage(homeDetails.getHeroImage());

        final HomeContent updatedContent = homeContentRepository.save(content);
        return ResponseEntity.ok(updatedContent);
    }
}
