package com.udemy.sfg.sfgpetclinic.services.db;

import com.udemy.sfg.sfgpetclinic.model.Owner;
import com.udemy.sfg.sfgpetclinic.repositories.OwnersRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
class OwnerDbServiceTest {

    @Mock
    private OwnersRespository ownersRespository;

    private OwnerDbService ownerDbService;

    private Owner controlOwner;
    private String lastName;

    @BeforeEach
    void setUp() {
        Long ownerId = 1L;
        String firstName = "John";
        lastName = "Smith";
        String street = "123 Test st";

        controlOwner = Owner.builder().id(ownerId).firstName(firstName)
                .lastName(lastName).address(street).build();

        ownerDbService = new OwnerDbService(ownersRespository);
    }

    @Test
    void findByLastName() {
        when(ownersRespository.findByLastName(any())).thenReturn(controlOwner);
        Owner owner = ownerDbService.findByLastName(lastName);
        assertNotNull(owner);
        verify(ownersRespository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(controlOwner);
        when(ownersRespository.findAll()).thenReturn(owners);
        assertEquals(1, ownerDbService.findAll().size());
        verify(ownersRespository).findAll();
    }

    @Test
    void findById() {
        when(ownersRespository.findById(anyLong()))
                .thenReturn(Optional.of(controlOwner));
        assertNotNull(ownerDbService.findById(controlOwner.getId()));
        verify(ownersRespository).findById(anyLong());
    }

    @Test
    void findByIdNotFound() {
        when(ownersRespository.findById(anyLong())).thenReturn(Optional.empty());
        assertNull(ownerDbService.findById(controlOwner.getId()));
        verify(ownersRespository).findById(anyLong());
    }

    @Test
    void save() {
        when(ownersRespository.save(any())).thenReturn(controlOwner);
        assertNotNull(ownerDbService.save(controlOwner));
        verify(ownersRespository).save(any());
    }

    @Test
    void delete() {
        ownerDbService.delete(controlOwner);
        verify(ownersRespository).delete(any());
    }

    @Test
    void deleteById() {
        ownerDbService.deleteById(controlOwner.getId());
        verify(ownersRespository).deleteById(anyLong());
    }
}