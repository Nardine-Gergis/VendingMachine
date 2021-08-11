package controller;

import java.math.BigDecimal;
import java.util.InputMismatchException;

import dao.VendingMachineImpl;
import service.Change;
import view.VendingMachineView;

public class VendingMachineController {

    VendingMachineImpl vendingMachine;
    VendingMachineView vendingMachineView;

    public VendingMachineController(VendingMachineImpl vendingMachine,
            VendingMachineView vendingMachineView) {
        this.vendingMachine = vendingMachine;
        this.vendingMachineView = vendingMachineView;
    }

    public void run() {

        BigDecimal moneyAmount = BigDecimal.ZERO;

        try {
            while (true) {
                vendingMachineView.displayVendingMachineItems(vendingMachine.getVendingMachineItems());

                moneyAmount = vendingMachineView.getMoneyAmount();

                if (moneyAmount.equals(BigDecimal.ZERO))
                    break;

                String itemName = vendingMachineView.getItemName();

                BigDecimal change = vendingMachine.tryPurchaseItem(itemName, moneyAmount);

                Change currentChange = new Change(change);

                vendingMachineView.displayChange(currentChange.toString());

                vendingMachine.updateVendingMachineData();
            }
        } catch (InputMismatchException e) {
            vendingMachineView.displayInvalidInputErrorMessage();
        } catch (Exception e) {
            vendingMachineView.displayErrorMessage(e.getMessage());
        }

        vendingMachineView.displayExitBanner();
    }
}
