package magazyn;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class History implements Serializable {
    private final String content;
    private final String date;
        
    History(String content) {
        this.content = content;
        
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currentDate = new Date();
        this.date = sdf.format(currentDate);
    }
    public String getDate() {
        return this.date;
    }
    public String getContent() {
        return this.content;
    }
}
