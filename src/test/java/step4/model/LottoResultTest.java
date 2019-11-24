package step4.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    void 결과() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.MISS);
        ranks.add(Rank.FIFTH);
        ranks.add(Rank.FIFTH);
        ranks.add(Rank.FIRST);

        LottoResult lottoResult = new LottoResult(ranks, new Money(10000));
        assertThat(lottoResult.getRankCount(Rank.FIFTH)).isEqualTo(2);
        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.comparePrizeSum(Rank.FIRST.getPrize().sum(Rank.FIFTH.getPrize()).sum(Rank.FIFTH.getPrize()))).isTrue();
    }

    @Test
    void 수익률() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIFTH);

        LottoResult lottoResult = new LottoResult(ranks, new Money(14000));
        assertThat(lottoResult.getProfit()).isEqualTo(0.35);
    }
}