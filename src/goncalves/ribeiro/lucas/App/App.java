package goncalves.ribeiro.lucas.App;

import goncalves.ribeiro.lucas.App.Control.Machine;
import goncalves.ribeiro.lucas.App.Control.User.PaymentMethods.User;

import java.util.Scanner;

public class App {
    Scanner scanner;
    boolean executeSystem;
    Machine machine = new Machine();
    User user = new User(50.00);

    /**
     * Execute app
     */
    public void execute(){
        int op, op1;
        while(executeSystem){
            welcome();
            op = Integer.parseInt(scanner.nextLine());
            welcomeValue(op);
        }
    }

    /**
     * Add a function for each option in welcome page
     * @param op  receives the option value
     */
    private void welcomeValue(int op) {
        switch (op){
            case 1:
                settings();
                int op1 = Integer.parseInt(scanner.nextLine());
                settingsValue(op1);
                break;
            case 2:
                sales();
                break;
            case 3:
                System.out.println("Agradecemos a preferência! ;)");
                this.executeSystem = false;
                break;
            default:
                System.out.println("Option not registered!");
                return;
        }
    }

    /**
     * Add a function to each option in settings page
     * @param op1 receives the option value
     */
    private void settingsValue(int op1) {
        switch (op1){
            case 1:
                System.out.println("Code:");
                int code = Integer.parseInt(scanner.nextLine());
                System.out.println("Name:");
                String name = scanner.nextLine();
                System.out.println("Price:");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.println("Amount:");
                int amount = Integer.parseInt(scanner.nextLine());
                machine.addProduct(code, name, price, amount);
                return;
            case 2:
                System.out.println("Code:");
                code = Integer.parseInt(scanner.nextLine());
                System.out.println("Amount:");
                amount = Integer.parseInt(scanner.nextLine());
                machine.addProductAmount(code, amount);
                return;
            case 3:
                System.out.println("Code:");
                code = Integer.parseInt(scanner.nextLine());
                System.out.println("Amount:");
                amount = Integer.parseInt(scanner.nextLine());
                machine.rmvProductAmount(code, amount);
                return;
            case 4:
                machine.menu();
                break;
            default:
                return;
        }
    }

    /**
     * Add a function to each option in sale page
     * @param op2 receives option value
     */
    private void saleValue(int op2){
        switch (op2){
            case 1:
                System.out.println("Code:");
                int code = Integer.parseInt(scanner.nextLine());
                System.out.println("Amount:");
                int amount = Integer.parseInt(scanner.nextLine());
                System.out.println("Key:");
                String key = scanner.nextLine();
                user.pixPay(machine, code, amount, key);
                break;
            case 2:
                System.out.println("Code:");
                code = Integer.parseInt(scanner.nextLine());
                System.out.println("Amount:");
                amount = Integer.parseInt(scanner.nextLine());
                user.creditPay(machine, code, amount);
                break;
            case 3:
                System.out.println("Code:");
                code = Integer.parseInt(scanner.nextLine());
                System.out.println("Amount:");
                amount = Integer.parseInt(scanner.nextLine());
                user.debitPay(machine, code, amount);
                break;
            default:
                System.out.println("error");
                return;
        }
    }

    /**
     * Prints the settings menu
     */
    public void settings(){
        System.out.println("-----------------FoodMachine Settings-----------------\n");
        System.out.println("press 1 to add product");
        System.out.println("press 2 to add product amount");
        System.out.println("press 3 to remove product amount");
        System.out.println("press 4 to show the menu");
        System.out.println("press 5 to exit settings");
    }

    /**
     * Prints the welcome menu
     */
    public static void welcome(){
        System.out.println("-----------------Welcome to FoodMachine-----------------\n");
        System.out.println("press 1 to settings");
        System.out.println("press 2 to sale mode");
        System.out.println("press 3 to exit");
    }

    /**
     * Prints the payment method menu
     */
    public static void payment(){
        System.out.println("Select a payment method: ");
        System.out.println("1 - PIX");
        System.out.println("2 - credit");
        System.out.println("3 - debit");
    }

    /**
     * Execute sale
     */
    public void sales(){
        machine.menu();
        payment();
        int op2;
        op2 = Integer.parseInt(scanner.nextLine());
        saleValue(op2);
    }

    //Constructor
    public App() {
        this.scanner = new Scanner(System.in);
        this.executeSystem = true;
    }
}
