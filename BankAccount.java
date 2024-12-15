class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        Logger.getInstance().log("Створено рахунок: " + accountNumber + ", Баланс: " + initialBalance);
    }

    public void deposit(double amount) {
        balance += amount;
        Logger.getInstance().log("Поповнено " + amount + " на рахунок: " + accountNumber + ". Новий баланс: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            Logger.getInstance().log("Невдала спроба зняття: недостатньо коштів на рахунку: " + accountNumber);
        } else {
            balance -= amount;
            Logger.getInstance().log("Знято " + amount + " з рахунку: " + accountNumber + ". Новий баланс: " + balance);
        }
    }

    public void transfer(double amount, String targetAccountNumber) {
        if (amount > balance) {
            Logger.getInstance().log("Невдала спроба переказу: недостатньо коштів на рахунку: " + accountNumber);
        } else {
            balance -= amount;
            Logger.getInstance().log("Переказано " + amount + " з рахунку: " + accountNumber +
                    " на рахунок: " + targetAccountNumber + ". Новий баланс: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}