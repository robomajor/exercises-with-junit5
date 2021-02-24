package exchange;

import java.math.BigDecimal;

public interface RatesProvider {
    BigDecimal getRate(Currency from, Currency to);
}