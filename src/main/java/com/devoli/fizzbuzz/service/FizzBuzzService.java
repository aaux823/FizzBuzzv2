package com.devoli.fizzbuzz.service;

import com.devoli.fizzbuzz.dto.FizzBuzz;

@FunctionalInterface
public interface FizzBuzzService {

    FizzBuzz getFizzBuzz(Integer limit);
}
