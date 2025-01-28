package com.pavan.repository;

import com.pavan.dto.OwnerDTO;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {
    void save(OwnerDTO ownerDTO);

    Optional<OwnerDTO> findById(int ownerId);

    void updatePetDetails(int ownerId, String petName);

    void deleteById(int ownerId);

    List<OwnerDTO> findAll();
}
