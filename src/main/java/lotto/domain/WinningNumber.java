package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {

    private List<Integer> winningNumbers;

    private WinningNumber(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumber of(List<Integer> winningNumbers) {
        return new WinningNumber(winningNumbers);
    }

    public void validate(List<Integer> winningNumbers) {
        validateWinningNumbersCount(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
        validateWinningNumbersDuplication(winningNumbers);
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

    public List<Integer> values() {
        return List.copyOf(winningNumbers);
    }
}
