package com.pavan.service;

import com.pavan.dto.OwnerDTO;
import com.pavan.exception.DuplicateOwnerIdException;
import com.pavan.exception.OwnerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OwnerService {
    void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException;

    OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

    void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

    void deleteOwner(int ownerId) throws OwnerNotFoundException;

    List<OwnerDTO> findAllOwners();

}
