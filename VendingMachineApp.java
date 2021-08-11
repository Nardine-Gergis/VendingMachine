import controller.VendingMachineController;
import dao.VendingMachineImpl;
import service.AuditLogService;
import service.ConsoleUserIO;
import service.UserIO;
import view.VendingMachineView;

public class VendingMachineApp {
    public static void main(String[] args) {

        UserIO userIO = new ConsoleUserIO();
        AuditLogService auditLogService = new AuditLogService();
        VendingMachineImpl vendingMachine = new VendingMachineImpl(auditLogService);
        VendingMachineView vendingMachineView = new VendingMachineView(userIO);
        VendingMachineController vendingMachineController = new VendingMachineController(vendingMachine,
                vendingMachineView);
        vendingMachineController.run();
    }
}
