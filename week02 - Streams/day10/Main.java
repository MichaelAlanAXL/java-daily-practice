
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Transaction> transactions = new ArrayList<>();
    private static final NumberFormat money = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            clearScreen();
            printHeader();
            printMenu();
            System.out.print("Select option: ");
            String opt = scanner.nextLine().trim();

            switch (opt) {
                case "1" -> doDeposit();
                case "2" -> doWithdraw();
                case "3" -> viewBalance();
                case "4" -> viewHistory();
                case "0" -> running = false;
                default -> {
                    System.out.println("Invalid option. Press enter to continue...");
                    scanner.nextLine();
                }
                    
            }
        }
        System.out.println("Thanks for using the ATM simulator. Bye!");
    }

    private static void printHeader() {
        System.out.println("########################################");
        System.out.println("#        ATM SIMULATOR (day 10)        #");
        System.out.println("########################################\n");
    }

    private static void printMenu() {
        System.out.println("1 - Deposit");
        System.out.println("2 - Withdraw");
        System.out.println("3 - View Balance");
        System.out.println("4 - View History");
        System.out.println("0 - Exit\n");

    }

    private static void doDeposit() {
        System.out.print("Enter deposit amount: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine().trim());
            if (amount <= 0) {
                System.out.println("Amount must be positive. Press Enter.");
                scanner.nextLine();
                return;
            }
            transactions.add(new Transaction("deposit", amount));
            System.out.println("Deposit recorded: " + money.format(amount) + ". Press Enter.");            
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Press Enter.");
        }
        scanner.nextLine();
    }

    private static void doWithdraw() {
        System.out.print("Enter withdraw amount: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine().trim());
            if (amount <= 0) {
                System.out.println("Amount must be positive. Press Enter.");
                scanner.nextLine();
                return;
            }
            double balance = calculateBalance();
            if (amount > balance) {
                System.out.println("Insufficeint funds. Current balance: " + money.format(balance) + ". Press Enter.");
                scanner.nextLine();
                return;
            }

            transactions.add(new Transaction("withdraw", amount));
            System.out.println("Withdraw recorded: " + money.format(amount) + ". Press enter.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Press Enter.");
        }
        scanner.nextLine();
    }

    private static void viewBalance() {
        double balance = calculateBalance();
        System.out.println("\nCurrent balance: " + money.format(balance));
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void viewHistory() {
        System.out.println("\nTransaction history:");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            int i = 1;
            for (Transaction t : transactions) {
                System.out.println(i++ + " - " + t);
            }
        }
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static double calculateBalance() {
        return transactions.stream()
            .map(t -> t.getType().equalsIgnoreCase("deposit") ? t.getAmount() : -t.getAmount())
            .reduce(0.0, Double::sum);
    }

    private static void clearScreen() {
        System.out.print("\n\n");
    }
    
}
