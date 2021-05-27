package com.example.controller;

import com.example.model.DbData;
import com.example.service.DbDataService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
//@SpringBootTest
//@AutoConfigureMockMvc
public class IdReadControllerTest {

    private final long testId = 1;
    private final DbData dbData = new DbData(testId, "data 1");

//    @Mock
    @MockBean
    private DbDataService dbDataService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetStringById() throws Exception {
        Mockito.when(dbDataService.findById(testId)).thenReturn(dbData);
        mockMvc.perform(get("/project/data/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dataId").value("1"))
                .andExpect(jsonPath("$.data").value("data 1"));
    }

}
