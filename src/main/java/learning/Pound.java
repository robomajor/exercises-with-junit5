package learning;

import java.math.BigDecimal;

public class Pound implements WeightUnit{

    public static final BigDecimal POUND_TO_KILOGRAM_RATIO = new BigDecimal("0.453592").setScale(SCALE, ROUNDING_MODE);

    public final BigDecimal value;

    public Pound(BigDecimal value) {
        if (BigDecimal.ZERO.compareTo(value) > 0) {
            throw new IllegalArgumentException("Weight can't be negative!");
        }
        this.value = value.setScale(SCALE, ROUNDING_MODE);
    }

    public Kilogram toKilograms() {
        return new Kilogram(value.multiply(POUND_TO_KILOGRAM_RATIO).setScale(SCALE, ROUNDING_MODE));
    }

}
