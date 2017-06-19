package magazyn;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import static magazyn.Warehouse.history;
import static magazyn.Warehouse.otherProducts;
import static magazyn.Warehouse.products;

class Database implements Serializable {
        final String productFile = "materials.dat";
        final String otherProductFile = "others.dat";
        final String historyFile = "history.dat";
                
	public void writeDataToProducts() {
                Database data = new Database();
		File database = new File(data.productFile);
		try {
			database.createNewFile(); // if file already exists will do nothing 
			FileOutputStream fout = new FileOutputStream(database, false); 
			ObjectOutputStream oos = new ObjectOutputStream(fout);
                        List<Product> tempProducts = products.stream().collect(Collectors.toList());

			for(int i = 0; i < tempProducts.size(); i++) {
				oos.writeObject(tempProducts.get(i));
			}
			
			oos.close();
			if(fout != null) {
				fout.close();
			}
			if(oos != null) {
				oos.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void readDataFromProducts()  {
                Database data = new Database();
		File database = new File(data.productFile);
		boolean value = true;
                ArrayList tempProducts = new ArrayList();
		if(database.exists() && !database.isDirectory()) { 
			if(database.length() != 0) {
				FileInputStream fin = null;
				ObjectInputStream oos = null;
				try {
					fin = new FileInputStream(data.productFile);
					oos = new ObjectInputStream(fin);
					while(value) {   
                                            tempProducts.add(tempProducts.size(),(Product)oos.readObject());
                                        }
        		} catch (EOFException e) {
                                products = FXCollections.observableArrayList(tempProducts);
        			value = false;
				} catch (Exception e) {
					e.printStackTrace();
					try {
						if(fin != null) {
							fin.close();
						}
						if(oos != null) {
							oos.close();
						}
					} catch(IOException ex) {}
				} 
				
			}
		}
	}
        public void writeDataToOtherProducts() {
                Database data = new Database();
		File database = new File(data.otherProductFile);
		try {
			database.createNewFile(); // if file already exists will do nothing 
			FileOutputStream fout = new FileOutputStream(database, false); 
			ObjectOutputStream oos = new ObjectOutputStream(fout);
                        List<OtherProduct> tempProducts = otherProducts.stream().collect(Collectors.toList());
			for(int i = 0; i < tempProducts.size(); i++) {
				oos.writeObject(tempProducts.get(i));
			}
			
			oos.close();
			if(fout != null) {
				fout.close();
			}
			if(oos != null) {
				oos.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void readDataFromOtherProducts()  {
                Database data = new Database();
		File database = new File(data.otherProductFile);
		boolean value = true;
                ArrayList tempProducts = new ArrayList();
		if(database.exists() && !database.isDirectory()) { 
			if(database.length() != 0) {
				FileInputStream fin = null;
				ObjectInputStream oos = null;
				try {
					fin = new FileInputStream(data.otherProductFile);
					oos = new ObjectInputStream(fin);
					while(value) {   
                                            tempProducts.add(tempProducts.size(),(OtherProduct)oos.readObject());
                                        }
        		} catch (EOFException e) {
                                otherProducts = FXCollections.observableArrayList(tempProducts);
        			value = false;
				} catch (Exception e) {
					e.printStackTrace();
					try {
						if(fin != null) {
							fin.close();
						}
						if(oos != null) {
							oos.close();
						}
					} catch(IOException ex) {}
				} 
				
			}
		}
	}
        public void writeDataToHistory() {
                Database data = new Database();
		File database = new File(data.historyFile);
		try {
			database.createNewFile(); // if file already exists will do nothing 
			FileOutputStream fout = new FileOutputStream(database, false); 
			ObjectOutputStream oos = new ObjectOutputStream(fout);
                        List<History> tempProducts = history.stream().collect(Collectors.toList());
			for(int i = 0; i < tempProducts.size(); i++) {
				oos.writeObject(tempProducts.get(i));
			}
			
			oos.close();
			if(fout != null) {
				fout.close();
			}
			if(oos != null) {
				oos.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void readDataFromHistory()  {
                Database data = new Database();
		File database = new File(data.historyFile);
		boolean value = true;
                ArrayList tempProducts = new ArrayList();
		if(database.exists() && !database.isDirectory()) { 
			if(database.length() != 0) {
				FileInputStream fin = null;
				ObjectInputStream oos = null;
				try {
					fin = new FileInputStream(data.historyFile);
					oos = new ObjectInputStream(fin);
					while(value) {   
                                            tempProducts.add(tempProducts.size(),(History)oos.readObject());
                                        }
        		} catch (EOFException e) {
                                history = FXCollections.observableArrayList(tempProducts);
        			value = false;
				} catch (Exception e) {
					e.printStackTrace();
					try {
						if(fin != null) {
							fin.close();
						}
						if(oos != null) {
							oos.close();
						}
					} catch(IOException ex) {}
				} 
				
			}
		}
	}
        
}

