package com.pavan.repository.impl;

import com.pavan.dto.DomesticPetDTO;
import com.pavan.dto.OwnerDTO;
import com.pavan.dto.WildPetDTO;
import com.pavan.repository.OwnerRepository;
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
public class OwnerRepositoryImpl implements OwnerRepository {
    private List<OwnerDTO> ownerDTOList;

    public OwnerRepositoryImpl() {
        this.ownerDTOList = new ArrayList<>();

    }

    @PostConstruct
    public void init() {
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(1);
        ownerDTO.setFirstName("John");
        ownerDTO.setLastName("Doe");
        ownerDTO.setGender(M);
        ownerDTO.setCity("Hyderabad");
        ownerDTO.setState("Andhra Pradesh");
        ownerDTO.setMobileNumber("9009009001");
        ownerDTO.setEmailId("john.doe@abhishekvermaa10.com");
        DomesticPetDTO domesticPetDTO = new DomesticPetDTO();
        domesticPetDTO.setId(1);
        domesticPetDTO.setName("Max");
        domesticPetDTO.setGender(M);
        domesticPetDTO.setType(DOG);
        domesticPetDTO.setBirthDate(LocalDate.of(2018, 7, 26));
        ownerDTO.setPetDTO(domesticPetDTO);
        ownerDTOList.add(ownerDTO);
        ownerDTO = new OwnerDTO();
        ownerDTO.setId(2);
        ownerDTO.setFirstName("Jane");
        ownerDTO.setLastName("Smith");
        ownerDTO.setGender(F);
        ownerDTO.setCity("Vishakhapatnam");
        ownerDTO.setState("Andhra Pradesh");
        ownerDTO.setMobileNumber("9009009002");
        ownerDTO.setEmailId("jane.smith@abhishekvermaa10.com");
        WildPetDTO wildPetDTO = new WildPetDTO();
        wildPetDTO.setId(2);
        wildPetDTO.setName("Fluffy");
        wildPetDTO.setGender(F);
        wildPetDTO.setType(CAT);
        wildPetDTO.setBirthPlace("Jim Corbett National Park");
        ownerDTO.setPetDTO(wildPetDTO);
        ownerDTOList.add(ownerDTO);
    }

    @Override
    public void save(OwnerDTO ownerDTO) {
        ownerDTOList.add(ownerDTO);
    }

    @Override
    public Optional<OwnerDTO> findById(int ownerId) {
        return ownerDTOList.stream().filter(owner -> owner.getId() == ownerId).findFirst();
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) {
        ownerDTOList.stream().filter(owner -> owner.getId() == ownerId).findFirst().ifPresent(ownerDTO -> ownerDTO.getPetDTO().setName(petName));
    }

    @Override
    public void deleteById(int ownerId) {
        ownerDTOList.removeIf(owner -> owner.getId() == ownerId);
    }

    @Override
    public List<OwnerDTO> findAll() {
        return ownerDTOList;
    }
}
