package com.mfw.first_spring_app.controller;

import com.mfw.first_spring_app.domain.User;
import com.mfw.first_spring_app.service.HelloWorldService;
import org.springframework.web.bind.annotation.*;

@RestController // define que é uma @Controller com @ResposeBody
@RequestMapping("/hello-world") // adiciona o mapeamento ao end-point /hello-world
public class HelloWorldController {

    @GetMapping // responde ao GET do end-point /hello-world
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello") // responde ao GET do end-point /hello-world/hello
    public String getHelloWorld() {
        return "End-point /hello-world/hello";
    }

    @PostMapping // responde ao POST do end-point /hello-world
    public String helloWorldPost(@RequestBody User body) {
        return "Hello World Post - " + body.getNome();
    }

    @PostMapping("/{id}") // responde ao POST do end-point /hello-world/{id}?filter
    public String helloWorldPostPathVariable(@RequestBody User body, // valores mandados no Body
                                             @PathVariable String id, // valores mandados no Path
                                             @RequestParam String filter, // filtros/parâmeteos pelo Path
                                             @RequestParam(value = "param2", defaultValue = "valor default") String param2 // valor default para parâmetros, ele fica opcional pq tem default
                                             ) {
        return "Hello World Post " +
                "\nNome: " + body.getNome() +
                "\nId: " + id +
                "\nFilter: " + filter +
                "\nParam2:  " + param2;
    }
}