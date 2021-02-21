package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FootballPlayer;
import com.example.demo.repository.FootballPlayerRepository;

@RestController
public class FootballPlayerController {
	
	@Autowired
	FootballPlayerRepository fbrepo;
	
	@Autowired
	private CouchbaseTemplate couchbaseTemplate;
	
	@PostMapping("/fbp")
	public FootballPlayer addPlayer(@RequestBody FootballPlayer player)
	{
		return fbrepo.save(player);
	}
	
	@GetMapping("/fbp/{id}")
	public Optional<FootballPlayer> getPlayer(@PathVariable String id)
	{
		return fbrepo.findById(id);
	}
	
	@GetMapping("/fbp")
	public List<FootballPlayer> getPlayers()
	{
		List<FootballPlayer> players = new ArrayList<>();
		fbrepo.findAll().forEach(players::add);
		return players;
	}
	
	@DeleteMapping("/fbp/{id}")
	public Optional<FootballPlayer> deletePlayer(@PathVariable String id)
	{
		Optional<FootballPlayer> player = fbrepo.findById(id);
		fbrepo.deleteById(id);
		return player;
	}
	
	@GetMapping("/fbp/goalsGreaterThanTen")
	public List<FootballPlayer> getPlayersGoalsGreaterThanTen()
	{
		return fbrepo.findByGoalsGreater10("com.example.demo.model.FootballPlayer");
	}
}
