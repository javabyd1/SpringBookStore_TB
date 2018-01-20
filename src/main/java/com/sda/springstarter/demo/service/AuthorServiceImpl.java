package com.sda.springstarter.demo.service;

import com.sda.springstarter.demo.exception.BookNotFoundException;
import com.sda.springstarter.demo.interfaces.AuthorService;
import com.sda.springstarter.demo.model.Author;
import com.sda.springstarter.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    public AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public Author getAuthorById(int id) {
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException(id)
        );
        return author;
    }

    public Author getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }
}
