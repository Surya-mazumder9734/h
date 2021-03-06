package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BeerModel;
@Repository
public interface BeerDao extends JpaRepository<BeerModel, Integer> {
     @Query
      BeerModel deleteByBrreId(Integer id);
      @Query
      BeerModel getByBeerName(String name);


}
