package com.udemy.sfg.sfgpetclinic.repositories;

import com.udemy.sfg.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitsRepository extends CrudRepository<Visit, Long> {
}
