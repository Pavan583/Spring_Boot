package com.scaleupindia;

import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.repository.impl.OwnerRepositoryImpl;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.impl.OwnerServiceImpl;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        OwnerRepository ownerRepository = new OwnerRepositoryImpl();
        OwnerService ownerService = new OwnerServiceImpl(ownerRepository, 17);
        System.out.println(ownerService.findOwner());

        List<Integer> list = Arrays.asList(1, 2, 3);

    }
}
