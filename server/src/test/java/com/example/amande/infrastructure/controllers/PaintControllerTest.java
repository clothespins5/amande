package com.example.amande.infrastructure.controllers;

import com.example.amande.presentation.controller.paint.GetPaintController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PaintControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private GetPaintController paintController;

    @BeforeEach
    void setup() {

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.paintController).build();

    }

    @Test
    void getVallejoTableが処理されて200が返る() throws Exception {

        this.mockMvc.perform(get("/vallejoTable?color=rgb(200,10,1)&limit=3"))
            .andExpect(status().isOk());

    }
}
