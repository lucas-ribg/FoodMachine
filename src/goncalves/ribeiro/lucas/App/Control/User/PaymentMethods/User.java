package goncalves.ribeiro.lucas.App.Control.User.PaymentMethods;

import goncalves.ribeiro.lucas.App.Control.Machine;
import goncalves.ribeiro.lucas.App.Control.Product;

public class User {
    private double accountBalance;

    //Construtor
    public User(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * Do the PIX payment
     * @param machine the instantiated machine
     * @param code product code
     * @param amount product amount
     * @param key payment key
     * @return true - successful / false - fail
     */
    public boolean pixPay(Machine machine, int code, int amount, String key){
        PIX pix = new PIX();
        pix.generateKey();
        for (Product product: machine.products){
            if(product.code == code && accountBalance >= (product.price * amount)) {
                return pix.buyItemPix(machine, code, amount, key);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Do the credit card payment
     * @param machine the instantiated machine
     * @param code product code
     * @param amount product amount
     * @return true - successful / false - fail
     */
    public boolean creditPay(Machine machine, int code, int amount){
        Credit credit = new Credit();
        for (Product product: machine.products){
            if(product.code == code && accountBalance >= (product.price * amount)) {
                return credit.buyItem(machine, code, amount);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * So the debit card payment
     * @param machine the instantiated machine
     * @param code product code
     * @param amount product amount
     * @return true - successful / false - fail
     */
    public boolean debitPay(Machine machine, int code, int amount){
        Debit debit = new Debit();
        for (Product product: machine.products){
            if(product.code == code && accountBalance >= (product.price * amount)) {
                return debit.buyItem(machine, code, amount);
            } else {
                return false;
            }
        }
        return true;
    }
}
