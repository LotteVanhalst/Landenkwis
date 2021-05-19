package be.kdg.model;

/**
 * @author Lotte Vanhalst
 * @version 1.0 16/02/2019 15:45
 */
public class Oefening extends Spel{
    private String tip;

    public Oefening(Werelddeel werelddeel, Type type) {
        super(werelddeel, type);
    }

    public String toonOplossing(Werelddeel werelddeel, Type type, int i) {
        String oplossing = null;
        switch (type){
            case LANDEN: oplossing = werelddeel.getLanden().get(i).getNaam();
                break;
            case HOOFDSTEDEN: oplossing = werelddeel.getLanden().get(i).getHoofdstad();
                break;
            case VLAGGEN: oplossing = werelddeel.getLanden().get(i).getNaam();
                break;
        }
        return oplossing;
    }

    public String toonTipLand (Land land, int input){
        StringBuilder volledigeTip = new StringBuilder();
        for (int i=0; i < input; i++) {
            volledigeTip.append(land.getNaam().charAt(i));
        }
        tip = volledigeTip.toString();
        return tip;
    }

    public String toonTipHoofdstad(String hoofdstad, int input){
        StringBuilder volledigeTip = new StringBuilder();
        for (int i=0; i < input + 1; i++) {
            volledigeTip.append(hoofdstad.charAt(i));
        }
        tip = volledigeTip.toString();
        return tip;
    }
}

