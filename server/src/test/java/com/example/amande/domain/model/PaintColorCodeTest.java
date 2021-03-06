package com.example.amande.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.amande.domain.models.PaintColorCode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaintColorCodeTest {

    @Test
	void create_正常系() {
        
        PaintColorCode colorCode = PaintColorCode.create("rgb(255, 254,253)");

        assertEquals("rgb(255, 254, 253)", colorCode.toString());
	}
}
