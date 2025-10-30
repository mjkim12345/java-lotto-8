package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {

    @Test
    void 당첨번호에_숫자가_아닌_값_입력시_예외() {
        // Given
        String input = "12,123,32,32,32,a";
        Parser parser = new Parser();

        // When & Then
        assertThatThrownBy(() -> parser.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호의_개수가_6개가_아닐시_예외() {
        // Given
        String input = "1,2,3,4,5,6,7";
        Parser parser = new Parser();
        List<Integer> inputWinningNumbers = parser.parseWinningNumber(input);
        Validator validator = new Validator();

        // When & Then
        assertThatThrownBy(() -> validator.validateWinningNumbersCount(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
