package com.example.repository;

import com.example.model.DbData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbDataRepository extends CrudRepository<DbData, Long> {
}
