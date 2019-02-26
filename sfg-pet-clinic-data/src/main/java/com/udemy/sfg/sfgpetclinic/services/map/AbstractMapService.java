package com.udemy.sfg.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {
    private HashMap<ID, T> repository;

    protected AbstractMapService() {
        this.repository = new HashMap<>();
    }

    public Set<T> findAll() {
        return new HashSet<>(repository.values());
    }

    public T findById(ID id) {
        return repository.get(id);
    }

    public void save(ID id, T object) {
        repository.put(id, object);
    }

    public void deleteById(ID id) {
        repository.remove(id);
    }
}
