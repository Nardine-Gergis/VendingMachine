package dto;

import java.math.BigDecimal;

public class VendingMachineItem {

    String name;
    BigDecimal cost;
    int amount;

    public VendingMachineItem(String name, BigDecimal cost, int amount) {
        this.name = name;
        this.cost = cost;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
