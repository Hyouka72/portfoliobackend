package com.Portfolio.AdminPanel.controller;
import com.Portfolio.AdminPanel.model.ContactLead;
import com.Portfolio.AdminPanel.service.ContactLeadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/leads")
public class ContactLeadController {
    private final ContactLeadService leadService;

    public ContactLeadController(ContactLeadService leadService) {
        this.leadService = leadService;
    }

    // GET: List all leads (sorted by newest)
    @GetMapping
    public List<ContactLead> getAllLeads() {
        return leadService.findAll();
    }

    // POST: Public endpoint for submitting a contact form (used by Contact.jsx)
    // NOTE: If you change your Contact.jsx to post to this endpoint instead of getform.io,
    // your leads will be saved here automatically.
    @PostMapping
    public ContactLead submitLead(@RequestBody ContactLead lead) {
        // Ensure status and timestamp are set correctly on the backend
        lead.setStatus("New");
        return leadService.save(lead);
    }

    // DELETE: Delete a lead (used by Admin Panel)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        leadService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // PUT: Update lead status (used by Admin Panel: /api/v1/leads/{id}/status)
    @PutMapping("/{id}/status")
    public ResponseEntity<ContactLead> updateLeadStatus(@PathVariable Long id, @RequestBody Map<String, String> statusUpdate) {
        String newStatus = statusUpdate.get("status");
        if (newStatus == null) {
            return ResponseEntity.badRequest().build();
        }

        ContactLead existingLead = leadService.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact Lead not found for this id :: " + id));

        existingLead.setStatus(newStatus);
        final ContactLead updatedLead = leadService.save(existingLead);
        return ResponseEntity.ok(updatedLead);
    }
}
