package podpivasniki.shortfy.site.branchedpipeline.nnn;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@RequiredArgsConstructor
@Data
@ToString
public class StockTradeRequest {
    private final UUID uuid;

    private final StockTradeType stockTradeType;
    private final String figi;
    private final Integer quantity;


}
