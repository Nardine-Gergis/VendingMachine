package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.exception.VendingMachineException;

public class AuditLogService {

    public static final String AuditLog_FILE = new File("").getAbsolutePath() + "/model/AuditLog.txt";

    public void writeToAuditLog(String message) throws VendingMachineException {
        PrintWriter writer;

        try {
            writer = new PrintWriter(new FileWriter(AuditLog_FILE, true));
        } catch (IOException e) {
            throw new VendingMachineException("Sorry an error occured while saving Audit Data!");
        }

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        writer.println(formatter.format(date) + " " + message);
        writer.flush();
        writer.close();
    }
}
