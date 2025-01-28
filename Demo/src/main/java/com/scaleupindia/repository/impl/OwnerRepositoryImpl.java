package com.scaleupindia.repository.impl;

import com.scaleupindia.repository.OwnerRepository;

public class OwnerRepositoryImpl implements OwnerRepository {

    public OwnerRepositoryImpl() {
        System.out.println("OwnerRepositoryImpl object created.");
    }

    @Override
    public String findOwner(int ownerId) {
        return String.format("Found owner from repository with ownerId %s", ownerId);
    }
}
