package podpivasniki.shortfy.site.branchedpipeline.nnn;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Data
@ToString
public abstract class Candle {

    private final String figi;
    private final BigDecimal highestPrice;
    private final BigDecimal lowestPrice;
    private final BigDecimal openPrice;
    private final BigDecimal closingPrice;
    private final String candleInterval;

    public abstract Long getTimeStamp();
}
