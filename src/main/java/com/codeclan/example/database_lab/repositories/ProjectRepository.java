package com.codeclan.example.database_lab.repositories;

import com.codeclan.example.database_lab.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
