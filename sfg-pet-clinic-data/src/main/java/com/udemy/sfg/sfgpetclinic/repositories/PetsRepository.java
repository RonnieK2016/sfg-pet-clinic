package com.udemy.sfg.sfgpetclinic.repositories;

import com.udemy.sfg.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetsRepository extends CrudRepository<Pet, Long> {
}
