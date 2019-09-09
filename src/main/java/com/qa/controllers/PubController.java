package com.qa.controllers;

import com.qa.repository.PubsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qa.models.Pub;

import java.util.List;

@RestController
@CrossOrigin
public class PubController {

    @Autowired
    private PubsRepository repository;
    @RequestMapping(value = "pubs", method = RequestMethod.GET)
    public List<Pub> listAllPubs(){
        return repository.findAll();

    }

    @RequestMapping(value = "pubs", method = RequestMethod.POST)
    public Pub addNote(@RequestBody Pub note){
        return repository.saveAndFlush(note);
    }

    @RequestMapping(value = "pubs/", method = RequestMethod.GET)
    public Pub getNote(@PathVariable Long id){
        return repository.findOne(id);
    }

    @RequestMapping(value = "pubs/{name}", method = RequestMethod.DELETE)
    public Pub deleteNote(@PathVariable Long id){
        Pub existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }
}
