package com.scaleupindia;

import com.scaleupindia.service.OwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.Scanner;

/**
 * Hello world!
 */

@PropertySource("classpath:messages.properties")
@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private OwnerService ownerService1;
    @Autowired
    private OwnerService ownerService2;
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LOGGER.info(ownerService1.findOwner());
            System.out.print("Enter owner Id: ");
            int ownerId = scanner.nextInt();
            ownerService1.modifyOwnerId(ownerId);
            LOGGER.info(ownerService1.findOwner());
        } catch (Exception e) {
            LOGGER.info(e.getMessage(), e);
        }
    }
}
