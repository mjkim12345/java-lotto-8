package lotto;

public enum WinningRank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(5000),
    NONE(0);

    private int winningAmount;

    WinningRank(int winningAmount) {
        this.winningAmount = winningAmount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
