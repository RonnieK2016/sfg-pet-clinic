package com.udemy.sfg.sfgpetclinic.services.map;

import com.udemy.sfg.sfgpetclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    private HashMap<Long, T> repository;

    protected AbstractMapService() {
        this.repository = new HashMap<>();
    }

    public Set<T> findAll() {
        return new HashSet<>(repository.values());
    }

    public T findById(ID id) {
        return repository.get(id);
    }

    public T save(T object) {
        if(object.getId() == null) {
            object.setId(getNextId());
        }

        repository.put(object.getId(), object);
        return object;
    }

    private Long getNextId() {
        if(repository.isEmpty()) {
            return 1L;
        }
        else {
            return Collections.max(repository.keySet()) + 1;
        }
    }

    public void deleteById(ID id) {
        repository.remove(id);
    }
}
