package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.WinningRank;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {

    public Lotto generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return Lotto.of(numbers);
    }

    public Lottos generateRandomLottos(int count) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotto.add(generateNumbers());
        }
        return Lottos.of(lotto);
    }

    public int countMatchedNumbers(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        Set<Integer> lottoNumberSet = new HashSet<>(lottoNumbers);
        int beforeSize = lottoNumberSet.size();

        for (Integer winningNumber : winningNumbers) {
            lottoNumberSet.add(winningNumber);
        }

        int afterSize = lottoNumberSet.size();
        return beforeSize * 2 - afterSize;
    }

    public int countMatchedBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        Set<Integer> lottoNumberSet = new HashSet<>(lottoNumbers);
        int beforeSize = lottoNumberSet.size();

        lottoNumberSet.add(bonusNumber);
        int afterSize = lottoNumberSet.size();

        return afterSize - beforeSize;
    }

    public int calculateWinningAmount(int matchCount, int bonusMatchCount) {

        if (matchCount == 6) {
            return WinningRank.TWO_BILLION.getWinningAmount();
        }
        if (bonusMatchCount == 1 && matchCount == 5) {
            return WinningRank.THIRTY_MILLION.getWinningAmount();
        }
        if (matchCount == 4) {
            return WinningRank.FIFTY_THOUSANDS.getWinningAmount();
        }
        if (matchCount == 3) {
            return WinningRank.FIVE_THOUSANDS.getWinningAmount();
        }
        return WinningRank.NONE.getWinningAmount();
    }

    public double calculateProfitRate(int winningAmount, int purchaseAmount) {
        double rate = (double) winningAmount / purchaseAmount * 100;
        return Math.round(rate * 10) / 10.0;
    }
}
