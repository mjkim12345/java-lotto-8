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
                .isInstanceOf(IllegalArgumentException);
    }
}
