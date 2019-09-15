package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.models.Pubs;

public interface PubRepository extends JpaRepository<Pubs, Long> {

}

