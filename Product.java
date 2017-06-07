package magazyn;


public class Product {
    int id;
    String type;
    int width;
    int height;
    double size;
    double price;
   
    Product() {}
    
    Product(int id, String type, int width, int height, double price) {
        this.id = id;
        this.type = type;
        this.width = width;
        this.height = height;
        this.size = width*height/100;
        this.price = price;
    }
    public int getId() {
        return this.id;
    }
    public String getType() {
        return this.type;
    }
    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
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
