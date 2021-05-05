package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BeerModel;
import com.example.demo.service.BeerService;

@RestController
public class BeerController {

	private Environment environment;
	private BeerService beerService;
	@Autowired
	public BeerController(Environment environment, BeerService beerService) {
		super();
		this.environment = environment;
		this.beerService = beerService;
	}
	@GetMapping("/")
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("app is up listining on port: "+environment.getProperty("local.server.port"));
	}
	@GetMapping("/beers")
	public ResponseEntity<List<BeerModel>> getAllBeer()
	{
		return ResponseEntity.status(HttpStatus.OK).body(beerService.getAllBeer());
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody BeerModel beer){
        beerService.createBeer(beer);
        return new ResponseEntity("saved successfully", HttpStatus.OK);
    }

	@RequestMapping(value="/delete/{brreId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity delete(@PathVariable Integer id){
		beerService.deleteByBrreId(id);
		return new ResponseEntity("deleted successfully", HttpStatus.OK);

	}
	@RequestMapping(value = "/getById/{brreId}",method = RequestMethod.GET)
	public ResponseEntity getById(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(beerService.getById(id));
	}
	@RequestMapping(value = "/findName/{beerName}",method = RequestMethod.GET)
	public ResponseEntity getByName(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.OK).body(beerService.getByBeerName(name));
	}




}