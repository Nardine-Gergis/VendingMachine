package dao;

import java.math.BigDecimal;
import java.util.List;
import dao.exception.InsufficientFundsException;
import dao.exception.NoItemInventoryException;
import dao.exception.VendingMachineException;
import dto.VendingMachineItem;

public interface VendingMachine {

    List<VendingMachineItem> getVendingMachineItems() throws VendingMachineException;

    BigDecimal tryPurchaseItem(String itemName, BigDecimal moneyAmount)
            throws InsufficientFundsException, NoItemInventoryException, VendingMachineException;
}
