package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.BookmyshowRepository;
import com.example.demo.model.Bookmyshow;

@RestController
public class BookmyshowController {

	
	@Autowired
	BookmyshowRepository bmsrepo;
	
	@PostMapping("/bms")
	public Bookmyshow addMovie(@RequestBody Bookmyshow movie)
	{
		return bmsrepo.save(movie);
	}
	
	@GetMapping("/bms")
	public List<Bookmyshow> getMovies()
	{
		List<Bookmyshow> movies = new ArrayList<>();
		bmsrepo.findAll().forEach(movies::add);
		return movies;
	}
	@GetMapping("bms/{id}")
	public Optional<Bookmyshow> getmovie(@PathVariable String id)
	{
		return bmsrepo.findById(id);
	}
	
	@DeleteMapping("bms/{id}")
	public Optional<Bookmyshow> deleteMovie(@PathVariable String id)
	{
		Optional<Bookmyshow> bms = bmsrepo.findById(id);
		bmsrepo.deleteById(id);
		return bms;
	}
	
	@GetMapping("bms/movie/{name}")
	public List<Bookmyshow> getMovieByName(@PathVariable String name)
	{
		List<Bookmyshow> movies = new ArrayList<>();
		bmsrepo.findAllByMovieName(name).forEach(movies::add);
		return movies;
	}
	
	@GetMapping("bms/city/{name}")
	public List<Bookmyshow> getMovieByCity(@PathVariable String name)
	{
		List<Bookmyshow> movies = new ArrayList<>();
		bmsrepo.findAllByMovieCity(name).forEach(movies::add);
		return movies;
	}

}
