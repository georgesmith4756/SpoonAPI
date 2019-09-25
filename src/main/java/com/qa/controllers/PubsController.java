package com.qa.controllers;

import com.qa.repository.PubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.qa.models.Pubs;

import java.util.List;

@RestController
@CrossOrigin
public class PubsController {
    @Autowired
    private PubRepository repository;

    @RequestMapping(value = "publist", method = RequestMethod.GET)
    public List<Pubs> listAllPubs() {
        return repository.findAll();

    }

    @RequestMapping(value = "publist", method = RequestMethod.POST)
    public Pubs addPub(@RequestBody Pubs pub) {
        return repository.saveAndFlush(pub);
    }

    @RequestMapping(value = "publist/", method = RequestMethod.GET)
    public Pubs getPub(@PathVariable Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "publist/{id}", method = RequestMethod.DELETE)
    public Pubs deletePub(@PathVariable Long id) {
        Pubs existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

   // @RequestMapping(value = "pubs/{id}",method = RequestMethod.PUT)
   // public Pubs updateProduct(@PathVariable Long id,@RequestBody Pubs pubs){
   //     Pubs existing = repository.findOne(id);
    //    existing.setPub(pubs.getPub());
    //    repository.saveAndFlush(existing);
    //    return existing;
    //}

    @RequestMapping(value = "pubcount", method = RequestMethod.GET)
    public Long countPubs() {
       return repository.count();
    }
}
