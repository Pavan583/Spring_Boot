package com.scaleupindia.service.impl;

import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Value("20")
    private int ownerId;

    public OwnerServiceImpl() {
        System.out.println("OwnerServiceImpl default bean created");
    }

//    @Autowired
//    public void setOwnerRepository(OwnerRepository ownerRepository) {
//        this.ownerRepository = ownerRepository;
//    }
//
//    @Value("10")
//    public void setOwnerId(int ownerId) {
//        this.ownerId = ownerId;
//    }

//    @Autowired
//    public OwnerServiceImpl(OwnerRepository ownerRepository, @Value("15") int ownerId) {
//        this.ownerRepository = ownerRepository;
//        this.ownerId = ownerId;
//        System.out.println("OwnerServiceImpl bean created.");
//    }

    @Override
    public String findOwner() {
        return ownerRepository.findOwner(ownerId);
    }
}
