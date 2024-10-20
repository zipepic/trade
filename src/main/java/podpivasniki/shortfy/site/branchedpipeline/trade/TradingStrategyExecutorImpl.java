package podpivasniki.shortfy.site.branchedpipeline.trade;

import reactor.core.publisher.Flux;

import java.math.BigDecimal;

public class TradingStrategyExecutorImpl implements TradingStrategyExecutor{
    @Override
    public Flux<TradeResult> execute(Flux<StockData> tradeParams) {

        return tradeParams
                .map(i -> {
                    if (1 == i.getStock().getPrice().compareTo(BigDecimal.TEN)){
                        return new TradeResult(TradeActionResultType.BUY_STOCK,i.getStock(), (o) -> true);
                    }else {
                        return new TradeResult(TradeActionResultType.SELL_STOCK,i.getStock(), (o) -> false);
                    }
                })
                .take(5);
    }
}
