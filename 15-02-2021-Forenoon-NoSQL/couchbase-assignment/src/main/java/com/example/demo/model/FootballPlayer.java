package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Document
public class FootballPlayer {
	
	@Id @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	String id;
	String playerName;
	int numberOfGoals;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getNumberOfGoals() {
		return numberOfGoals;
	}
	public void setNumberOfGoals(int numberOfGoals) {
		this.numberOfGoals = numberOfGoals;
	}
	@Override
	public String toString() {
		return "FootballPlayer [id=" + id + ", playerName=" + playerName + ", numberOfGoals=" + numberOfGoals + "]";
	}
	
	
}
