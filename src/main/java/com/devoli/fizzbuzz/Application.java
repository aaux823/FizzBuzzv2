package com.devoli.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings(value = "checkstyle:hideutilityclassconstructor")
@SpringBootApplication(scanBasePackages =  "com.devoli")
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
