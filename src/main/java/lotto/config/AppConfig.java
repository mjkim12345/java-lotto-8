package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.ParserService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(inputView(), outputView(), lottoService(), parserService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private LottoService lottoService() {
        return new LottoService();
    }

    private ParserService parserService() {
        return new ParserService();
    }
}
