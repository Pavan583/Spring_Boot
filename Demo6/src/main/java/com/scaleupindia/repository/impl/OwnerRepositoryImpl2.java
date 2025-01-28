package com.scaleupindia.repository.impl;

import com.scaleupindia.repository.OwnerRepository;
import org.springframework.stereotype.Repository;

@Repository("specialRepository")
public class OwnerRepositoryImpl2 implements OwnerRepository {

    public OwnerRepositoryImpl2() {
        System.out.println("OwnerRepositoryImpl common bean created.");
    }

    @Override
    public String findOwner(int ownerId) {
        return String.format("Found owner from repository with ownerId %s special repo", ownerId);
    }
}
