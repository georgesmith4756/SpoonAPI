package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.models.Pub;

public interface PubsRepository extends JpaRepository<Pub, Long> {

}

