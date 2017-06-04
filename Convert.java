package magazyn;

public class Convert {
    public int convertToInt(String arg) {
        int value = 0;
        try {	
            value = Integer.parseInt(arg);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    
    public double convertToDouble(String arg) {
        double value = 0;
        try {	
            value = Double.parseDouble(arg);
        } catch(Exception e) {
             e.printStackTrace();   
        }
        return value;
    }
}
