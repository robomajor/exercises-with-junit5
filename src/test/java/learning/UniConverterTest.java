package learning;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniConverterTest {

    @Test
    void shouldConvertZeroKilogramValue() {
        Pound pounds = new Kilogram(BigDecimal.ZERO).toPounds();
        assertEquals(BigDecimal.ZERO.setScale(4, RoundingMode.CEILING), pounds.value);
    }

    @Test
    void shouldConvertZeroPoundValue() {
        Kilogram kilograms = new Pound(BigDecimal.ZERO).toKilograms();
        assertEquals(BigDecimal.ZERO.setScale(4, RoundingMode.CEILING), kilograms.value);
    }

    @Test
    void shouldConvert1Pound() {
        assertEquals(new BigDecimal("0.4536"), new Pound(BigDecimal.ONE).toKilograms().value);
    }

    @Test
    void shouldConvert1Kilogram() {
        assertEquals(new BigDecimal("2.2046"), new Kilogram(BigDecimal.ONE).toPounds().value);
    }



}