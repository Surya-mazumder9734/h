package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;
import com.example.demo.proxy.BookProxy;
import com.example.demo.proxy.PublicationProxy;
import com.example.demo.service.AuthorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class AuthorController {

	private AuthorService authorService;
	private BookProxy bookProxy;
	private PublicationProxy publicationProxy;

	@Autowired
	public AuthorController(AuthorService authorService, BookProxy bookProxy,PublicationProxy publicationProxy) {
		super();
		this.authorService = authorService;
		this.bookProxy = bookProxy;
		this.publicationProxy =publicationProxy;
	}

	@GetMapping("/authors")
	public ResponseEntity<List<Author>> getAllAuthors() {
		return ResponseEntity.ok(authorService.getAllAuthors());
	}

	@GetMapping("/authors/{authorName}")
	@HystrixCommand(fallbackMethod = "myFallBack")
	public ResponseEntity<?> getAllBooksByAuthor(@PathVariable("authorName") String authorName) {

		return bookProxy.findBooksByAuthor(authorName);
	}

	public ResponseEntity<?> myFallBack(@PathVariable("authorName") String authorName)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("book-service is down.");
	}
	
	@GetMapping("pubAuthor/{authorName}")
	@HystrixCommand(fallbackMethod = "myFallBack")
	public ResponseEntity<?>getAllPublicationsByAuthor(@PathVariable("authorName")String authorName){
		return publicationProxy.findPublicationsByAuthor(authorName);
	}

}