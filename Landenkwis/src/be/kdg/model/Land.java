package be.kdg.model;

/**
 * @author Lotte Vanhalst
 * @version 1.0 16/02/2019 15:45
 */
public class Land {
    private String naam;
    private String vlag;
    private String hoofdstad;
    private String kaart;
    private String werelddeel;

    public Land(String naam, String werelddeel, String hoofdstad, String vlag, String kaart) {
        setNaam(naam);
        setVlag(vlag);
        setHoofdstad(hoofdstad);
        setKaart(kaart);
        setWerelddeel(werelddeel);
    }

    private void setNaam(String naam) {
        this.naam = naam;
    }

    private void setVlag(String vlag) {
        this.vlag = vlag;
    }

    private void setHoofdstad(String hoofdstad) {
        this.hoofdstad = hoofdstad;
    }

    private void setWerelddeel(String werelddeel) {
        this.werelddeel = werelddeel;
    }

    private void setKaart(String kaart) {
        this.kaart = kaart;
    }

    public String getNaam() {
        return naam;
    }

    public String getVlag() {
        return vlag;
    }

    public String getHoofdstad() {
        return hoofdstad;
    }

    public String getKaart() {
        return kaart;
    }

    public String getWerelddeel() {
        return werelddeel.toString();
    }

    public void pasLandAan (String naam, String vlag, String hoofdstad, String werelddeel){
        this.naam = naam;
        this.vlag = vlag;
        this.hoofdstad = hoofdstad;
        this.werelddeel = werelddeel;
    }
}
