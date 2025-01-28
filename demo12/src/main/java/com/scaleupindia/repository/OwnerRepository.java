package com.scaleupindia.repository;

import com.scaleupindia.exception.OwnerNotFoundException;

public interface OwnerRepository {
    String findOwner(int ownerId) throws OwnerNotFoundException;
}
