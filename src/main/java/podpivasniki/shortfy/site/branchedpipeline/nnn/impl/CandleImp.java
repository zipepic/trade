package podpivasniki.shortfy.site.branchedpipeline.nnn.impl;

import podpivasniki.shortfy.site.branchedpipeline.nnn.Candle;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class CandleImp extends Candle {


    private final OffsetDateTime dateTime;


    public CandleImp(String figi, BigDecimal highestPrice, BigDecimal lowestPrice, BigDecimal openPrice, BigDecimal closingPrice, String candleInterval, OffsetDateTime dateTime) {
        super(figi, highestPrice, lowestPrice, openPrice, closingPrice, candleInterval);
        this.dateTime = dateTime;
    }

    @Override
    public Long getTimeStamp() {
        return 0L;
    }
}
