package com.reto.Service;

import com.reto.Model.Email;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmailServiceTest {

    @MockBean
    private EmailService emailService;

    @Test
    void listarEmail() {
        Email email = new Email(1L,"george.bluth@reqres.in","George","Bluth","https://reqres.in/img/faces/1-image.jpg");

        when(emailService.ListarEmail()).thenReturn(List.of(email));

        List<Email> emails = emailService.ListarEmail();

        assertNotNull(emails);
        assertEquals(email.getId(),emails.get(0).getId());
        assertEquals(email.getFirst_name(),emails.get(0).getFirst_name());
        assertEquals(email.getLast_name(),emails.get(0).getLast_name());
        assertEquals(email.getEmail(),emails.get(0).getEmail());
        assertEquals(email.getAvatar(),emails.get(0).getAvatar());

    }
}