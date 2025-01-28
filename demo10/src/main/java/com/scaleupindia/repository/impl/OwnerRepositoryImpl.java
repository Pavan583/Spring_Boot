package com.scaleupindia.repository.impl;

import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;
import org.springframework.stereotype.Component;

//@Scope("prototype")
@Component
public class OwnerRepositoryImpl implements OwnerRepository {

    public OwnerRepositoryImpl() {
        System.out.println("OwnerRepositoryImpl bean created.");
    }

    @Override
    public String findOwner(int ownerId) throws OwnerNotFoundException {
        if (ownerId % 2 == 0) {
            return String.format("Found owner with ownerId %s ", ownerId);
        } else {
            throw new OwnerNotFoundException(String.format("Can't find owner with ownerId %s", ownerId));
        }
    }
}
