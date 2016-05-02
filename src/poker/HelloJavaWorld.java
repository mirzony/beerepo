package poker;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.ObjDoubleConsumer;


public class HelloJavaWorld {


    public static void main(String[] args) throws IOException {

        boolean test = false;
        ISpil s;

        if (test) {
            s = new TestSpil();
            setTestData(s);
        } else {
            s = new Spil();
        }

        List<Igrac> igraci = new ArrayList<Igrac>();
        igraci.add(new Igrac("Prvi", 120, s));
        igraci.add(new Igrac("Drugi", 125, s));
        igraci.add(new Igrac("Treci", 130, s));

        boolean end = false;
        while(!end){
        Game g = new Game(s, igraci);
        g.Start();

        System.out.print("\n Another game?");
        Scanner in = new Scanner(System.in);
        String odgovor = in.nextLine();

        if (odgovor.contains("Y")) continue;
        else end = true;
       }


    }

    private static void setTestData(ISpil s){
        s.setNextCard(new Karta(10, 0));
        s.setNextCard(new Karta(8, 0));
        s.setNextCard(new Karta(10, 1));
        s.setNextCard(new Karta(8, 1));
        s.setNextCard(new Karta(10, 2));
        s.setNextCard(new Karta(8, 2));
        s.setNextCard(new Karta(10, 3));
        s.setNextCard(new Karta(8, 3));

        s.setNextCard(new Karta(11, 0));
        s.setNextCard(new Karta(11, 1));
        s.setNextCard(new Karta(11, 2));
        s.setNextCard(new Karta(11, 3));

        s.setNextCard(new Karta(12, 0));
        s.setNextCard(new Karta(12, 1));
        s.setNextCard(new Karta(12, 2));
        s.setNextCard(new Karta(12, 3));

        s.setNextCard(new Karta(5, 0));
        s.setNextCard(new Karta(5, 1));
        s.setNextCard(new Karta(5, 2));
        s.setNextCard(new Karta(5, 3));
    }
    public void ReadFromFile() throws IOException {
        FileReader fr = new FileReader("FileReaderDemo.java");
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        fr.close();
    }
}



