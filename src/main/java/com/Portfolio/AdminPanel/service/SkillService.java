package com.Portfolio.AdminPanel.service;

import com.Portfolio.AdminPanel.model.Skill;
import com.Portfolio.AdminPanel.repository.SkillRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public void delete(Long id) {
        skillRepository.deleteById(id);
    }
}