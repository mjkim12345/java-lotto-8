package lotto;

import java.util.List;

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
}