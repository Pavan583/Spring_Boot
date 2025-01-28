package com.scaleupindia.config;

import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.repository.impl.OwnerRepositoryImpl;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.impl.OwnerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public OwnerService ownerService() {
        return new com.scaleupindia.service.mock.impl.OwnerServiceImpl(10);
    }

    @Bean
    public OwnerService ownerService2() {
        return new OwnerServiceImpl(ownerRepository(), 10);
    }

    @Bean
    public OwnerRepository ownerRepository() {
        return new OwnerRepositoryImpl();
    }
}
