package com.example;

import com.example.model.Generation;
import com.example.service.impl.GenerationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GenerationServiceTest {

//    @BeforeEach
//    private void setUp(){
//        GenerationService generationService = new GenerationService();
//    };
//


    @Test
    public void givenDateReturnYear(){
        GenerationService generationService = new GenerationService();
        LocalDate date = LocalDate.of(2018, Month.AUGUST,8);
        int expectedYear = 2018;
        int actualYear = generationService.getYearFromDate(date);

      assertEquals(expectedYear,actualYear);
    }

    @Test
    public void givenDateReturnGeneration(){
        GenerationService generationService = new GenerationService();
        LocalDate date = LocalDate.of(1999, Month.AUGUST,8);
        String expectedGen = "Z";
        String actualGen = generationService.checkGeneration(date);

        assertEquals(expectedGen, actualGen);
    }


    @Test
    public void givenYearReturnIsA_Generation(){
        GenerationService generationService = new GenerationService();
        Generation genZ = new Generation("Z", 1996,2003);
        int year = 2001;
        boolean isGenZ = generationService.checkIfYearIsGeneration(genZ,2001);

        assertTrue(isGenZ);
    }

    @Test
    public void Should_Give_A_Generation_When_Date_Is_Provided(){
        GenerationService generationService = new GenerationService();

        LocalDate date = LocalDate.of(1999, Month.AUGUST,8);
        String actualGen =  generationService.getGenerationOfDate(date);
        String expectedGen = "Z";
        assertEquals(expectedGen,actualGen);

    }
}