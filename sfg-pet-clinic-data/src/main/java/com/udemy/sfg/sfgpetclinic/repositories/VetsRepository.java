package com.udemy.sfg.sfgpetclinic.repositories;

import com.udemy.sfg.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetsRepository extends CrudRepository<Vet, Long> {
}
