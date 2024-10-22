package podpivasniki.shortfy.site.branchedpipeline.nnn.impl;

import lombok.SneakyThrows;
import podpivasniki.shortfy.site.branchedpipeline.nnn.Candle;
import podpivasniki.shortfy.site.branchedpipeline.nnn.StockTradeRequest;
import podpivasniki.shortfy.site.branchedpipeline.nnn.StockTradeResponse;
import podpivasniki.shortfy.site.branchedpipeline.nnn.TradingStrategyExecutor;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.UUID;

public class T {
    @SneakyThrows
    public static void main(String[] args) {
        TradingStrategyExecutor tradingStrategyExecutor = new AlgosImpl();

        // Создаем поток свечей
        Flux<Candle> candleFlux = Flux.interval(Duration.ofMillis(50))
                .map(i -> new CandleImp("test", BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.ONE, "15m", OffsetDateTime.now()));

        tradingStrategyExecutor.candleSupplier(candleFlux, null).subscribe();

        // Создаем поток ответов на торговлю
        Flux<StockTradeResponse> stockTradeResponseFlux = Flux.range(1, 10)
                .map(i -> new StockTradeResponse(UUID.randomUUID(), i % 2 == 0)); // Чередуем успешные/неуспешные ответы

        // Подписываемся на trade()
        tradingStrategyExecutor.trade(stockTradeResponseFlux)
                .doOnNext(request -> {
                    // Обрабатываем ответ и выводим простой текст
                    System.out.println("Received trade request: " + request);
                })
                .subscribe();

        // Даем немного времени для выполнения
        Thread.sleep(2000);
    }

}
