package Boxing;

import java.util.ArrayList;


record Customer(String name, ArrayList<Double> transactions){
    public Customer(String name, double initialDeposit){
        this(name.toUpperCase(), new ArrayList<>(500));
        transactions.add(initialDeposit);
    }
}

public class BackChallenge {
    public static void main(String[] args) {
        Customer user = new Customer("User", 1000);
        System.out.println(user);

        Bank bank = new Bank("BetaBank");
        bank.addNewCustomer("Natalia", 3000);
        bank.addNewCustomer("Natalia", 3000);
        System.out.println(bank);

        bank.addTransaction("Natalia", 500);
        bank.addTransaction("Natalia", -450);
        bank.addTransaction("Natalia", -47.43);
        bank.addTransaction("Natalia", -16.7);
        bank.addTransaction("Natalia", -1300);
        bank.printStatement("Natalia");

        bank.addNewCustomer("George", 2000);
        bank.addTransaction("George", 1300);

        bank.printStatement("George");

    }
}

class Bank{
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(2000);

    public Bank(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    private Customer getCustomer(String customerName){
        for(var customer: customers){
            if(customer.name().equalsIgnoreCase(customerName)){
                return customer;
            }
        }
        System.out.printf("Customer \"%s\" wasn't found %n", customerName);

        return null;
    }

    public void addNewCustomer(String customerName, double initialDeposit){
        if(getCustomer(customerName) == null){
            Customer customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("New customer was added: " + customer.name());
        } else {
            System.out.println("Customer: " + customerName + " is already in the system");
        }
    }

    public void addTransaction(String customerName, double transactionAmount){

        Customer customer = getCustomer(customerName);

        if(customerName != null){
            customer.transactions().add(transactionAmount);
            System.out.println(transactionAmount + "$ was added to " + customer.name() + "'s account");
        }
    }

    public void printStatement(String customerName){
        Customer customer = getCustomer(customerName);

        if(customerName == null){
            System.out.println("Customer wasn't found");
            return;
        }

        System.out.println("-".repeat(30));
        System.out.println("Customer name: " + customer.name());
        System.out.println("Transactions: ");

        double sum = 0;

        for(double d: customer.transactions()){
            System.out.printf("%8.2f $ (%s)%n", d, d < 0 ? "debit" : "credit");
            sum += d;
        }

        System.out.printf("Remaining amount: %8.2f $", sum);
    }
}
