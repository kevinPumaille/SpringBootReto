package com.reto.Service;

import com.reto.Model.Email;
import com.reto.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmailService {

    @Value("${urlExterna}")
    private String basePath;

    @Autowired
    private RestTemplate clienteEmailRest;

    public List<Email> ListarEmail(){
        Users users = clienteEmailRest.getForObject(basePath+"/users",Users.class);

        return users.getData();
    }
}
