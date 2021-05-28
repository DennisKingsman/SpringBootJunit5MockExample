package com.example.controller;

import com.example.model.DbData;
import com.example.service.DbDataService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.controller.IdReadController.RESOURCE_NOT_FOUND;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
//@SpringBootTest
//@AutoConfigureMockMvc
public class IdReadControllerTest {

    private static final long testId = 1;
    private static final DbData dbData = new DbData(testId, "data 1");

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

    @Test
    public void testGetStringByIdEmpty() throws Exception {
        DbData dbData = new DbData();
        dbData.setDataId(5L);
        dbData.setData(RESOURCE_NOT_FOUND);

        Mockito.when(dbDataService.findById(5L)).thenReturn(dbData);
        mockMvc.perform(get("/project/data/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dataId").value("5"))
                .andExpect(jsonPath("$.data").value(RESOURCE_NOT_FOUND));
    }

}
