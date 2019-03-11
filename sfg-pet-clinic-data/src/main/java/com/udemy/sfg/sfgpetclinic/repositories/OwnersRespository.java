package com.udemy.sfg.sfgpetclinic.repositories;

import com.udemy.sfg.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnersRespository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

}
