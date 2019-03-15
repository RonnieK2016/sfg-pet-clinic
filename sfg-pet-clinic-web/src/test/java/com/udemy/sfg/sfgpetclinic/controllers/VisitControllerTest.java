package com.udemy.sfg.sfgpetclinic.controllers;

import com.udemy.sfg.sfgpetclinic.model.Pet;
import com.udemy.sfg.sfgpetclinic.model.Visit;
import com.udemy.sfg.sfgpetclinic.services.PetService;
import com.udemy.sfg.sfgpetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {
    @Mock
    private VisitService visitService;
    @Mock
    private PetService petService;

    private VisitController visitController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        visitController = new VisitController(visitService, petService);
        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }

    @Test
    void loadPetWithVisit() {
        Pet pet = Pet.builder().id(1L).build();
        when(petService.findById(anyLong())).thenReturn(pet);
        Map<String, Object> model = new HashMap<>();
        Visit visit = visitController.loadPetWithVisit(pet.getId(), model);
        Pet fromMap = (Pet) model.get("pet");
        assertNotNull(fromMap);
        assertEquals(pet.getId(), fromMap.getId());
        assertEquals(pet.getId(), visit.getPet().getId());
    }

    @Test
    void initNewVisitForm() throws Exception {
        Pet pet = Pet.builder().id(1L).build();
        when(petService.findById(anyLong())).thenReturn(pet);

        mockMvc.perform(get("/owners/1/pets/2/visits/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"));
    }

    @Test
    void processNewVisitForm() throws Exception {

        Pet pet = Pet.builder().id(1L).build();
        when(petService.findById(anyLong())).thenReturn(pet);

        mockMvc.perform(post("/owners/1/pets/2/visits/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/{ownerId}"));

        verify(visitService).save(any());
    }
}