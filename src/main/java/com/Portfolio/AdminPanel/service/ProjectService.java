package com.Portfolio.AdminPanel.service;


import com.Portfolio.AdminPanel.model.Project;
import com.Portfolio.AdminPanel.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> getProject(Long id) {
        return projectRepository.findById(id);
    }
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
