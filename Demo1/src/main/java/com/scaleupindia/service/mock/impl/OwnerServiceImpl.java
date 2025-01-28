package com.scaleupindia.service.mock.impl;

import com.scaleupindia.service.OwnerService;

public class OwnerServiceImpl implements OwnerService {
    private int ownerId;

    public OwnerServiceImpl(int ownerId) {
        this.ownerId = ownerId;
        System.out.println("OwnerServiceImpl mock bean created.");
    }

    @Override
    public String findOwner() {
        return String.format("Found owner from service with ownerId %s", ownerId);
    }
}
