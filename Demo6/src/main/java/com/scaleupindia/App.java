package com.scaleupindia;

import com.scaleupindia.service.OwnerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 */
@ComponentScan
@Configuration
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        OwnerService ownerService = context.getBean("specialService", OwnerService.class);
        System.out.println(ownerService.findOwner());
        ((AnnotationConfigApplicationContext) context).close();
    }
}
