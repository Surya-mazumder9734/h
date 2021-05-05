package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	private BookService bookService;
	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping("/books/{auhtorName}")
	public ResponseEntity<List<Book>> findBooksByAuthorName(@PathVariable("authorName")  String authorName)
	{
		return ResponseEntity.ok(bookService.findByAuthorName(authorName));
	}
	

	

}
