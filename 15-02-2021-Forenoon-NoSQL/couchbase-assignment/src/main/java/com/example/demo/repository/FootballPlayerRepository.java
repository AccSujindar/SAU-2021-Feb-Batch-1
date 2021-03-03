package com.example.demo.repository;

import java.util.List;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.FootballPlayer;

public interface FootballPlayerRepository extends CrudRepository<FootballPlayer,String> {
	
	@Query("#{#n1ql.selectEntity} WHERE numberOfGoals > 10 and #{#n1ql.filter}")
	List<FootballPlayer> findByGoalsGreater10(String c);

}
