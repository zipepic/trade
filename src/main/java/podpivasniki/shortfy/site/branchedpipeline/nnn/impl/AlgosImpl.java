package podpivasniki.shortfy.site.branchedpipeline.nnn.impl;

import podpivasniki.shortfy.site.branchedpipeline.nnn.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.UUID;

public class AlgosImpl implements TradingStrategyExecutor {



    // Создаем Sink для торговли, который будет собирать торговые запросы
    private final Sinks.Many<StockTradeRequest> tradeSink = Sinks.many().multicast().onBackpressureBuffer();

    // tradeFlux будет возвращен через метод trade()
    private final Flux<StockTradeRequest> tradeFlux = tradeSink.asFlux();

    @Override
    public Mono<Void> candleSupplier(Flux<Candle> candlesFlux, ProfileState state) {
        return candlesFlux.doOnNext(System.out::println).buffer(3)
                .flatMap(candle -> {
                    // Создаем запрашиваемую торговлю на основе свечи
                    StockTradeRequest tradeRequest = new StockTradeRequest(UUID.randomUUID(), StockTradeType.BUY_STOCK, "test", 1);

                    // Записываем запрос в tradeSink
                    tradeSink.tryEmitNext(tradeRequest);
                    System.out.println(tradeRequest);

                    return Mono.empty();
                })
                .then();
    }

    @Override
    public Flux<StockTradeRequest> trade(Flux<StockTradeResponse> stockResponseFlux) {
        return stockResponseFlux
                .doOnNext(response -> {
                    // Печатаем информацию о StockTradeResponse
                    System.out.println("Received StockTradeResponse: " + response);
                    // Проверяем успешность ответа и увеличиваем счетчик, если неуспешный
                })
                .thenMany(tradeFlux.doOnNext(request -> {
                    // Печатаем информацию о StockTradeRequest
                    System.out.println("Processed StockTradeRequest: " + request);
                }));
    }

}
