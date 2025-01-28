package com.scaleupindia.repository.impl;

import com.scaleupindia.repository.OwnerRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository("commonRepository")
public class OwnerRepositoryImpl implements OwnerRepository {

    public OwnerRepositoryImpl() {
        System.out.println("OwnerRepositoryImpl common bean created.");
    }

    @Override
    public String findOwner(int ownerId) {
        return String.format("Found owner from repository with ownerId %s in common repo", ownerId);
    }
}
