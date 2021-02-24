package learning;

import java.math.BigDecimal;

public class UniConverter {
    public static void main(String[] args) {
        Kilogram fiveKilograms = new Kilogram(BigDecimal.valueOf(5));
        Pound sevenPounds = new Pound(BigDecimal.valueOf(7));

        Pound fiveKilogramsToPounds = fiveKilograms.toPounds();
        Kilogram sevenPoundsToKilograms = sevenPounds.toKilograms();

        System.out.printf("%1$s kilograms to pounds is %2$s%n",fiveKilograms.value , fiveKilogramsToPounds.value);
        System.out.printf("%1$s pounds to kilograms is %2$s%n",sevenPounds.value , sevenPoundsToKilograms.value);
    }
}
