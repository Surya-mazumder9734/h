package com.example.demo.proxy;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Book;

@FeignClient(name = "book-service")
public interface BookProxy {
	@GetMapping("/books/{authorName}")
	public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable("authorName") String authorName);

}