package lotto.view;

import lotto.WinningRank;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;

import java.util.List;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "%s개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String FIFTH_MESSAGE = "3개 일치 (%s원) - %s개";
    private static final String FOURTH_MESSAGE = "4개 일치 (%s원) - %d개";
    private static final String THIRD_MESSAGE = "5개 일치 (%s원) - %d개";
    private static final String SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String FIRST_MESSAGE = "6개 일치 (%s원) - %d개";

    public static void printLottoAmount(int lottoAmount) {
        System.out.printf(LOTTO_AMOUNT_MESSAGE, lottoAmount);
    }

    public static void printLottoNumbers(Lottos lottos) {
        List<Lotto> lotto = lottos.values();
        for (Lotto lotto1 : lotto) {
            System.out.println(lotto1.sortedNumbers());
        }
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.printf(WINNING_STATISTICS);
        System.out.printf(FIFTH_MESSAGE, WinningRank.FIFTH, lottoStatistics.getWinningAmount(WinningRank.FIFTH));
        System.out.printf(FOURTH_MESSAGE, WinningRank.FOURTH, lottoStatistics.getWinningAmount(WinningRank.FOURTH));
        System.out.printf(THIRD_MESSAGE, WinningRank.THIRD, lottoStatistics.getWinningAmount(WinningRank.THIRD));
        System.out.printf(SECOND_MESSAGE, WinningRank.SECOND, lottoStatistics.getWinningAmount(WinningRank.SECOND));
        System.out.printf(FIRST_MESSAGE, WinningRank.FIRST, lottoStatistics.getWinningAmount(WinningRank.FIRST));
    }
}
