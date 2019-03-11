package com.udemy.sfg.sfgpetclinic.services.db;

import com.udemy.sfg.sfgpetclinic.model.Pet;
import com.udemy.sfg.sfgpetclinic.repositories.PetsRepository;
import com.udemy.sfg.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpadata")
public class PetDbService implements PetService {

    private final PetsRepository petsRepository;

    public PetDbService(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petsRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petsRepository.findById(id).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petsRepository.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        petsRepository.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        petsRepository.deleteById(id);
    }
}
