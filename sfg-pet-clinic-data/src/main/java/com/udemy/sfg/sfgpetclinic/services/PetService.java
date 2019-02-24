package com.udemy.sfg.sfgpetclinic.services;

import com.udemy.sfg.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet owner);

    Set<Pet> findAll();

}
