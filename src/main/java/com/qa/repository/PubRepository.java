package com.qa.repository;

import com.qa.models.Pub;
import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.models.Pubs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PubRepository extends JpaRepository<Pubs, Long> {


}

