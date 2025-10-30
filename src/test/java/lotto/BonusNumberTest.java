package lotto;

import org.junit.jupiter.api.Test;
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

}
