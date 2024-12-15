import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        logger.log("Система запущена.");

        System.out.print("Введіть номер Вашого рахунку: ");
        String accountNumber = scanner.nextLine();

        double initialBalance = new Random().nextInt(10000) + 1000;
        BankAccount account = new BankAccount(accountNumber, initialBalance);

        while (true) {
            System.out.println("\nБаланс на рахунку (" + account.getAccountNumber() + "): " + account.getBalance() + " грн");
            System.out.println("Оберіть дію:");
            System.out.println("1) Зняти готівку");
            System.out.println("2) Поповнити рахунок");
            System.out.println("3) Переказати на картку");
            System.out.println("4) Вийти");
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Введіть суму для зняття: ");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                }
                case 2 -> {
                    System.out.print("Введіть суму для поповнення: ");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                }
                case 3 -> {
                    System.out.print("Введіть номер рахунку для переказу: ");
                    scanner.nextLine();
                    String targetAccountNumber = scanner.nextLine();
                    System.out.print("Введіть суму для переказу: ");
                    double amount = scanner.nextDouble();
                    account.transfer(amount, targetAccountNumber);
                }
                case 4 -> {
                    logger.log("Користувач завершив роботу.");
                    System.out.println("Дякуємо за користування системою!");
                    return;
                }
                default -> System.out.println("Некоректний вибір, спробуйте ще раз.");
            }
        }
    }
}