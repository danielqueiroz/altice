package com.altice.alticci;

import com.altice.alticci.domain.Alticci;
import com.altice.alticci.domain.exception.BadRequestException;
import com.altice.alticci.domain.service.AlticciService;
import com.altice.alticci.domain.service.AlticciServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AlticciServiceTest {

    private static AlticciService alticciService;

    @BeforeAll
    public static void setUp() {
        alticciService = new AlticciServiceImpl();
    }

    @Test
    public void testAlticciValueForZero() {
        Alticci alticci = alticciService.calculate(0L);
        Assertions.assertThat(alticci.getValue()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void testAlticciValueForOne() {
        Alticci alticci = alticciService.calculate(1L);
        Assertions.assertThat(alticci.getValue()).isEqualTo(BigDecimal.ONE);
    }

    @Test
    public void testAlticciValueForTwo() {
        Alticci alticci = alticciService.calculate(2L);
        Assertions.assertThat(alticci.getValue()).isEqualTo(BigDecimal.ONE);
    }

    @Test
    public void testAlticciValueForNine() {
        Alticci alticci = alticciService.calculate(9L);
        Assertions.assertThat(alticci.getValue()).isEqualTo(new BigDecimal(7));
    }

    @Test
    public void testAlticciValueForTwelve() {
        Alticci alticci = alticciService.calculate(12L);
        Assertions.assertThat(alticci.getValue()).isEqualTo(new BigDecimal(16));
    }

    @Test
    public void testAlticciWithNegativeValue() {
        BadRequestException exception = assertThrows(
                BadRequestException.class, () -> alticciService.calculate(-1L));
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("It is not calculate with negative values");
    }
}
