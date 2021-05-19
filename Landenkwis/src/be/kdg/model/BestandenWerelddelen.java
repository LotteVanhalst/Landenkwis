package be.kdg.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lotte Vanhalst
 * @version 1.0 19/02/2019 20:13
 */
public class BestandenWerelddelen {


    public void schrijfWerelddelen (List<Land> lijst, String bestand) throws IOException {
        String fileNaam = getClass().getResource(bestand).toString().replace("%20"," ").substring(6);
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileNaam);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));){
            for (Land land: lijst){
                writer.write(land.getWerelddeel());
                writer.write(" ");
                writer.write(land.getNaam().replace(" ", "_"));
                writer.write(" ");
                writer.write(land.getHoofdstad().replace(" ", "_"));
                writer.write(" ");
                writer.write(land.getKaart());
                writer.write(" ");
                writer.write(land.getVlag());
                writer.write(" ");
                writer.newLine();
            }
        } catch (IOException exc) {
            throw new IOException(String.format("Fout bij schrijven naar %s", bestand));
        }
    }

    public List<Land> leesWerelddelen(InputStream inputStream) throws IOException{
        List<Land> landen = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));){
            landen = new ArrayList<>();
            String line = reader.readLine();
            while (line != null){
                String[] land = line.split(" ");
                String werelddeel = land[0];
                String naam = land[1].replace("_", " ");
                String hoofdstad = land[2].replace("_", " ");
                String kaart = land[3];
                String vlag = land[4];
                landen.add(new Land(naam, werelddeel, hoofdstad, vlag, kaart));
                line = reader.readLine();
            } } catch (FileNotFoundException e) {
            throw new IOException(String.format("%s kan niet geopend worden!", inputStream));
        }
        return landen;
    }
}
