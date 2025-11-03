package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "%s개를 구매했습니다.";

    public static void printLottoAmount(int lottoAmount) {
        System.out.printf(LOTTO_AMOUNT_MESSAGE, lottoAmount);
    }

    public static void printLottoNumbers(Lottos lottos) {
        List<Lotto> lotto = lottos.values();
        for (Lotto lotto1 : lotto) {
            System.out.println(lotto1.sortedNumbers());
        }
    }
}
