package com.example.service;

import com.example.model.DbData;
import com.example.repository.DbDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbDataServiceImpl implements DbDataService {

    private DbDataRepository dbDataRepository;

    @Autowired
    public void setDbDataRepository(DbDataRepository dbDataRepository) {
        this.dbDataRepository = dbDataRepository;
    }

    public DbData findById(Long id) {
        return dbDataRepository.findById(id).get();
    }

}
