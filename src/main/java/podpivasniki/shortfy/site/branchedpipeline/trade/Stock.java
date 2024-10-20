package podpivasniki.shortfy.site.branchedpipeline.trade;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
@RequiredArgsConstructor
@Data
@ToString
public class Stock {

    private final String name;
    private final BigDecimal price;

}
