package com.altice.alticci.domain.service;

import com.altice.alticci.domain.Alticci;
import com.altice.alticci.domain.exception.BadRequestException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
@Service
public class AlticciServiceImpl implements AlticciService {

    private static final Map<Long, Alticci> alticciMap = new HashMap<>();
    static {
        alticciMap.put(0L, new Alticci(0L, BigDecimal.ZERO));
        alticciMap.put(1L, new Alticci(1L, BigDecimal.ONE));
        alticciMap.put(2L, new Alticci(2L, BigDecimal.ONE));
    }

    @Override
    @Cacheable(value = "Alticci", key = "#number")
    public Alticci calculate(Long number) {

        if (number < 0) {
            throw new BadRequestException("It is not calculate with negative values");
        }

        if (alticciMap.containsKey(number))
            return alticciMap.get(number);

        BigDecimal value = calculate(Math.abs(number - 3)).getValue().add(calculate(Math.abs(number -2)).getValue());
        Alticci alticci = new Alticci(number, value);
        alticciMap.put(number, alticci);
        return alticci;
    }
}
