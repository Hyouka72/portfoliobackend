package com.Portfolio.AdminPanel.repository;

import com.Portfolio.AdminPanel.model.ContactLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactLeadRepository extends JpaRepository<ContactLead, Long> {
}
