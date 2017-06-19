package magazyn;

import java.io.Serializable;
import static magazyn.Warehouse.history;

public class Product implements Serializable {
    private Integer id;
    private String type;
    private Double size;
    private Double price;
    
    Database database = new Database();
    
    Product(Integer id, String type, Double size, Double price) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.price = price;
        
        history.add(new History("Dodano materiał o nazwie " + this.type + " o rozmiarze " + this.size + " i cenie " + this.price + " zł/\u33A1"));
        database.writeDataToHistory();
    }
    public Integer getId() {
        return this.id;
    }
    public String getType() {
        return this.type;
    }
    public Double getSize() {
        return this.size;
    }
    public Double getPrice() {
        return this.price;
    }
    public void addSize(double arg) {
        this.size += arg;
        database.writeDataToProducts();
        
    }
    public void setType(String newType) {
        history.add(new History("Zmieniono nazwe materiału z " + this.type + " na " + newType));
        this.type = newType;
        database.writeDataToProducts();
        database.writeDataToHistory();
        
    }
    public void setSize(Double newSize) {
        history.add(new History("Zmieniono rozmiar materiału o nazwie " + this.type + " z rozmiaru \u33A1" + this.size + " na rozmiar \u33A1" + newSize));
        this.size = newSize;
        database.writeDataToProducts();
        database.writeDataToHistory();
    }
    public void setPrice(Double newPrice) {
        history.add(new History("Zmieniono cene materiału o nazwie " + this.type + " z ceny " + this.price + " zł/\u33A1 na cene " + newPrice + " zł/\u33A1"));
        this.price = newPrice;
        database.writeDataToProducts();
        database.writeDataToHistory();
    }
    
}
