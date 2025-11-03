package lotto.view;

import lotto.domain.Lottos;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "%s개를 구매했습니다.";

    public static void printLottoAmount(int lottoAmount) {
        System.out.printf(LOTTO_AMOUNT_MESSAGE, lottoAmount);
    }
}
