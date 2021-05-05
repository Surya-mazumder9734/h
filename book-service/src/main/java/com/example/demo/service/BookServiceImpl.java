package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
@Service
public class BookServiceImpl implements BookService{

	private BookDao bookDao;

	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}
	
	
	@Override
	public List<Book> findByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		return bookDao.findByAuthorName(authorName);
	}
	

}
