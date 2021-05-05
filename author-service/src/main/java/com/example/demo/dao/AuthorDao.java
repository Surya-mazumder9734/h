package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Author;
@Repository
public interface AuthorDao extends JpaRepository<Author, Integer>  {

}
