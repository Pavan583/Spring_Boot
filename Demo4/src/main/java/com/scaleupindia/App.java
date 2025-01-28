package com.scaleupindia;

import com.scaleupindia.config.SpringConfig;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.impl.OwnerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        OwnerService ownerService = context.getBean("ownerServiceImpl", OwnerService.class);
        OwnerRepository ownerRepository = context.getBean("ownerRepositoryImpl", OwnerRepository.class);
        ((OwnerServiceImpl)ownerService).setOwnerRepository(ownerRepository);
        ((OwnerServiceImpl)ownerService).setOwnerId(10);
        System.out.println(ownerService.findOwner());
        ((AnnotationConfigApplicationContext) context).close();
    }
}
