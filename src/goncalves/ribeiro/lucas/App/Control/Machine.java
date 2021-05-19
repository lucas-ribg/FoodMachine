package goncalves.ribeiro.lucas.App.Control;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    public double balance = 0;
    public List<Product> products = new ArrayList<Product>();

    //Constructor
    public Machine() {}

    /**
     * This method adds products in the products list of these machine
     * @param code identifier
     * @param name product name
     * @param price product price
     * @param amount product amount
     */
    public boolean addProduct(int code, String name, double price, int amount){
        for (Product product:products) {
            if(product.code == code){
                return false;
            }
        }
        Product z = new Product(code, name, price, amount);
        products.add(z);
        return true;
    }

    /**
     * This method add an amount of existent product
     * @param code product identifier
     * @param amount product amount
     */
    public boolean addProductAmount(int code, int amount){
        for (Product product:products){
            if(product.code == code) {
                product.amount = product.amount + amount;
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * This method remove an amount of existent product
     * @param code product identifier
     * @param amount product amount
     */
    public boolean rmvProductAmount(int code, int amount){
        for (Product product:products){
            if(product.code == code){
                product.amount = product.amount - amount;
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * This method prints all products
     */
    public void menu(){
        System.out.println("\nCode   Name     Amount    Price");
        for (int i = 0; i < this.products.size(); i++) {
            System.out.println(this.products.get(i).code + " -> " + this.products.get(i).name + "  " + this.products.get(i).amount + "    " + this.products.get(i).price);
        }
    }
}
