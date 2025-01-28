package com.pavan.service;

import com.pavan.dto.PetDTO;
import com.pavan.exception.PetNotFoundException;
import org.springframework.stereotype.Service;


public interface PetService {
    PetDTO findPet(int petId) throws PetNotFoundException;
}
