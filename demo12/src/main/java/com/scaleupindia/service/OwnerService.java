package com.scaleupindia.service;

import com.scaleupindia.exception.OwnerNotFoundException;

public interface OwnerService {
    String findOwner() throws OwnerNotFoundException;
    void modifyOwnerId(int ownerId);
}
