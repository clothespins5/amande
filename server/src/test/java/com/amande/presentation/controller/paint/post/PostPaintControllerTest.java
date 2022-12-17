package com.amande.presentation.controller.paint.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class PostPaintControllerTest {

  @Autowired
  MockMvc mockMvc;
  @Test
  void test() throws Exception {
    this.mockMvc
      .perform(
        MockMvcRequestBuilders
          .post("/paints")
          .contentType(MediaType.APPLICATION_JSON)
          .content("""
            {
              "name": "aaa",
              "colorCode": "rgb(200,215,255)"
            }
            """)
      );
  }
}