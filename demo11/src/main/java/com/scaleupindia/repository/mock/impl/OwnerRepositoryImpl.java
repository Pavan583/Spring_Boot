package com.scaleupindia.repository.mock.impl;

import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("local")
@Repository
public class OwnerRepositoryImpl implements OwnerRepository {
    @Value("${owner.found}")
    private String ownerFound;

    public OwnerRepositoryImpl() {
        System.out.println("OwnerRepositoryImpl mock bean created.");
    }

    @Override
    public String findOwner(int ownerId) throws OwnerNotFoundException {
        return String.format(ownerFound, ownerId);
    }
}
