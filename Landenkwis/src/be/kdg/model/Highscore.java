package be.kdg.model;


import java.time.LocalDate;

/**
 * @author Lotte Vanhalst
 * @version 1.0 19/02/2019 20:29
 */
public class Highscore {
    private String naamScore;
    private String naamSpeler;
    private LocalDate datum;
    private int score;

    public Highscore(String naam) {
        this(naam,"O",0, null);
    }

    public Highscore(String naamScore, String naamSpeler, int score, LocalDate datum) {
        setNaamScore(naamScore);
        setNaamSpeler(naamSpeler);
        setScore(score);
        setDatum(datum);
    }

    public void setNaamScore (String naamScore) {
        this.naamScore = naamScore;
    }

    public void setNaamSpeler(String naamSpeler) {
        this.naamSpeler = naamSpeler;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNaamScore() {
        return naamScore;
    }

    public String getNaamSpeler() {
        return naamSpeler;
    }

    public int getScore() {
        return score;
    }

    public LocalDate getDatum() {
        return datum;
    }
}
