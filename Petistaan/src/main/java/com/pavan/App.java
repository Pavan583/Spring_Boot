package com.pavan;

import com.pavan.dto.OwnerDTO;
import com.pavan.dto.PetDTO;
import com.pavan.service.OwnerService;
import com.pavan.service.PetService;
import com.pavan.util.InputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Scanner;

@PropertySource("classpath:messages.properties")
@SpringBootApplication
public class App implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private final OwnerService ownerService;
    private final PetService petService;

    public App(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("Welcome to Petistaan");
                int menuOption = InputUtil.acceptMenuOption(scanner);
                switch (menuOption) {
                    case 1:
                        OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
                        PetDTO petDTO = InputUtil.acceptPetDetailsToSave(scanner);
                        ownerDTO.setPetDTO(petDTO);
                        ownerService.saveOwner(ownerDTO);
                        System.out.println("Saved owner successfully.");
                        break;
                    case 2:
                        int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        ownerDTO = ownerService.findOwner(ownerId);
                        System.out.println(String.format("Found owner with ownerId %s.", ownerId));
                        System.out.println(ownerDTO);
                        break;
                    case 3:
                        ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
                        ownerService.updatePetDetails(ownerId, petName);
                        System.out.println(
                                String.format("Updated petName to %s for owner with ownerId %s.", petName, ownerId));
                        break;
                    case 4:
                        ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        ownerService.deleteOwner(ownerId);
                        System.out.println(String.format("Deleted owner with ownerId %s.", ownerId));
                        break;
                    case 5:
                        List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
                        System.out.println(String.format("There are %s owners.", ownerDTOList.size()));
                        ownerDTOList.forEach(System.out::println);
                        break;
                    case 6:
                        int petId = InputUtil.acceptPetIdToOperate(scanner);
                        petDTO = petService.findPet(petId);
                        System.out.println(String.format("Found pet with petId %s.", petId));
                        System.out.println(petDTO);
                        break;
                    default:
                        System.out.println("Invalid option entered.");
                }
            } while (InputUtil.wantToContinue(scanner));
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }
}
