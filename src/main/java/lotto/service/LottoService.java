package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

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
}
