package com.lucasmartines.aspectsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AspectsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspectsProjectApplication.class, args);
    }

}
