package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AuthorDao;
import com.example.demo.model.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
	private AuthorDao authorDao;

	@Autowired
	public AuthorServiceImpl(AuthorDao authorDao) {
		super();
		this.authorDao = authorDao;
	}

	@Override
	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		return authorDao.findAll();
	}

}