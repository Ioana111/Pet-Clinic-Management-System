package com.sda.ioana.petclinic.repository.base;

import com.sda.ioana.petclinic.service.dto.VetDto;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, ID> {
    Optional<T> findById(ID id);

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(ID id);

    List<T> findAll();

}


