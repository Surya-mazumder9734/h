package com.example.demo.proxy;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.publication;

@FeignClient(name = "publication-service")
public interface PublicationProxy {
	@GetMapping("/publication/{authorName}")
	public ResponseEntity<List<publication>> findPublicationsByAuthor(@PathVariable("authorName") String authorName);

}