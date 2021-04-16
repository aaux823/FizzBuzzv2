package com.devoli.fizzbuzz.controller;

import com.devoli.fizzbuzz.dto.FizzBuzz;
import com.devoli.fizzbuzz.service.FizzBuzzService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fizzBuzz")
@Log4j2
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    /**
     * Returns FizzBuzz list of values for a given int limit.
     * @param limit {@link Integer}
     * @return {@link FizzBuzz}
     */
    @GetMapping("/{limit}")
    public @ResponseBody FizzBuzz getFizzBuzz(final @PathVariable("limit") Integer limit) {
        log.info("Get fizzBuzz for {} ", limit);
        return fizzBuzzService.getFizzBuzz(limit);
    }

}
