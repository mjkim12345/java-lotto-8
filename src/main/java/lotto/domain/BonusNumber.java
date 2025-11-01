package lotto.domain;

import java.util.List;

public class BonusNumber {

    private int bonusNumber;

    private BonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
    }

    public static BonusNumber of (List<Integer> winningNumbers, int bonusNumber) {
        return new BonusNumber(winningNumbers, bonusNumber);
    }

    public void validate (List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(winningNumbers,bonusNumber);
    }

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
