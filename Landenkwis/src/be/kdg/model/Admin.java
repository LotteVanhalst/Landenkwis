package be.kdg.model;

import java.io.*;
import java.util.*;

/**
 * @author Lotte Vanhalst
 * @version 1.0 16/02/2019 15:44
 */
public class Admin{
    private List<Administrator> admins;

    public Admin() {
        admins = new ArrayList<>();
    }

    public List<Administrator> getAdministrators() {
        return admins;
    }

    public void voegLandToe(List<Land> landen, Land nieuwLand, String bestand) throws RuntimeException, IOException {
        int getal = 0;
        for (Land land : landen) {
            if (nieuwLand.getNaam().equals(land.getNaam())) {
                getal++;
                throw new RuntimeException(String.format("%s bestaat al", nieuwLand.getNaam()));
            }
        }
            if(getal==0){
                landen.add(nieuwLand);
            }
            BestandenWerelddelen schrijfWeg = new BestandenWerelddelen();
            schrijfWeg.schrijfWerelddelen(landen, bestand);
    }

    public void pasWerelddeelAan (List<Land> landen, Land nieuwLand, Land land, String bestand) throws LandenAanpassenException, IOException {
        if (!landen.contains(land)){
            throw new LandenAanpassenException(land.getNaam());
        }
        int aanpassenLand = landen.indexOf(land);
        landen.set(aanpassenLand, nieuwLand);
        BestandenWerelddelen schrijfWeg = new BestandenWerelddelen();
        schrijfWeg.schrijfWerelddelen(landen, bestand);
    }

    public void verwijderLand (List<Land> landen, String naamLand, String bestand) throws LandenAanpassenException, IOException {
        Land nieuwLand = null;
        for (Land land: landen){
            if (naamLand.equals(land.getNaam())){
                nieuwLand = land;
            }
        }
        if (nieuwLand == null){
            throw new LandenAanpassenException(naamLand);
        } else {
            landen.remove(nieuwLand);
            BestandenWerelddelen schrijfWeg = new BestandenWerelddelen();
            schrijfWeg.schrijfWerelddelen(landen, bestand);
        }
    }

    public void schrijfWachtwoorden (List<Administrator> admins) throws IOException {
        String fileNaam = getClass().getResource("/bestanden/admin.txt").toString().replace("%20"," ").substring(6);
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileNaam);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));){
            for (Administrator administrator : admins){
                writer.write(administrator.getNaam());
                writer.write(" ");
                writer.write(administrator.getWachtwoord());
                writer.newLine();
            }
        } catch (IOException exc) {
            throw new IOException(String.format("Fout bij schrijven naar %s", "/bestanden/admin.txt"));
        }
    }

    public List<Administrator> leesWachtwoorden(String bestand) throws IOException{
        InputStream inputStream = getClass().getResourceAsStream(bestand);
        List<Administrator> admins = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));){
            admins = new ArrayList<>();
            String line = reader.readLine();
            while (line != null){
                String[] admin = line.split(" ");
                String naam = admin[0];
                String wachtwoord = admin[1];
                admins.add(new Administrator(naam, wachtwoord));
                line = reader.readLine();
            } } catch (FileNotFoundException e) {
            throw new IOException(String.format("%s kan niet geopend worden!", bestand));
        }
        return admins;
    }

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

}

