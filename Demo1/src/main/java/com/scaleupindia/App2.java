package com.scaleupindia;

import com.scaleupindia.config.SpringConfig;
import com.scaleupindia.service.OwnerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OwnerService ownerService = (OwnerService) context.getBean("ownerService");
        System.out.println(ownerService.findOwner());
        ((AnnotationConfigApplicationContext)context).close();
    }
}
