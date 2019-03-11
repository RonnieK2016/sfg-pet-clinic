package com.udemy.sfg.sfgpetclinic.services.db;

import com.udemy.sfg.sfgpetclinic.model.Visit;
import com.udemy.sfg.sfgpetclinic.repositories.VisitsRepository;
import com.udemy.sfg.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpadata")
public class VisitDbService implements VisitService {

    private final VisitsRepository visitsRepository;

    public VisitDbService(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitsRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitsRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit visit) {
        return visitsRepository.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        visitsRepository.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitsRepository.deleteById(id);
    }
}
