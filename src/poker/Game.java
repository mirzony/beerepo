package poker;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by jackblack on 4/11/16.
 */
public class Game {
    static final int MIN_BET = 5;
    static final int MAX_BET = 50;
    static final int MAX_TIME = 20; //20 seconds

    Date start; //read only
    Date end; //read only
    static int gameCount = 0;
    ISpil _spil;
    List<Igrac> igraci = null;

    Game(ISpil spil,List<Igrac> igraci )
    {
        _spil = spil;
        this.igraci = igraci;
        for(Igrac i: this.igraci){
            i.reset();
        }
        if (gameCount == 0) this.igraci.add(new House(_spil));
        gameCount++;
    }

    public void Start(){
        start = Calendar.getInstance().getTime();

        //get bets od svih igraca
        for(Igrac i: igraci) {
            i.getBet();
        }

        PodijeliKarte(2);

        SlijedecaKarta();

        // igra zavrsena
        Finish();
    }

    //TODO change this method
    private void SlijedecaKarta()
    {
        System.out.print("\n");
        // Drugi Bet i hocete li jos jednu kartu
        for(Igrac i: igraci) {
            if(i.won){
                i.addChip(3 * i.getTotalUlog());
            }
            else {
                i.getBet();
                i.anotherCard();
            }
        }
    }

    //TODO change this method for Poker
    private void PodijeliKarte(int broj){
        //podijeliti po 2 karte svima
        for(Igrac i: igraci) {
            System.out.print(i.getName() + "\n");
            for(int count = 1; count <= broj; count++)
            {
                i.addKarta();
            }

            System.out.print("\n");
        }

    }

    private void Finish()
    {
        end = Calendar.getInstance().getTime();
        Igrac house = igraci.get(igraci.size()-1);
        for(int i=0; i < igraci.size()-1; i++){

            //Igrac ima 21, vec je dobio 3 x ulozeno
            if (igraci.get(i).won) continue;

            //Igrac lost ili manje od housa gubi ulog
            if (igraci.get(i).lost || igraci.get(i).zbir() < house.zbir())
            {
                house.addChip(igraci.get(i).getTotalUlog());
                continue;
            }

            // Kuca izgubila ili igrac ima vise od kuce igrac dobija svoj ulog
            if (house.lost || igraci.get(i).zbir() > house.zbir())
            {
                igraci.get(i).addChip(2*igraci.get(i).getTotalUlog());
                continue;
            }

            // Ako imaju isti zbir igrac vraca ulozeno
            if (!house.lost && igraci.get(i).zbir() == house.zbir())
            {
                igraci.get(i).addChip(igraci.get(i).getTotalUlog());
                continue;
            }


        }

       WriteToFile("Game" + gameCount + ".txt");
    }

    void WriteToFile(String fileName){

        PrintWriter statusFile = null;
        try {

            statusFile = new PrintWriter(fileName);
            System.out.printf("\n");
            System.out.printf("Povukli ste " + Karta.count + " karata \n");

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
            statusFile.println(sdf1.format(start));

            for (Igrac i: igraci) {
                statusFile.println((String.format("Igrac %-20s je imao zbir %02d %d \n",i.getName(),i.zbir(),i.getChips())));
                System.out.printf("Igrac %-20s je imao zbir %02d %d \n",i.getName(),i.zbir(),i.getChips());
            }
            statusFile.println(sdf1.format(end));

        }
        catch (Exception e){
            System.out.printf(e.getMessage());

        }
        finally {
            if (statusFile != null) statusFile.close();
        }
    }

}
