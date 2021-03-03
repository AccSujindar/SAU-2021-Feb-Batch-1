package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Bookmyshow;

public interface BookmyshowRepository extends CrudRepository<Bookmyshow, String>  {
	
	List<Bookmyshow> findAllByMovieName(String movie);
	List<Bookmyshow> findAllByMovieCity(String movie);

}
