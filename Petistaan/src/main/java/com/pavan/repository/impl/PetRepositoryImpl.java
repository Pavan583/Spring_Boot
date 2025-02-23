package com.pavan.repository.impl;

import com.pavan.dto.DomesticPetDTO;
import com.pavan.dto.OwnerDTO;
import com.pavan.dto.PetDTO;
import com.pavan.dto.WildPetDTO;
import com.pavan.repository.PetRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.pavan.enums.Gender.F;
import static com.pavan.enums.Gender.M;
import static com.pavan.enums.PetType.CAT;
import static com.pavan.enums.PetType.DOG;

@Repository
public class PetRepositoryImpl implements PetRepository {
    private List<PetDTO> petDTOList;

    public PetRepositoryImpl() {
        this.petDTOList = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        PetDTO petDTO = new PetDTO();
        DomesticPetDTO domesticPetDTO = new DomesticPetDTO();
        domesticPetDTO.setId(1);
        domesticPetDTO.setName("Max");
        domesticPetDTO.setGender(M);
        domesticPetDTO.setType(DOG);
        domesticPetDTO.setBirthDate(LocalDate.of(2018, 7, 26));
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(1);
        ownerDTO.setFirstName("John");
        ownerDTO.setLastName("Doe");
        ownerDTO.setGender(M);
        ownerDTO.setCity("Hyderabad");
        ownerDTO.setState("Andhra Pradesh");
        ownerDTO.setMobileNumber("9009009001");
        ownerDTO.setEmailId("john.doe@abhishekvermaa10.com");
        domesticPetDTO.setOwnerDTO(ownerDTO);
        petDTOList.add(domesticPetDTO);
        WildPetDTO wildPetDTO = new WildPetDTO();
        wildPetDTO.setId(2);
        wildPetDTO.setName("Fluffy");
        wildPetDTO.setGender(F);
        wildPetDTO.setType(CAT);
        wildPetDTO.setBirthPlace("Jim Corbett National Park");
        ownerDTO = new OwnerDTO();
        ownerDTO.setId(2);
        ownerDTO.setFirstName("Jane");
        ownerDTO.setLastName("Smith");
        ownerDTO.setGender(F);
        ownerDTO.setCity("Vishakhapatnam");
        ownerDTO.setState("Andhra Pradesh");
        ownerDTO.setMobileNumber("9009009002");
        ownerDTO.setEmailId("jane.smith@abhishekvermaa10.com");
        wildPetDTO.setOwnerDTO(ownerDTO);
        petDTOList.add(wildPetDTO);
    }

    @Override
    public Optional<PetDTO> findByID(int petId) {
        return petDTOList.stream().filter(pet -> pet.getId() == petId).findFirst();
    }
}
