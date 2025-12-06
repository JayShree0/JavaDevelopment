package com.cfs.BookAPI.controller;

import com.cfs.BookAPI.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController                 // Marks this class as a REST Controller
@RequestMapping("/books")       // Base URL for all book-related APIs
public class BookController {

    // In-memory database substitute (used instead of a real DB)
    private Map<Long, Book> bookDb = new HashMap<>();

    /**
     * GET /books
     * Returns a list of all books stored in the in-memory database.
     * ResponseEntity.ok() returns HTTP 200 along with the body.
     */
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(new ArrayList<>(bookDb.values()));
    }

    /**
     * POST /books
     * Creates a new Book.
     * @RequestBody maps incoming JSON to a Book object.
     * Returns 201 CREATED with the created Book in the response body.
     */
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookDb.put(book.getId(), book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    /**
     * GET /books/{id}
     * Fetches a book by its ID.
     * @PathVariable extracts the "id" from the URL.
     * If book not found → returns 404 NOT FOUND.
     * Otherwise → returns 200 OK with the book.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookId(@PathVariable Long id) {
        Book book = bookDb.get(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(book);
    }

    /**
     * PUT /books/{id}
     * Full update of a Book object.
     * PUT requires the complete Book object.
     * If book with ID does not exist → return 404.
     * Otherwise replaces the old Book with the new one.
     * Returns 204 NO CONTENT (standard for successful PUT with no body).
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book existing = bookDb.get(id);

        // If resource doesn't exist, cannot update → return 404.
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Replace full book details
        bookDb.put(id, book);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * PATCH /books/{id}/price
     * Partial update → only updates the 'price' field of a book.
     * PATCH is used for updating specific fields instead of whole object.
     * If book doesn't exist → return 404 NOT FOUND.
     * Otherwise update price and return 204 NO CONTENT.
     */
    @PatchMapping("/{id}/price")
    public ResponseEntity<Void> updatePrice(@PathVariable Long id, @RequestBody Double newPrice) {
        Book existing = bookDb.get(id);

        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Update only the price field (partial update)
        existing.setPrice(newPrice);
        bookDb.put(id, existing);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * DELETE /books/{id}
     * Deletes a book by ID.
     * If book not found → return 404.
     * If delete successful → return 204 NO CONTENT (no body should be returned).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        Book existing = bookDb.remove(id);

        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.noContent().build();
    }
}
