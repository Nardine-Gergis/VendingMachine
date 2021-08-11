package dao;

public enum CoinTypes {
    QUARTERS(25), DIMES(10), NICKELS(5), PENNIES(1);

    public final int value;

    CoinTypes(int value) {
        this.value = value;
    }
}
