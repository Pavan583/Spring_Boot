package com.scaleupindia.service.impl;

import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("specialService")
public class OwnerServiceImpl2 implements OwnerService {
    @Qualifier("specialRepository")
    @Autowired
    private OwnerRepository ownerRepository;
    @Value("30")
    private int ownerId;

    public OwnerServiceImpl2() {
        System.out.println("OwnerServiceImpl special default bean created");
    }

    @Override
    public String findOwner() {
        return ownerRepository.findOwner(ownerId);
    }
}
