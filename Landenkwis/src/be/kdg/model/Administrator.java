package be.kdg.model;

/**
 * @author Lotte Vanhalst
 * @version 1.0 21/02/2019 19:33
 */
public class Administrator {
    private String naam;
    private String wachtwoord;

    public Administrator(String naam, String wachtwoord) {
        setNaam(naam);
        setWachtwoord(wachtwoord);
    }

    private void setNaam(String naam) {
        this.naam = naam;
    }

    private void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getNaam() {
        return naam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }
}
