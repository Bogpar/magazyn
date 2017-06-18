package magazyn;

public class OtherProduct {
    int id;
    String type;
    String uom;
    int size;
    double price;
   
    OtherProduct() {}
    
    OtherProduct(int id, String type, String uom, int size, double price) {
        this.id = id;
        this.type = type;
        this.uom = uom;
        this.size = size;
        this.price = price;
    }
    public int getId() {
        return this.id;
    }
    public String getType() {
        return this.type;
    }
    public String getUom() {
        return this.uom;
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
