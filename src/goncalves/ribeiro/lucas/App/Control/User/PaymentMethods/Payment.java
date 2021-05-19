package goncalves.ribeiro.lucas.App.Control.User.PaymentMethods;

import goncalves.ribeiro.lucas.App.Control.Machine;
import goncalves.ribeiro.lucas.App.Control.Product;

public abstract class Payment {

    /**
     * Buy item
     * @param machine instantiated machine
     * @param code product code
     * @param amount product amount
     * @return true - successful / false - fail
     */
    public boolean buyItem(Machine machine, int code, int amount){
        for (Product product: machine.products){
            if(product.code == code){
                machine.balance = machine.balance + (product.price * amount);
                machine.rmvProductAmount(code, amount);
                return true;
            } else {
                System.out.println("Product doesn't exists!");
                return false;
            }
        }
        return true;
    }
}
