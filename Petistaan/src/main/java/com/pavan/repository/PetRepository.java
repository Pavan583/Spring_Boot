package com.pavan.repository;

import com.pavan.dto.PetDTO;

import java.util.Optional;

public interface PetRepository {
    Optional<PetDTO> findByID(int petId);
}
