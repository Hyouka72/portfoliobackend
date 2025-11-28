package com.Portfolio.AdminPanel.controller;


import com.Portfolio.AdminPanel.model.Project;
import com.Portfolio.AdminPanel.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // GET: List all projects
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    // POST: Add a new project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    // PUT: Update an existing project
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
        Project existingProject = projectService.getProject(id)
                .orElseThrow(() -> new RuntimeException("Project not found for this id :: " + id));

        // Update fields
        existingProject.setName(projectDetails.getName());
        existingProject.setDemoUrl(projectDetails.getDemoUrl());
        existingProject.setCodeUrl(projectDetails.getCodeUrl());
        existingProject.setImageSrc(projectDetails.getImageSrc());

        final Project updatedProject = projectService.saveProject(existingProject);
        return ResponseEntity.ok(updatedProject);
    }

    // DELETE: Delete a project
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

}
