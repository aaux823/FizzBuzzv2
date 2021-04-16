package com.devoli.fizzbuzz.service;

import com.devoli.fizzbuzz.dto.FizzBuzz;
import com.devoli.fizzbuzz.dto.FizzBuzzType;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private static final int THREE = 3;
    private static final int FIVE = 5;

    /**
     * Calculates fizz buzz sequence.
     * @param limit {@link Integer}
     * @return {@link FizzBuzz}
     */
    @Override
    public FizzBuzz getFizzBuzz(final Integer limit) {
        int startIndex = 1;
        final List<String> fizzBuzzList = new ArrayList<>();
        // Check if limit is positive value
        if (limit != null && limit > 0) {
            while (startIndex <= limit.intValue()) {
                if (startIndex % THREE == 0 && startIndex % FIVE == 0) {
                    fizzBuzzList.add(FizzBuzzType.FIZZBUZZ.name());
                } else if (startIndex % THREE == 0) {
                    fizzBuzzList.add(FizzBuzzType.FIZZ.name());
                } else if (startIndex % FIVE == 0) {
                    fizzBuzzList.add(FizzBuzzType.BUZZ.name());
                } else {
                    fizzBuzzList.add(String.valueOf(startIndex));
                }
                startIndex++;
            }
        }

        return FizzBuzz.builder().fizzBuzz(fizzBuzzList).build();
    }
}
