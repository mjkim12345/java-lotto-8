package lotto;

public enum WinningRank {
    TWO_BILLION(2000000000),
    THIRTY_MILLION(30000000),
    FIFTY_THOUSANDS(1500000),
    FIVE_THOUSANDS(5000),
    NONE(0);

    private int winningAmount;

    WinningRank(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
