package com.udemy.sfg.sfgpetclinic.services.map.impl;

import com.udemy.sfg.sfgpetclinic.model.Owner;
import com.udemy.sfg.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerService ownerService;
    private String lastName;
    private String firstName;
    private String street;
    private Long ownerId;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerMapService(
                new PetMapService(
                        new PetTypeMapService()));
        ownerId = 1L;
        firstName = "John";
        lastName = "Smith";
        street = "123 Test st";

        Owner owner = Owner.builder().id(ownerId).firstName(firstName)
                .lastName(lastName).address(street).build();
        ownerService.save(owner);

    }

    @Test
    void findAll() {
        assertEquals(1L, ownerService.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = ownerService.findById(ownerId);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
        assertEquals(firstName, owner.getFirstName());
        assertEquals(lastName, owner.getLastName());
        assertEquals(street, owner.getAddress());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ownerId);
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerService.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
        assertEquals(firstName, owner.getFirstName());
        assertEquals(lastName, owner.getLastName());
        assertEquals(street, owner.getAddress());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(2L).firstName("Peter")
                .lastName("Jackson").address("234 Johnson St").build();
        ownerService.save(owner);
        assertEquals(2, ownerService.findAll().size());
    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(ownerId));
        assertEquals(0, ownerService.findAll().size());
    }
}