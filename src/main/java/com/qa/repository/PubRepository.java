package com.qa.repository;

import com.qa.models.Pub;
import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.models.Pubs;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PubRepository extends JpaRepository<Pubs, Long> {

   // @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
    @Query(value = "SELECT COUNT(DISTINCT pub) FROM entries WHERE username = ?1", nativeQuery = true)
    Pubs findByUsername(String username);

}

