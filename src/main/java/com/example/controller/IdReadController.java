package com.example.controller;

import com.example.model.DbData;
import com.example.service.DbDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/project/")
public class IdReadController {

    public static final String RESOURCE_NOT_FOUND = "Resource not found";
    private DbDataService dbDataService;

    @Autowired
    public void setDbDataService(DbDataService dbDataService) {
        this.dbDataService = dbDataService;
    }

    @GetMapping(value = "/data/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DbData getStringById(@PathVariable() Long id) {
        DbData dbData = dbDataService.findById(id);
        if (Objects.isNull(dbData)) {
            dbData = new DbData();
            dbData.setDataId(id);
            dbData.setData(RESOURCE_NOT_FOUND);
        }
        return dbData;
    }

}
