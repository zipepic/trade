package podpivasniki.shortfy.site.branchedpipeline;

import lombok.SneakyThrows;
import podpivasniki.shortfy.site.branchedpipeline.trade.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class T {
    @SneakyThrows
    public static void main(String[] args) {
        TradingStrategyExecutor tradingStrategyExecutor = new TradingStrategyExecutorImpl();

        Flux<StockData> dataFlux = Flux.interval(Duration.ofMillis(5)).map(i-> new StockData(new Stock("test", BigDecimal.valueOf(16L * new Random().nextDouble()))));

        Flux<TradeResult> tradeResultFlux = tradingStrategyExecutor.execute(dataFlux);

        Mono<List<TradeResult>> mono = tradeResultFlux.collectList();

        mono.subscribe( list -> list.forEach(System.out::println));

        Thread.sleep(2000);
    }
}
