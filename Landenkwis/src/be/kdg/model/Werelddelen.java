package be.kdg.model;


/**
 * @author Lotte Vanhalst
 * @version 1.0 16/02/2019 15:48
 */
public enum Werelddelen {
    AFRIKA("/afbeeldingen/kaarten/AFRIKA.png"),
    AMERIKA ("/afbeeldingen/kaarten/AMERIKA.png"),
    AZIE("/afbeeldingen/kaarten/AZIE.png"),
    EUROPA("/afbeeldingen/kaarten/EUROPA.png"),
    OCEANIE("/afbeeldingen/kaarten/OCEANIE.png");

    private String kaart;


    Werelddelen(String kaart) {
        setKaart(kaart);
    }


    public void setKaart(String kaart) {
        this.kaart = kaart;
    }

    public String getKaart() {
        return kaart;
    }
}
