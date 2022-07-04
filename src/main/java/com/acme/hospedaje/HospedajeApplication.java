package com.acme.hospedaje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HospedajeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospedajeApplication.class, args);
    }

}
