package com.Portfolio.AdminPanel.service;

import com.Portfolio.AdminPanel.model.ContactLead;
import com.Portfolio.AdminPanel.repository.ContactLeadRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactLeadService {
    private final ContactLeadRepository leadRepository;

    public ContactLeadService(ContactLeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public List<ContactLead> findAll() {
        // Sort by submittedAt descending to show newest leads first
        return leadRepository.findAll(Sort.by(Sort.Direction.DESC, "submittedAt"));
    }

    public Optional<ContactLead> findById(Long id) {
        return leadRepository.findById(id);
    }

    public ContactLead save(ContactLead lead) {
        return leadRepository.save(lead);
    }

    public void delete(Long id) {
        leadRepository.deleteById(id);
    }
}
