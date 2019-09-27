package com.qa.controllers;

import com.qa.models.Pub;
import com.qa.models.Pubs;
import com.qa.repository.PubRepository;
import com.qa.repository.PubsRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


public class PubsControllerTest {

    @InjectMocks
    private PubsController pubsController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Mock
    private PubRepository repository;

    @Test
    public void testHomepage(){
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/pubs", String.class )).contains("pub");
    }

    @Test
    public void testGetAllPubs(){
        List<Pubs> pubsList = new ArrayList<>();
        Pubs pubs = new Pubs("The QA Tavern");
        pubsController.listAllPubs();
    }
    @Test
    public void testPubsGetRequest(){
        List<Pubs> publist = new ArrayList<>();
        Pubs pub1 = new Pubs("The QA Tavern");
        Pubs pub2 = new Pubs("The Salford");

        publist.add(pub1);
        publist.add(pub2);

        when(repository.findAll()).thenReturn(publist);
        assertEquals(pubsController.listAllPubs().get(0).getPub(), "The QA Tavern");
        assertEquals(pubsController.listAllPubs().get(1).getPub(), "The Salford");


    }

    @Test
    public void testPubsPostRequest(){
        Pubs pub = new Pubs("The QA Tavern");

        when(repository.saveAndFlush(pub)).thenReturn(pub);
        assertEquals(pubsController.addPub(pub).getPub(),"The QA Tavern");
    }

    @Test
    public void testPubsPutRequest(){
        Pubs pub = new Pubs(0L,"The QA Tavern");

        when(repository.findOne(0L)).thenReturn(pub);
        assertEquals(pubsController.updatePub(0L, pub).getPub(),"The QA Tavern");
    }

    @Test
    public void testPubsDeleteRequest(){
        Pubs pubConstructor = new Pubs(0L,"The QA Tavern");

        when(repository.findOne(0L)).thenReturn(pubConstructor);
        repository.delete(pubConstructor);
        assertEquals(pubsController.deletePub(0L).getPub(),"The QA Tavern");
    }

    @Test
    public void testGetCount(){
        assertEquals(pubsController.countPubs().intValue(),0);

    }




    }

