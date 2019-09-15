package com.qa.controllers;

import com.qa.repository.PubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qa.models.Pub;

import java.util.List;

@RestController
@CrossOrigin
public class PubsController {
    @Autowired
    private PubRepository repository;

    @RequestMapping(value = "publist", method = RequestMethod.GET)
    public List<Pub> listAllPubs() {
        return repository.findAll();
    }

    @RequestMapping(value = "publist", method = RequestMethod.POST)
    public Pub addPub(@RequestBody Pub pub) {
        return repository.saveAndFlush(pub);
    }

    @RequestMapping(value = "publist/", method = RequestMethod.GET)
    public Pub getPub(@PathVariable Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "publist/{id}", method = RequestMethod.DELETE)
    public Pub deletePub(@PathVariable Long id) {
        Pub existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }
}
