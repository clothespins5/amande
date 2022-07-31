package com.example.amande.infrastructure.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.amande.infrastructure.presenters.IVallejoTablePresenter;
import com.example.amande.usecase.IVallejoTableGetUseCase;
import com.example.amande.usecase.VallejoTableGetInput;
import com.example.amande.usecase.VallejoTableGetOutput;
import com.example.amande.usecase.VallejoTableGetUseCase;

@AutoConfigureMockMvc
@SpringBootTest
public class VallejoTableControllerTest {
 


    private MockMvc mockMvc;

    @Mock
    private IVallejoTableGetUseCase vallejoTableGetUseCase;

    @Mock
    private IVallejoTablePresenter vallejoTablePresenter;

    @InjectMocks
    private VallejoTableController vallejoTableController;

    @BeforeEach
    void setup() {

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.vallejoTableController).build();

    }

    @Test
    void getVallejoTableが処理されて200が返る() throws Exception {

        this.mockMvc.perform(get("/vallejoTable?color=rgb(200,10,1)&limit=3"))
            .andExpect(status().isOk());

    }
}
