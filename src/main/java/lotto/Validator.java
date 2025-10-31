package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void validatePurchaseAmountDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validatePurchaseAmountPositive(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumbersRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber > 45 || winningNumber < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateWinningNumbersDuplication(List<Integer> winningNumbers) {
        int originalSize = winningNumbers.size();
        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers);
        if (originalSize != winningNumbersSet.size()) {
            throw new IllegalArgumentException();
        }
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