package lotto.domain;

import lotto.WinningRank;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<WinningRank, Integer> counts = new HashMap<>();

    public LottoStatistics() {
        for (WinningRank rank : WinningRank.values()) {
            counts.put(rank, 0);
        }
    }

    public void add(WinningRank rank) {
        counts.put(rank, counts.get(rank) + 1);
    }

    public int getWinningAmount(WinningRank rank) {
        return counts.get(rank);
    }

    public int calculateTotalWinningAmount() {
        int total = 0;

        for (WinningRank rank : WinningRank.values()) {
            int count = counts.get(rank);
            int amount = rank.getWinningAmount();
            total += amount * count;
        }
        return total;
    }
}
