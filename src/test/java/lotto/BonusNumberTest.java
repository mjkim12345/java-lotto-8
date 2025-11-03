package lotto;

import lotto.domain.BonusNumber;
import lotto.service.ParserService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class BonusNumberTest {

    @Test
    void 보너스_번호에_숫자가_아닌_값이_입력될_경우_예외() {
        // Given
        String input = "a";
        ParserService parserService = new ParserService();

        // When & Then
        assertThatThrownBy(() -> parserService.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1에서_45사이의_숫자가_아닌_경우_예외() {
        // Given
        int inputBonusNumber = 47;
        String numbers = "1,2,3,4,5,6";
        ParserService parserService = new ParserService();
        List<Integer> winningNumbers = parserService.parseWinningNumber(numbers);

        // When & Then
        assertThatThrownBy(() -> BonusNumber.of(winningNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호와_중복되는_숫자가_보너스_번호로_입력될_경우_예외() {
        // Given
        int bonusNumber = 3;
        String numbers = "1,2,3,4,5,6";
        ParserService parserService = new ParserService();
        List<Integer> winningNumbers = parserService.parseWinningNumber(numbers);

        // When & Then
        assertThatThrownBy(() -> BonusNumber.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
