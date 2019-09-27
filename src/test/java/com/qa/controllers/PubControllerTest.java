package com.qa.controllers;

import com.qa.models.Pub;
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


public class PubControllerTest {

    @InjectMocks
    private PubController pubController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Mock
    private PubsRepository repository;

    @Test
    public void testHomepage(){
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/pubs", String.class )).contains("pub");
    }

    @Test
    public void testGetAllEntries(){
        List<Pub> pubsList = new ArrayList<>();
        Pub pub = new Pub("The QA Tavern","testusername","Friday, January 25, 2019","7.98","BR13BE");

        pubController.listAllPubs();
    }
    @Test
    public void testGetNotesByID(){
        List<Pub> pubsList = new ArrayList<>();
    }

    @Test
    public void testVisitPostRequest(){
        Pub pubs = new Pub("The QA Tavern","testusername","5th October 2008","5.78","BR1 3BE");

        when(repository.saveAndFlush(pubs)).thenReturn(pubs);


        assertEquals(pubController.addPub(pubs).getPub(),"The QA Tavern");

    }

    @Test
    public void testVisitPutRequest(){
        Pub entry = new Pub(0L,"The QA Tavern","testusername","5th October 2008","5.78","BR1 3BE");

        when(repository.findOne(0L)).thenReturn(entry);
        assertEquals(pubController.updateEntry(0L, entry).getPub(),"The QA Tavern");
    }

    @Test
    public void testPubsDeleteRequest(){
        Pub pubConstructor = new Pub(0L,"The QA Tavern","testusername","5th October 2008","5.78","BR1 3BE");

        when(repository.findOne(0L)).thenReturn(pubConstructor);
        repository.delete(pubConstructor);
        assertEquals(pubController.deletePub(0L).getPub(),"The QA Tavern");
    }


}
