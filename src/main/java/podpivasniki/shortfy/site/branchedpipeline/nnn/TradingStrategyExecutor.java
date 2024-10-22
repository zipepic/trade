package podpivasniki.shortfy.site.branchedpipeline.nnn;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TradingStrategyExecutor {

    Mono<Void> candleSupplier(Flux<Candle> candlesFlux, ProfileState state);
    Flux<StockTradeRequest> trade(Flux<StockTradeResponse> stockResponseFlux);
}