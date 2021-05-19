package be.kdg.model;

/**
 * @author Lotte Vanhalst
 * @version 1.0 16/02/2019 21:10
 */
public class LandenAanpassenException extends Exception{
    public LandenAanpassenException(){
        super();
    }

    public LandenAanpassenException(String className){
        super(String.format("%s staat niet in de lijst.", className));
    }
}
