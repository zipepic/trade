package podpivasniki.shortfy.site.branchedpipeline.nnn;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@RequiredArgsConstructor
@Data
@ToString
public class StockTradeResponse {
    private final UUID uuid;
    private final boolean success;
}
