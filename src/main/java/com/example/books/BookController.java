package com.example.books;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Book> all() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book b) {
        Book saved = repo.save(b);
        return ResponseEntity.ok(saved);
    }
}
