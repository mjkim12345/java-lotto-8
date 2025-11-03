package lotto;

import lotto.service.LottoService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningAmountTest {

    @Test
    void 당첨_금액을_계산하고_저장한다() {
        // Given
        int matchCount = 5;
        int bonusMatchCount = 1;

        // When
        LottoService lottoService = new LottoService();
        int winningAmount = lottoService.calculateWinningAmount(matchCount, bonusMatchCount);

        // Then
        assertThat(winningAmount).isEqualTo(30000000);
    }

    @Test
    void 총_수익률을_계산한다() {
        // Given
        int winningAmount = 5000;
        int purchaseAmount = 8000;
        LottoService lottoService = new LottoService();

        // When
        double profitRate = lottoService.calculateProfitRate(winningAmount, purchaseAmount);

        // Then
        assertThat(profitRate).isEqualTo(62.5);
    }
}
