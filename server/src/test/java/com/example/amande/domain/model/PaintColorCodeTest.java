package com.example.amande.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.amande.domain.models.PaintColorCode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class PaintColorCodeTest {

    @Test
	void create_正常系() {

        PaintColorCode colorCode = new PaintColorCode.Builder()
                .specifiedColor("rgb(255, 254,253)")
                .buildOrElseThrow(builder -> new IllegalArgumentException(builder.toString()));

        assertEquals("rgb(255, 254, 253)", colorCode.toString());
	}
}
