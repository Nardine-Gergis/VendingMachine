package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import dao.exception.InsufficientFundsException;
import dao.exception.NoItemInventoryException;
import dao.exception.VendingMachineException;
import dto.VendingMachineItem;
import service.AuditLogService;

public class VendingMachineImpl implements VendingMachine {

    AuditLogService auditLogService;

    public VendingMachineImpl(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    public static final String VendingMachine_FILE = new File("").getAbsolutePath() + "/model/VendingMachineData.txt";
    public static final String DELIMITER = "::";
    private List<VendingMachineItem> vendingMachineItems = new ArrayList<>();;

    @Override
    public List<VendingMachineItem> getVendingMachineItems() throws VendingMachineException {

        if (vendingMachineItems.isEmpty())
            readVendingMachineData();
        return vendingMachineItems;
    }

    @Override
    public BigDecimal tryPurchaseItem(String itemName, BigDecimal moneyAmount)
            throws InsufficientFundsException, NoItemInventoryException, VendingMachineException {

        List<VendingMachineItem> stream = vendingMachineItems.stream().filter(i -> i.getName().equals(itemName))
                .collect(Collectors.toList());

        if (stream.isEmpty()) {
            auditLogService.writeToAuditLog("There is no such item in the inventory: " + itemName);

            throw new NoItemInventoryException("There is no such item in the inventory.");
        } else if (moneyAmount.compareTo(stream.get(0).getCost()) == -1) {
            auditLogService
                    .writeToAuditLog("Money amount: " + moneyAmount + " is less than item: " + itemName + " cost.");

            throw new InsufficientFundsException("Money amount: " + moneyAmount + " is less than item cost.");
        } else {
            VendingMachineItem currentItem = stream.get(0);
            if (currentItem.getAmount() != 0)
                currentItem.setAmount(currentItem.getAmount() - 1);

            auditLogService.writeToAuditLog("Item: " + itemName + " purchased sucessfully.");

            return moneyAmount.subtract(currentItem.getCost());
        }
    }

    private void readVendingMachineData() throws VendingMachineException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(VendingMachine_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineException("Sorry an error occured while loading Vending Machine Data!", e);
        }

        String[] currentVendingMachineItemData;

        while (scanner.hasNextLine()) {
            currentVendingMachineItemData = scanner.nextLine().split(DELIMITER);

            VendingMachineItem currentVendingMachineItem = new VendingMachineItem(currentVendingMachineItemData[0],
                    new BigDecimal(currentVendingMachineItemData[1]),
                    Integer.parseInt(currentVendingMachineItemData[2]));

            vendingMachineItems.add(currentVendingMachineItem);
        }

        scanner.close();
    }

    public void updateVendingMachineData() throws VendingMachineException {

        PrintWriter writer;

        try {
            writer = new PrintWriter(new FileWriter(VendingMachine_FILE));
        } catch (IOException e) {
            throw new VendingMachineException("Sorry an error occured while saving Vending Machine Data!", e);
        }

        List<VendingMachineItem> vendingMachineItems = this.getVendingMachineItems();
        for (VendingMachineItem currentVendingMachineItem : vendingMachineItems) {

            writer.println(currentVendingMachineItem.getName() + DELIMITER + currentVendingMachineItem.getCost()
                    + DELIMITER + currentVendingMachineItem.getAmount());
            writer.flush();
        }
        writer.close();
    }

}
