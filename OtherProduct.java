package magazyn;

import java.io.Serializable;
import static magazyn.Warehouse.history;

public class OtherProduct implements Serializable {
    private Integer id;
    private String type;
    private String uom;
    private Integer size;
    private Double price;
    
    Database database = new Database();
   
    public OtherProduct() {}
    
    OtherProduct(Integer id, String type, String uom, Integer size, Double price) {
        this.id = id;
        this.type = type;
        this.uom = uom;
        this.size = size;
        this.price = price;
        
        database.writeDataToOtherProducts();
        
        history.add(new History("Dodano " + this.type + " w ilości " + this.size + " " + this.uom + " w cenie " + this.price + " zł/" + this.uom));
        database.writeDataToHistory();
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
    public Integer getSize() {
        return this.size;
    }
    public Double getPrice() {
        return this.price;
    }
    public void addSize(int arg) {
        this.size += arg;
        database.writeDataToOtherProducts();
        database.writeDataToHistory();
    }
    public void setType(String newType) {
        history.add(new History("Zmieniono nazwe przedmiotu z " + this.type + " na " + newType));
        this.type = newType;
        database.writeDataToOtherProducts();
        database.writeDataToHistory();
    }
    public void setSize(Integer newSize) {
        history.add(new History("Zmieniono rozmiar przedmiotu o nazwie " + this.type + " z rozmiaru \u33A1" + this.size + " na rozmiar \u33A1" + newSize));
        this.size = newSize;
        database.writeDataToOtherProducts();
        database.writeDataToHistory();
    }
    public void setPrice(Double newPrice) {
        history.add(new History("Zmieniono cene przedmiotu o nazwie " + this.type + " z ceny " + this.price + " zł/\u33A1 na cene " + newPrice + " zł/\u33A1"));
        this.price = newPrice;
        database.writeDataToOtherProducts();
        database.writeDataToHistory();
    }
}
