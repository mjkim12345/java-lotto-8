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

    private void validate (List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(winningNumbers,bonusNumber);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1이상 45이하의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumberDuplication(List<Integer> winningNumbers, int bonusNumber) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨번호들과 중복되면 안됩니다.");
            }
        }
    }

    public int getBonusNumber () {
        return bonusNumber;
    }
}
