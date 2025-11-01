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

    public void validate(int purchaseAmount) {
        validatePurchaseAmountDivisibleByThousand(purchaseAmount);
        validatePurchaseAmountPositive(purchaseAmount);
    }

    public void validatePurchaseAmountDivisibleByThousand(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validatePurchaseAmountPositive(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
