package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.WinningRank;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {

    public Lottos generateRandomLottos(int count) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotto.add(generateNumbers());
        }
        return Lottos.of(lotto);
    }

    public Lotto generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return Lotto.of(numbers);
    }

    public WinningRank calculateLottoResult(List<Integer> winningNumber, int bonusNumber, List<Integer> lottoNumbers) {
        int matchCount = countMatchedNumbers(winningNumber, lottoNumbers);
        int bonusMatchCount = countMatchedBonusNumber(bonusNumber, lottoNumbers);
        WinningRank rank = calculateWinningAmount(matchCount, bonusMatchCount);
        return rank;
    }

    public LottoStatistics calculateAllLotto(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        LottoStatistics statistics = new LottoStatistics();

        for (Lotto lotto : lottos.values()) {
            WinningRank rank = calculateLottoResult(winningNumber.values(), bonusNumber.getBonusNumber(), lotto.values());
            statistics.add(rank);
        }
        return statistics;
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

    public WinningRank calculateWinningAmount(int matchCount, int bonusMatchCount) {

        if (matchCount == 6) {
            return WinningRank.FIRST;
        }
        if (bonusMatchCount == 1 && matchCount == 5) {
            return WinningRank.SECOND;
        }
        if (matchCount == 5) {
            return WinningRank.THIRD;
        }
        if (matchCount == 4) {
            return WinningRank.FOURTH;
        }
        if (matchCount == 3) {
            return WinningRank.FIFTH;
        }
        return WinningRank.NONE;
    }

    public double calculateProfitRate(int winningAmount, int purchaseAmount) {
        double rate = (double) winningAmount / purchaseAmount;
        return Math.round(rate * 1000) / 10.0;
    }
}
