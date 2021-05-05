package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BeerModel;

public interface BeerService {
	
	public List<BeerModel> getAllBeer();
	public BeerModel createBeer(BeerModel beer);
	public BeerModel getById(Integer id);
	public BeerModel deleteByBrreId(Integer id);
	 public BeerModel getByBeerName(String name);



}