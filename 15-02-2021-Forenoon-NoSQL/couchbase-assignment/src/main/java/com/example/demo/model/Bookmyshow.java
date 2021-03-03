package com.example.demo.model;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Document	
public class Bookmyshow {

	@Id @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	String id;
	String movieName;
	String movieCity;
	Date date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieCity() {
		return movieCity;
	}
	public void setMovieCity(String movieCity) {
		this.movieCity = movieCity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Bookmyshow [Id=" + id + ", movieName=" + movieName + ", movieCity=" + movieCity + ", date=" + date
				+ "]";
	}
	
	
	
}
