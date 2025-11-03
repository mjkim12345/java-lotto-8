package lotto.view;

import lotto.WinningRank;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;

import java.util.List;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "%s개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String FIFTH_MESSAGE = "3개 일치 (%,d원) - %s개";
    private static final String FOURTH_MESSAGE = "4개 일치 (%,d원) - %d개";
    private static final String THIRD_MESSAGE = "5개 일치 (%,d원) - %d개";
    private static final String SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String FIRST_MESSAGE = "6개 일치 (%,d원) - %d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoAmount(int lottoAmount) {
        System.out.printf(LOTTO_AMOUNT_MESSAGE, lottoAmount);
        System.out.println();
    }

    public static void printLottoNumbers(Lottos lottos) {
        List<Lotto> lotto = lottos.values();
        for (Lotto lotto1 : lotto) {
            System.out.println(lotto1.sortedNumbers());
        }
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.printf(WINNING_STATISTICS+"\n");
        System.out.printf(FIFTH_MESSAGE, WinningRank.FIFTH.getWinningAmount(), lottoStatistics.getWinningAmount(WinningRank.FIFTH));
        System.out.println();
        System.out.printf(FOURTH_MESSAGE, WinningRank.FOURTH.getWinningAmount(), lottoStatistics.getWinningAmount(WinningRank.FOURTH));
        System.out.println();
        System.out.printf(THIRD_MESSAGE, WinningRank.THIRD.getWinningAmount(), lottoStatistics.getWinningAmount(WinningRank.THIRD));
        System.out.println();
        System.out.printf(SECOND_MESSAGE, WinningRank.SECOND.getWinningAmount(), lottoStatistics.getWinningAmount(WinningRank.SECOND));
        System.out.println();
        System.out.printf(FIRST_MESSAGE, WinningRank.FIRST.getWinningAmount(), lottoStatistics.getWinningAmount(WinningRank.FIRST));
        System.out.println();
    }

    public static void printProfitRate (double rate) {
        System.out.printf(PROFIT_RATE_MESSAGE, rate);
    }
}
