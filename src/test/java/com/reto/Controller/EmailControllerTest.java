package com.reto.Controller;


import com.reto.Model.Email;
import com.reto.Model.EmailString;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmailControllerTest {

    @Autowired
    private TestRestTemplate testrestTemplate ;

    @LocalServerPort
    private int port;

    @Test
    @Order(1)
    void listarEmailsGet(){
        ResponseEntity<Email[]> response = testrestTemplate.getForEntity("http://localhost:"+port,Email[].class);
        List<Email> emails = Arrays.asList(response.getBody());

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertTrue(response.getHeaders().getContentType().includes(MediaType.APPLICATION_JSON));

        assertEquals(1,emails.get(0).getId());
        assertEquals("george.bluth@reqres.in",emails.get(0).getEmail());
        assertEquals("George",emails.get(0).getFirst_name());
        assertEquals("Bluth",emails.get(0).getLast_name());
        assertEquals("https://reqres.in/img/faces/1-image.jpg",emails.get(0).getAvatar());
    }

    @Test
    @Order(2)
    void listarEmailsPost(){
        ResponseEntity<EmailString> response = testrestTemplate.postForEntity("http://localhost:"+port,null,EmailString.class);

        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertTrue(response.getHeaders().getContentType().includes(MediaType.APPLICATION_JSON));

        EmailString emailString = response.getBody();

        assertEquals("1|Bluth|george.bluth@reqres.in",emailString.getData().get(0));



    }


}