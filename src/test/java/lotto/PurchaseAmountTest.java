package lotto;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PurchaseAmountTest {

    @Test
    void 구입금액에_숫자가_아닌_값_입력시_예외() {
        // Given
        String input = "100o";
        Parser parser = new Parser();

        // When & Then
        assertThatThrownBy(() -> parser.parsePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_1000_으로_나누어_떨어지지_않을_경우_예외() {
        // Given
        int purchaseAmount = 1500;

        // When & Then
        assertThatThrownBy(() -> PurchaseAmount.of(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_0이하이면_예외() {
        // Given
        int purchaseAmount = 0;

        // When & Then
        assertThatThrownBy(() -> PurchaseAmount.of(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
