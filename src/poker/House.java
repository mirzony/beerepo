package poker;
import java.util.Scanner;

/**
 * Created by jackblack on 3/30/16.
 */
public class House extends Igrac {

    public House(ISpil s)
    {
        super("HOUSE", 100000, s);
        super.clearKarte();
        //Object o = new Object();
        String st = toString();
    }

    public void anotherCard() {
        while (this.zbir() < 17) {
            this.addKarta();
        }
    }

     public int getBet(){
        //ako je vise igraca
        return 0;
    }
    public int getChips(){
        return 0;
    }
}
