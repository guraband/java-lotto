package lotto.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberGenerator implements NumberGenerator {

  private final Random random;
  private static final int START_INCLUSIVE = 1;
  private static final int END_EXCLUSIVE = 46;

  public RandomNumberGenerator() {
    this.random = new Random();
  }

  @Override
  public List<LottoNumber> generate(int limit) {
    return random.ints(START_INCLUSIVE, END_EXCLUSIVE)
            .distinct()
            .limit(Lotto.COUNT_OF_NUMBERS)
            .boxed()
            .sorted()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
  }
}