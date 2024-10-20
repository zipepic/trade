package podpivasniki.shortfy.site.branchedpipeline.trade;

import reactor.core.publisher.Flux;

public interface TradingStrategyExecutor {
    Flux<TradeResult> execute(Flux<StockData> tradeParams);
}