package com.scaleupindia;

import com.scaleupindia.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/**
 * Hello world!
 */


//    SS -> 1s - 1r
//    PS -> 2s - 1r
//    PP -> 2s - 2r
//    SP -> 1s - 1r

// Configuration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private OwnerService ownerService1;
    @Autowired
    private OwnerService ownerService2;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Before modifying owner Id of ownerService1");
            System.out.println("OwnerService1 : " + ownerService1.findOwner());
            System.out.println("OwnerService2 : " + ownerService2.findOwner());
            System.out.print("Enter owner Id: ");
            int ownerId = scanner.nextInt();
            ownerService1.modifyOwnerId(ownerId);
            System.out.println("After modifying owner Id of ownerService1");
            System.out.println("OwnerService1 : " + ownerService1.findOwner());
            System.out.println("OwnerService2 : " + ownerService2.findOwner());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
