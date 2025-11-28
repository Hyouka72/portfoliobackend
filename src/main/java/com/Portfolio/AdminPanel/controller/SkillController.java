package com.Portfolio.AdminPanel.controller;

import com.Portfolio.AdminPanel.model.Skill;
import com.Portfolio.AdminPanel.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    // GET: List all skills
    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.findAll();
    }

    // POST: Add a new skill
    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) {
        return skillService.save(skill);
    }

    // PUT: Update an existing skill
    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skillDetails) {
        Skill existingSkill = skillService.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found for this id :: " + id));

        // Update fields
        existingSkill.setTitle(skillDetails.getTitle());
        existingSkill.setImageSrc(skillDetails.getImageSrc());
        existingSkill.setStyleClass(skillDetails.getStyleClass());

        final Skill updatedSkill = skillService.save(existingSkill);
        return ResponseEntity.ok(updatedSkill);
    }

    // DELETE: Delete a skill
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
