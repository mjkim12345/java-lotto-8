package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusNumberDuplication(List<Integer> winningNumbers, int bonusNumber) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber == bonusNumber) {
                throw new IllegalArgumentException();
            }
        }
    }
}