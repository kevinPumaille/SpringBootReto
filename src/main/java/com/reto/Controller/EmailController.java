package com.reto.Controller;

import com.reto.Model.Email;
import com.reto.Model.EmailString;
import com.reto.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmailController {

    @Autowired
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<List<Email>> getListaEmail(){
        List<Email> emails = emailService.ListarEmail();
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmailString> postListarEmail(){
        List<String> data = new ArrayList<>();
        for(Email email : emailService.ListarEmail()){
            data.add(email.getId().toString()+"|"+email.getLast_name()+"|"+email.getEmail());
        }
        EmailString emailString = new EmailString();
        emailString.setData(data);

        return new ResponseEntity<>(emailString,HttpStatus.CREATED);
    }
}
