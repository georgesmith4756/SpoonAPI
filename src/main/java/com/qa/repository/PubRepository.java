package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.models.Pubs;
import org.springframework.data.jpa.repository.Query;

public interface PubRepository extends JpaRepository<Pubs, Long> {

    @Query("SELECT COUNT(DISTINCT e.pubs) FROM entries e WHERE e.username = ?1" )
    Pubs findByUsername(String username);
}

