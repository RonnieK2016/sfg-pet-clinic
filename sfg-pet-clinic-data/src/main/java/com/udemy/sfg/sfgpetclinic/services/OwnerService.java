package com.udemy.sfg.sfgpetclinic.services;

import com.udemy.sfg.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
