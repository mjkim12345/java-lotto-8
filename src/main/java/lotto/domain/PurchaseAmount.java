package lotto.domain;

public class PurchaseAmount {

    private int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount of(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private void validate(int purchaseAmount) {
        validatePurchaseAmountDivisibleByThousand(purchaseAmount);
        validatePurchaseAmountPositive(purchaseAmount);
    }

    private void validatePurchaseAmountDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
        }
    }

    private void validatePurchaseAmountPositive(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 이상이여야 합니다.");
        }
    }

    public int calculateLottoCount() {
        return purchaseAmount / 1000;
    }
}
