package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class BonusNumberTest {

    @Test
    void 보너스_번호에_숫자가_아닌_값이_입력될_경우_예외() {
        // Given
        String input = "a";
        Parser parser = new Parser();

        // When & Then
        assertThatThrownBy(() -> parser.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1에서_45사이의_숫자가_아닌_경우_예외() {
        // Given
        String input = "47";
        Parser parser = new Parser();
        int bonusNumber = parser.parseBonusNumber(input);
        Validator validator = new Validator();

        // When & Then
        assertThatThrownBy(() -> validator.validateBonusNumberRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호와_중복되는_숫자가_보너스_번호로_입력될_경우_예외() {
        // Given
        int bonusNumber = 3;
        String numbers = "1,2,3,4,5,6";
        Parser parser = new Parser();
        List<Integer> winningNumbers = parser.parseWinningNumber(numbers);
        Validator validator = new Validator();

        // When & Then
        assertThatThrownBy(() -> validator.validateBonusNumberDuplication(winningNumbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
