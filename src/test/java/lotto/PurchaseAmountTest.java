package lotto;

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
        String input = "1500";
        Parser parser = new Parser();
        int purchaseAmount = parser.parsePurchaseAmount(input);
        Validator validator = new Validator();

        // When & Then
        assertThatThrownBy(() -> validator.validatePurchaseAmountDivisibleByThousand(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_0이하이면_예외() {
        // Given
        String input = "0";
        Parser parser = new Parser();
        int purchaseAmount = parser.parsePurchaseAmount(input);
        Validator validator = new Validator();

        // When & Then
        assertThatThrownBy(() -> validator.validatePurchaseAmountPositive(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
