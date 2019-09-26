package com.qa.controllers;

import com.qa.models.Pub;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


public class PubControllerTest {

    @InjectMocks
    private PubController pubController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

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
}
