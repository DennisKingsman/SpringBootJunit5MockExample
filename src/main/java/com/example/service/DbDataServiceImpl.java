package com.example.service;

import com.example.model.DbData;
import com.example.repository.DbDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@Service
public class DbDataServiceImpl implements DbDataService {

    private DbDataRepository dbDataRepository;

    @Autowired
    public void setDbDataRepository(DbDataRepository dbDataRepository) {
        this.dbDataRepository = dbDataRepository;
    }

    public DbData findById(Long id) throws NoSuchElementException {
        DbData dbData;
        try {
            dbData = dbDataRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            log.debug(e.getMessage());
            log.info(e.getMessage());
            dbData = null;
        }
        return dbData;
    }

}
