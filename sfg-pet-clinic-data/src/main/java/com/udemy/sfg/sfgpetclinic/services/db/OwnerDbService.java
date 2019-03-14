package com.udemy.sfg.sfgpetclinic.services.db;

import com.udemy.sfg.sfgpetclinic.model.Owner;
import com.udemy.sfg.sfgpetclinic.repositories.OwnersRespository;
import com.udemy.sfg.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("jpadata")
public class OwnerDbService implements OwnerService {

    private final OwnersRespository ownersRespository;

    public OwnerDbService(OwnersRespository ownersRespository) {
        this.ownersRespository = ownersRespository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownersRespository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownersRespository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownersRespository.findById(id).orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownersRespository.findAllByLastNameContaining(lastName);
    }

    @Override
    public Owner save(Owner owner) {
        return ownersRespository.save(owner);
    }

    @Override
    public void delete(Owner owner) {
        ownersRespository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownersRespository.deleteById(id);
    }
}
