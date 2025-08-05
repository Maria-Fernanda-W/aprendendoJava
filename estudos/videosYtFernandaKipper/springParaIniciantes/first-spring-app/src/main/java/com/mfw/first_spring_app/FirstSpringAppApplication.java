package com.mfw.first_spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
/* anotação que define a porta de entrada do spring, agrupa 3 anotações
@Configuration
@EnableAutoConfiguration
@ComponentScan */
@Profile("dev") // para acessar o perfil dev
public class FirstSpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringAppApplication.class, args);
    }

}
