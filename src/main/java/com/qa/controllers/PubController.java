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
    public Pub addPub(@RequestBody Pub pub){
        return repository.saveAndFlush(pub);
    }

    @RequestMapping(value = "pubs/", method = RequestMethod.GET)
    public Pub getPub(@PathVariable Long id){
        return repository.findOne(id);
    }


    @RequestMapping(value = "pubs/{id}", method = RequestMethod.DELETE)
    public Pub deletePub(@PathVariable Long id){
        Pub existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }


    @RequestMapping(value = "pubs/{id}",method = RequestMethod.PUT)
    public Pub updateProduct(@PathVariable Long id,@RequestBody Pub pub){
        Pub existing = repository.findOne(id);
        existing.setPub(pub.getPub());
        existing.setUsername(pub.getUsername());
        existing.setDate(pub.getDate());
        existing.setOrderTotal(pub.getOrderTotal());
        existing.setPostcode(pub.getPostcode());
        repository.saveAndFlush(existing);
        return existing;
    }

    @RequestMapping(value = "entrycount", method = RequestMethod.GET)
    public Long countPubs() {
        return repository.count();
    }

    @RequestMapping(value = "getunique/{username}", method = RequestMethod.GET)
    public Long findByUsername(@PathVariable String username) {
        return repository.count();
    }




}
