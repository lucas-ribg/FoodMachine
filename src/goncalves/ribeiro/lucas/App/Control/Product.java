package goncalves.ribeiro.lucas.App.Control;

public class Product {
    final public int code;
    public String name;
    public double price;
    public  int amount;

    //Constructor
    public Product(int code, String name, double price, int amount) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
