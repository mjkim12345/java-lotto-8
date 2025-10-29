package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {

    @Test
    void 당첨번호에_숫자가_아닌_값_입력시_예외() {
        // Given
        String input = "12,13,14,15,16,a";
        Parser parser = new Parser();

        // When & Then
        assertThatThrownBy(() -> parser.parseWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
