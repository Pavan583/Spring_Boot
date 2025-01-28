package com.scaleupindia.repository.impl;

import com.scaleupindia.repository.OwnerRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class OwnerRepositoryImpl implements OwnerRepository {

    public OwnerRepositoryImpl() {
        System.out.println("OwnerRepositoryImpl bean created.");
    }

    @Override
    public String findOwner(int ownerId) {
        return String.format("Found owner from repository with ownerId %s", ownerId);
    }
}
