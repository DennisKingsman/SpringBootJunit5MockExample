package com.example.repository;

import com.example.model.DbData;
import org.springframework.data.repository.CrudRepository;

public interface DbDataRepository extends CrudRepository<DbData, Long> {
}
