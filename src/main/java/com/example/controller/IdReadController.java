package com.example.controller;

import com.example.model.DbData;
import com.example.repository.DbDataRepository;
import com.example.service.DbDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/project/")
public class IdReadController {

    private DbDataService dbDataService;

    @Autowired
    public void setDbDataService(DbDataService dbDataService) {
        this.dbDataService = dbDataService;
    }

    @GetMapping(value = "/data/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DbData getStringById(@PathVariable Long id) {
        return dbDataService.findById(id);
    }

}
