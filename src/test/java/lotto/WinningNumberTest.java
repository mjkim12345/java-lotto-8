package lotto;

import lotto.domain.WinningNumber;
import lotto.service.ParserService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {

    @Test
    void 당첨번호에_숫자가_아닌_값_입력시_예외() {
        // Given
        String input = "12,123,32,32,32,a";
        ParserService parserService = new ParserService();

        // When & Then
        assertThatThrownBy(() -> parserService.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호의_개수가_6개가_아닐시_예외() {
        // Given
        String input = "1,2,3,4,5,6,7";
        ParserService parserService = new ParserService();
        List<Integer> winningNumbers = parserService.parseWinningNumber(input);

        // When & Then
        assertThatThrownBy(() -> WinningNumber.of(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호에_1에서_45사이의_숫자가_아닌_값이_입력될_경우_예외() {
        // Given
        String input = "1,2,3,4,5,48";
        ParserService parserService = new ParserService();
        List<Integer> winningNumbers = parserService.parseWinningNumber(input);

        // When & Then
        assertThatThrownBy(() -> WinningNumber.of(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호들_중에_중복_값이_있을_경우_예외() {
        // Given
        String input = "1,2,3,4,6,6";
        ParserService parserService = new ParserService();
        List<Integer> winningNumbers = parserService.parseWinningNumber(input);

        // When & Then
        assertThatThrownBy(() -> WinningNumber.of(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
