package podpivasniki.shortfy.site.branchedpipeline.trade;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.function.Predicate;

@RequiredArgsConstructor
@Data
@ToString
public class TradeResult<T> {
    private final TradeActionResultType actionResultType;
    private final T t;
    public final Predicate<T> validate;
}