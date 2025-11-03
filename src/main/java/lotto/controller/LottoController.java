package lotto.controller;

import lotto.service.ParserService;
import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final ParserService parserService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService, ParserService parserService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.parserService = parserService;
    }

    public void run () {
        PurchaseAmount purchaseAmount = purchaseLotto();
        Lottos lottos = printLottoNumbers(purchaseAmount);
        WinningNumber winningNumber = inputWinningNumber();
        BonusNumber bonusNumber = inputBonusNumber(winningNumber.values());
        printLottoResult(lottos, winningNumber, bonusNumber, purchaseAmount);
    }

    private Lottos printLottoNumbers(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.calculateLottoCount();
        Lottos lottos = lottoService.generateRandomLottos(count);
        outputView.printLottoAmount(count);
        outputView.printLottoNumbers(lottos);
        return lottos;
    }

    private void printLottoResult(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber, PurchaseAmount purchaseAmount) {
        LottoStatistics lottoStatistics = lottoService.calculateAllLotto(lottos, winningNumber, bonusNumber);
        outputView.printStatistics(lottoStatistics);
        int totalWinningAmount = lottoStatistics.calculateTotalWinningAmount();
        double rate = lottoService.calculateProfitRate(totalWinningAmount, purchaseAmount.calculateLottoCount() * 1000);
        outputView.printProfitRate(rate);
    }

    private PurchaseAmount purchaseLotto() {
        while (true) {
            try {
                String input = inputView.inputPurchaseAmount();
                int i = parserService.parsePurchaseAmount(input);
                PurchaseAmount purchaseAmount = PurchaseAmount.of(i);
                return purchaseAmount;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
            }
        }
    }

    private WinningNumber inputWinningNumber() {
        while (true) {
            try {
                String s = inputView.inputWinningNumber();
                List<Integer> input = parserService.parseWinningNumber(s);
                WinningNumber winningNumber = WinningNumber.of(input);
                return winningNumber;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
            }
        }
    }

    private BonusNumber inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String s = inputView.inputBonusNumber();
                int input = parserService.parseBonusNumber(s);
                BonusNumber bonusNumber = BonusNumber.of(winningNumbers, input);
                return bonusNumber;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
            }
        }
    }
}
