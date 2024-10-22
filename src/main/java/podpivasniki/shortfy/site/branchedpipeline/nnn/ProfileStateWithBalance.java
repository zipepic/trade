package podpivasniki.shortfy.site.branchedpipeline.nnn;

import java.math.BigDecimal;
import java.util.Map;

public class ProfileStateWithBalance extends ProfileState{

    private final BigDecimal balance;

    public ProfileStateWithBalance(Map<String, Integer> stocks, BigDecimal balance) {
        super(stocks);
        this.balance = balance;
    }
}
