package com.pavan.service.impl;

import com.pavan.dto.PetDTO;
import com.pavan.exception.PetNotFoundException;
import com.pavan.repository.PetRepository;
import com.pavan.service.PetService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final String petNotFound;

    public PetServiceImpl(PetRepository petRepository, @Value("${pet.not.found}") String petNotFound) {
        this.petRepository = petRepository;
        this.petNotFound = petNotFound;
    }

//    public PetServiceImpl(PetRepository petRepository, @Value("${pet.not.found}")) {
//        this.petRepository = petRepository;
//    }

    @Override
    public PetDTO findPet(int petId) throws PetNotFoundException {
        return petRepository.findByID(petId).orElseThrow(() -> new PetNotFoundException(String.format(petNotFound)));
    }
}
