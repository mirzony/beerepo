package poker;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackblack on 4/4/16.
 */
public class TestSpil implements ISpil  {

        List<Karta> spil = new ArrayList<Karta>();

        public TestSpil() {

        }

        public Karta getNextCard() {
            Karta k =  spil.get(0);
            spil.remove(0);
            return k;
        }

        public void setNextCard(Karta k) {
            spil.add(k);
        }

}
