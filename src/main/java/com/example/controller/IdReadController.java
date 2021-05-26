package com.example.controller;

import com.example.model.DbData;
import com.example.repository.DbDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IdReadController {

    private DbDataRepository dbDataRepository;

    @Autowired
    public void setDbDataRepository(DbDataRepository dbDataRepository) {
        this.dbDataRepository = dbDataRepository;
    }

    @GetMapping(value = "/data/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DbData getStringById(@PathVariable Long id) {
        return dbDataRepository.findById(id).get();
    }

}
