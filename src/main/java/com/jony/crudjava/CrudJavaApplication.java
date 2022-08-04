package com.jony.crudjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CrudJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudJavaApplication.class, args);
    }

}
