package lotto.domain;

import lotto.WinningRank;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<Integer, Integer> counts = new HashMap<>();

    public LottoStatistics() {
        for (WinningRank winningRank : WinningRank.values()) {
            counts.put(winningRank.getWinningAmount(), 0);
        }
    }
}
