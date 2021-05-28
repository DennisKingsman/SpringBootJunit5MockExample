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

    private static final long testId = 1;
    private static final DbData dbData = new DbData(testId, "data 1");
    private static final DbData empty = new DbData();

    @Mock
    private DbDataRepository dbDataRepository;

    @InjectMocks
    private final DbDataService dbDataService = new DbDataServiceImpl();

    @BeforeEach
    public void setMockOutput() {
        when(dbDataRepository.findById(testId)).thenReturn(Optional.of(dbData));
        when(dbDataRepository.findById(5L)).thenReturn(Optional.of(empty));
    }

    @Test
    public void testFindById() {
        assertEquals(dbData, dbDataService.findById(testId));
    }

    @Test
    public void testFindByIdEmpty() {
        assertEquals(empty, dbDataService.findById(5L));
    }

}
