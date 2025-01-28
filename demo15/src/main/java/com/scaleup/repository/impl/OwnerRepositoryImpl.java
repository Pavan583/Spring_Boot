package com.scaleupindia.repository.impl;

import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {
    @Value("${owner.found}")
    private String ownerFound;
    @Value("${owner.not.found}")
    private String ownerNotFound;
    public OwnerRepositoryImpl() {
        System.out.println("OwnerRepositoryImpl bean created.");
    }

    @Override
    public String findOwner(int ownerId) throws OwnerNotFoundException {
        if (ownerId % 2 == 0) {
            return String.format(ownerFound + " ", ownerId);
        } else {
            throw new OwnerNotFoundException(String.format(ownerNotFound + " ", ownerId));
        }
    }
}
