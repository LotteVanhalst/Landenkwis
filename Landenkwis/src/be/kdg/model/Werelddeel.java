package be.kdg.model;

import java.io.*;
import java.util.*;


/**
 * @author Lotte Vanhalst
 * @version 1.0 16/02/2019 15:48
 */
public class Werelddeel {
    private Werelddelen werelddeel;
    private List<Land> landen;


    public Werelddeel(Werelddelen werelddeel) {
        setWerelddeel(werelddeel);
        landen = new ArrayList<>();
    }

    public void setWerelddeel(Werelddelen werelddeel) {
        this.werelddeel = werelddeel;
    }

    public String getWerelddeel() {
        return werelddeel.name();
    }

    public String getKaart() { return werelddeel.getKaart();};

    public void sorteerLanden() {
        Collections.sort(landen, new LandenComparator());
    }

    public void schudLanden() {
        Collections.shuffle(landen);
    }

    public void addLanden (String bestand) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(bestand);
        BestandenWerelddelen util = new BestandenWerelddelen();
        List<Land> landenWdl = util.leesWerelddelen(inputStream);
        landen.addAll(landenWdl);
    }

    public List<Land> getLanden() {
        return landen;
    }

    public class LandenComparator implements Comparator<Land> {
        public int compare(Land land, Land anderLand) {
            String eersteNaam = land.getNaam();
            String andereNaam = anderLand.getNaam();
            return eersteNaam.compareTo(andereNaam);
        }
    }

}
