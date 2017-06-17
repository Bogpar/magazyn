package magazyn;


public class Product {
    int id;
    String type;
    double size;
    double price;
   
    Product() {}
    
    Product(int id, String type, int size, double price) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.price = price;
    }
    public int getId() {
        return this.id;
    }
    public String getType() {
        return this.type;
    }
    public double getSize() {
        return this.size;
    }
    public double getPrice() {
        return this.price;
    }
    public void addSize(int arg) {
        this.size += arg;
    }
    
}
