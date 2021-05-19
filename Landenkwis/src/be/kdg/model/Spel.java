package be.kdg.model;


/**
 * @author Lotte Vanhalst
 * @version 1.0 16/02/2019 15:46
 */
public abstract class Spel {
    private Werelddeel werelddeel;
    private Type type;


    public Spel() {
    }

    public Spel(Werelddeel werelddeel, Type Type) {
        setWerelddeel(werelddeel);
        setType(type);
    }

    private void setWerelddeel(Werelddeel werelddeel) {
        this.werelddeel = werelddeel;
    }

    public Werelddeel getWerelddeel() {
        return werelddeel;
    }

    public Type getType() {
        return type;
    }

    private void setType(Type type) {
        this.type = type;
    }

    public abstract String toonOplossing(Werelddeel werelddeel, Type type, int oplossing);

    public Werelddelen bepaalWerelddeel(String werelddeel) {
        Werelddelen wdl = null;
        switch (werelddeel) {
            case "AFRIKA":
                wdl = Werelddelen.AFRIKA;
                break;
            case "AMERIKA":
                wdl = Werelddelen.AMERIKA;
                break;
            case "AZIE":
                wdl = Werelddelen.AZIE;
                break;
            case "EUROPA":
                wdl = Werelddelen.EUROPA;
                break;
            case "OCEANIE":
                wdl = Werelddelen.OCEANIE;
                break;
        };
        return wdl;
    }

    public Type bepaalType(String type) {
        Type spel = null;
        switch (type) {
            case "LANDEN":
                spel = Type.LANDEN;
                break;
            case "HOOFDSTEDEN":
                spel = Type.HOOFDSTEDEN;
                break;
            case "VLAGGEN":
                spel = Type.VLAGGEN;
                break;
        };
        return spel;
    }

}
