package com.udemy.sfg.sfgpetclinic.repositories;

import com.udemy.sfg.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialitiesRepository extends CrudRepository<Speciality, Long> {
}
