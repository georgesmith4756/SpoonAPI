package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.models.Pub;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PubsRepository extends JpaRepository<Pub, Long> {

    @Query(value = "SELECT COUNT(DISTINCT pub) FROM entries WHERE username = :username", nativeQuery = true)
    Long findByUsername(@Param("username") String username);


}

