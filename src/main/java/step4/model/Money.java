package step4.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    public static final int LOTTO_PRICE = 1_000;

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int lottoCount() {
        return money / LOTTO_PRICE;
    }

    public Money sum(Money money) {
        return new Money(this.money + money.money);
    }

    public Money leftMoney(int lottoCount) {
        return new Money(this.money - lottoCount * LOTTO_PRICE);
    }

    public double getProfit(Money prizeSum) {
        BigDecimal decimalSum = new BigDecimal(prizeSum == null ? 0 : prizeSum.money);
        BigDecimal decimalMoney = new BigDecimal(money);

        return decimalSum.divide(decimalMoney, 2, BigDecimal.ROUND_FLOOR).doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
