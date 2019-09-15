package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.models.Pub;

public interface PubRepository extends JpaRepository<Pub, Long> {

}

