package com.Portfolio.AdminPanel.repository;

import com.Portfolio.AdminPanel.model.AboutContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutContentRepository extends JpaRepository<AboutContent, Long> {
}
