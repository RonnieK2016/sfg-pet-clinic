package com.udemy.sfg.sfgpetclinic.repositories;

import com.udemy.sfg.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypesRepository extends CrudRepository<PetType, Long> {
}
