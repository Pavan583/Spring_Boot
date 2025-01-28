package com.scaleupindia.service.impl;

import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//@Scope("prototype")
@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Value("10")
    private int ownerId;

    public OwnerServiceImpl() {
        System.out.println("OwnerServiceImpl default bean created");
    }

    @Override
    public String findOwner() {
        return ownerRepository.findOwner(ownerId);
    }

    @Override
    public void modifyOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
