package com.scaleupindia.service.impl;

import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.service.OwnerService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository ownerRepository;
    private int ownerId;

    public OwnerServiceImpl() {
        System.out.println("OwnerServiceImpl default bean created");
    }

    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

//    public OwnerServiceImpl(OwnerRepository ownerRepository, int ownerId) {
//        this.ownerRepository = ownerRepository;
//        this.ownerId = ownerId;
//        System.out.println("OwnerServiceImpl bean created.");
//    }

    @Override
    public String findOwner() {
        return ownerRepository.findOwner(ownerId);
    }
}
