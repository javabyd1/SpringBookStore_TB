package com.sda.springstarter.demo.repository;

import com.sda.springstarter.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    public Optional<Author> findById(int id);
    public Author findByName(String name);
}
