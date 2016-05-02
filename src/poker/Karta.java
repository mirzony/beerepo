package poker;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackblack on 3/14/16.
 */
class Karta
{
    public enum Znak {
        Pik(1), Hertz(2), Tref(3), Karo(4);

        private final int index;

        Znak(int index) {
            this.index = index;
        }

        public int index() {
            return index;
        }
    }


    public static int count;

    private int broj;  //attribute, property of the object
    private Znak znak; //fields , instance variable

    public  Karta(int broj, int znak){
        this.setBroj(broj);
        this.setZnak(znak);
    }

    public int getBroj() { return this.broj;}
    public int getZnak() {
        return znak.index();
    }

    public boolean setBroj(int value){
        if(value > 1 && value < 15)
        {
            broj = value;
            return true;
        }
        return false;
    }

    public String getKarta(){
        count++;

        String rezultat = "";

        switch (broj)
        {
            case 11:
                rezultat = "As" + "-" + znak;
                break;
            case 12:
                rezultat = "Žandar" + "-" + znak;
                break;
            case 13:
                rezultat = "Dama" + "-" + znak;
                break;
            case 14:
                rezultat = "Kralj" + "-" + znak;
                break;
            default:
                rezultat = broj + "-" + znak;
                break;
        }

        return rezultat;
    }

    public boolean setZnak(int value) {
        for (Znak z : Znak.values()) {
            if (z.index() == value) {
                znak = z;
                return true;
            }
        }
        return false;
    }

    public boolean setZnak(String value) {
        boolean found = false;

        znak = Znak.valueOf(value);

        return true;
    }
}

