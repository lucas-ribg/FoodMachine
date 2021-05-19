package goncalves.ribeiro.lucas.App.Control.User.PaymentMethods;

import goncalves.ribeiro.lucas.App.Control.Machine;
import goncalves.ribeiro.lucas.App.Control.Product;

public class PIX extends Payment{

    String key;

    /**
     * Generate the PIX key
     * @return key of the instantiated PIX payment
     */
    public String generateKey(){
        this.key = Long.toHexString(Double.doubleToLongBits(Math.random()));
        System.out.println(key);
        return this.key;
    }

    /**
     * Buy item with PIX payment
     * @param machine Instantiated machine
     * @param code product code
     * @param amount product amount
     * @param key product key
     * @return true - successful / false - fail
     */
    public boolean buyItemPix(Machine machine, int code, int amount, String key) {
        for (Product product: machine.products){
            if(product.code == code && this.key.equals(key)){
                machine.balance = machine.balance + (product.price * amount);
                machine.rmvProductAmount(code, amount);
                return true;
            } else {
                System.out.println("Incorrect code or key!");
                return false;
            }
        }
        return true;
    }
}
