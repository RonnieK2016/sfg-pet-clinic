package com.udemy.sfg.sfgpetclinic.services;

import com.udemy.sfg.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();

}
