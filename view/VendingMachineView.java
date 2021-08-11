package view;

import service.UserIO;

import java.math.BigDecimal;
import java.util.List;
import dto.VendingMachineItem;

public class VendingMachineView {
    UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayVendingMachineItems(List<VendingMachineItem> vendingMachineItems) {

        io.print("\n");
        io.print("*** Welcome to Vending Machine this is the Available Items ***");
        for (VendingMachineItem currentItem : vendingMachineItems) {
            if (currentItem.getAmount() > 0)
                io.print(currentItem.getName() + " costs " + currentItem.getCost());
        }
        io.print("\n");
    }

    public BigDecimal getMoneyAmount() {
        return io.readBigDecimal("Please Enter the amount of money or Enter 0 to Exit.");
    }

    public String getItemName() {
        return io.readString("Please enter item Name.");
    }

    public void displayChange(String change) {
        io.print("\n");
        io.print("Here is your change:" + change);
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayInvalidInputErrorMessage() {
        io.print("Invalid input!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}