package com.example.service;

import com.example.model.DbData;
import com.example.repository.DbDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DbDataServiceTest {

    private final long testId = 1;
    private final DbData dbData = new DbData(testId, "data 1");

    @Mock
    private DbDataRepository dbDataRepository;

    @InjectMocks
    private DbDataService dbDataService = new DbDataServiceImpl();

    @BeforeEach
    public void setMockOutput(){
        when(dbDataRepository.findById(testId)).thenReturn(Optional.of(dbData));
    }

    @Test
    public void testFindById() {
        assertEquals(dbData, dbDataService.findById(testId));
    }

}
