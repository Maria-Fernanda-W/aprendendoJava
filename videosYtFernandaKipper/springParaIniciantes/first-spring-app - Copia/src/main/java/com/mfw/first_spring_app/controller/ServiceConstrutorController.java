package com.mfw.first_spring_app.controller;

import com.mfw.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste-service-construtor")
public class ServiceConstrutorController {
    private HelloWorldService helloWorldService;

    //instanciando um service por meio de construtor
    public ServiceConstrutorController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping()
    public String testeService(){
        return helloWorldService.helloWorld("Maria Fernanda");
    }
}

