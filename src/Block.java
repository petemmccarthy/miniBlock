// import com.sun.org.apache.xpath.internal.operations.String;

// import javax.print.DocFlavor;
import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp; // as millis since 1/1/1970

    // Block constructor
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
    }
}
