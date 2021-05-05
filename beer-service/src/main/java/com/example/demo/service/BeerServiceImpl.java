package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BeerDao;
import com.example.demo.model.BeerModel;
@Service
public class BeerServiceImpl implements BeerService{
	private BeerDao beerDao;
	

	@Autowired
	public BeerServiceImpl(BeerDao beerDao) {
		super();
		this.beerDao = beerDao;
	}


	@Override
	public List<BeerModel> getAllBeer() {
		// TODO Auto-generated method stub
		return  beerDao.findAll();
		}


	@Override
	public BeerModel createBeer(BeerModel beer) {
		// TODO Auto-generated method stub
		return beerDao.save(beer);
	}

	@Override
	public BeerModel getById(Integer id) {
		return beerDao.getOne(id);
	}

	@Override
	public BeerModel deleteByBrreId(Integer id) {
		return beerDao.deleteByBrreId(id);
	}

	@Override
	public BeerModel getByBeerName(String name) {
		return beerDao.getByBeerName(name);
	}


}