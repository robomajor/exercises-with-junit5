package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("should convert 1 kilogram to pounds: ")
    void shouldConvert1Kilogram() {
        assertEquals(new BigDecimal("2.2046"), new Kilogram(BigDecimal.ONE).toPounds().value);
    }

    @Test
    @DisplayName("should throw exception when negative values are passed to Pound constructor: ")
    void shouldNotAcceptNegativeWeightInPounds() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> new Pound(new BigDecimal(-1))
        );
        assertEquals("Weight can't be negative!", exception.getMessage());
    }

    //assertTimeout runs code on the same thread and waits for it to complete.
    // Upon completion, it checks whether the set time has been exceeded.
    @Test
    @DisplayName("should translate unit in less then 10ms: ")
    void shouldTranslateUnitsFast() {
        assertTimeout(Duration.ofMillis(10), () -> new Kilogram(BigDecimal.TEN).toPounds());
    }

    //test nesting
    @Nested
    class ExceptionHandling {
        @Test
        @DisplayName("should throw exception when negative values are passed to Kilogram constructor: ")
        void shouldNotAcceptNegativeWeightInKilograms() {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class, () -> new Kilogram(new BigDecimal(-1))
            );
            assertEquals("Weight can't be negative!", exception.getMessage());
        }
    }

    @Test
    @DisplayName("should not accept when null value are passed to constructors: ")
    void shouldNotAcceptNullValue() {
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> new Kilogram(null)),
                () -> assertThrows(NullPointerException.class, () -> new Pound(null))
        );
    }

    //just some random test to try out test repeating functionality
    @RepeatedTest(3)
    void shouldAlwaysReturnTheSameValue() {
        assertEquals(new BigDecimal("29.4840").setScale(4, RoundingMode.CEILING), new Pound(new BigDecimal(65)).toKilograms().value);
    }

}