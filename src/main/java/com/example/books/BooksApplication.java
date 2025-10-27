package com.example.books;

public class BooksApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(BooksApplication.SpringBootConfig.class, args);
    }

    @org.springframework.boot.autoconfigure.SpringBootApplication
    public static class SpringBootConfig {}

    @org.springframework.web.bind.annotation.RestController
    public static class HealthController {
        @org.springframework.web.bind.annotation.GetMapping("/health")
        public String health() { return "ok"; }
    }

    public static class Book {
        private String title;
        private String author;
        public Book() {}
        public Book(String t, String a) { this.title = t; this.author = a; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }
    }

    @org.springframework.web.bind.annotation.RestController
    @org.springframework.web.bind.annotation.RequestMapping("/api/books")
    public static class BookController {
        private final java.util.List<Book> books = new java.util.ArrayList<>();

        @org.springframework.web.bind.annotation.GetMapping
        public java.util.List<Book> getAll() { return books; }

        @org.springframework.web.bind.annotation.PostMapping
        public Book add(@org.springframework.web.bind.annotation.RequestBody Book book) {
            books.add(book);
            return book;
        }
    }
}
