package com.devoli.fizzbuzz.service;

import com.devoli.fizzbuzz.dto.FizzBuzz;
import com.devoli.fizzbuzz.dto.FizzBuzzType;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Log4j2
@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzServiceTest {

    private  FizzBuzzService fizzBuzzService = new FizzBuzzServiceImpl();

    @Test
    public void getFizzBuzz_whenCalledWith3_returnListShouldEndInFizz() {
        FizzBuzz fizzBuzz = fizzBuzzService.getFizzBuzz(3);
        printFizzBuzz(fizzBuzz);
        assertEquals(FizzBuzzType.FIZZ.name(), fizzBuzz.getFizzBuzz().get(2));
    }

    @Test
    public void getFizzBuzz_whenCalledWith5_returnListShouldEndInBuzz() {
        FizzBuzz fizzBuzz = fizzBuzzService.getFizzBuzz(5);
        printFizzBuzz(fizzBuzz);
        assertEquals(FizzBuzzType.BUZZ.name(), fizzBuzz.getFizzBuzz().get(4));
    }

    @Test
    public void getFizzBuzz_whenCalledWithFactorialOf3_returnListShouldEndInFizz() {
        FizzBuzz fizzBuzz = fizzBuzzService.getFizzBuzz(21);
        printFizzBuzz(fizzBuzz);
        assertEquals(FizzBuzzType.FIZZ.name(), fizzBuzz.getFizzBuzz().get(20));
    }

    @Test
    public void getFizzBuzz_whenCalledWithFactorialOf5_returnListShouldEndInBuzz() {
        FizzBuzz fizzBuzz = fizzBuzzService.getFizzBuzz(20);
        printFizzBuzz(fizzBuzz);
        assertEquals(FizzBuzzType.BUZZ.name(), fizzBuzz.getFizzBuzz().get(19));
    }

    @Test
    public void getFizzBuzz_whenCalledWithFactorialOfBoth3And5_returnListShouldEndInFizzBuzz() {
        FizzBuzz fizzBuzz = fizzBuzzService.getFizzBuzz(30);
        printFizzBuzz(fizzBuzz);
        assertEquals(FizzBuzzType.FIZZBUZZ.name(), fizzBuzz.getFizzBuzz().get(29));
    }

    @Test
    public void getFizzBuzz_whenCalledWithNonFactorialOfBoth3And5_returnListShouldEndInLimit() {
        FizzBuzz fizzBuzz = fizzBuzzService.getFizzBuzz(17);
        printFizzBuzz(fizzBuzz);
        assertEquals("17", fizzBuzz.getFizzBuzz().get(16));
    }


    @Test
    public void getFizzBuzz_whenCalledWith0_returnListShouldBeEmpty() {
        FizzBuzz fizzBuzz = fizzBuzzService.getFizzBuzz(0);
        printFizzBuzz(fizzBuzz);
        assertTrue(CollectionUtils.isEmpty(fizzBuzz.getFizzBuzz()));
    }

    @Test
    public void getFizzBuzz_whenCalledWithNull_returnListShouldBeEmpty() {
        FizzBuzz fizzBuzz = fizzBuzzService.getFizzBuzz(null);
        printFizzBuzz(fizzBuzz);
        assertTrue(CollectionUtils.isEmpty(fizzBuzz.getFizzBuzz()));
    }

    /**
     * Optional method to print
     * @param fizzBuzz
     */
    private void printFizzBuzz(FizzBuzz fizzBuzz) {
        String fizzBuzzStr = fizzBuzz.getFizzBuzz().stream().collect(Collectors.joining(","));
        log.info(fizzBuzzStr);
    }

}