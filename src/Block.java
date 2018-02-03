// import com.sun.org.apache.xpath.internal.operations.String;

// import javax.print.DocFlavor;
import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private String data; // data is a simple message here
    private long timeStamp; // as millis since 1/1/1970
    private int nonce;

    // Block constructor
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); // do this after you set up the other values
    }

    public String calculateHash() {
        String calculatedHash = StringUtil.applySha256(
                previousHash +
                Long.toString(timeStamp) +
                Integer.toString(nonce) +
                data
        );
        return calculatedHash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

}
