package com.scaleupindia;

import com.scaleupindia.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */

// Configuration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private OwnerService ownerService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(ownerService.findOwner());
    }
}
