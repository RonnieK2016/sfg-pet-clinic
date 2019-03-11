package com.udemy.sfg.sfgpetclinic.services.db;

import com.udemy.sfg.sfgpetclinic.model.Vet;
import com.udemy.sfg.sfgpetclinic.repositories.VetsRepository;
import com.udemy.sfg.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpadata")
public class VetDbService implements VetService {

    private final VetsRepository vetsRepository;

    public VetDbService(VetsRepository vetsRepository) {
        this.vetsRepository = vetsRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetsRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetsRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetsRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetsRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetsRepository.deleteById(id);
    }
}
