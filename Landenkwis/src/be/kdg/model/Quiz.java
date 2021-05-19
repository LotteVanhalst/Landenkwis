package be.kdg.model;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Lotte Vanhalst
 * @version 1.0 16/02/2019 15:46
 */
public class Quiz extends Spel {
    private String naamSpeler;
    private List<Highscore> highscores;

    public Quiz() {
    }

    public Quiz(Werelddeel werelddeel, Type type, String naamSpeler) {
        super(werelddeel, type);
        setNaamSpeler(naamSpeler);
        highscores = new ArrayList<>();
    }

    private void setNaamSpeler(String naamSpeler) {
        this.naamSpeler = naamSpeler;
    }

    public String getNaamSpeler() {
        return naamSpeler;
    }

    public List<Highscore> getHigscores() {
        return highscores;
    }

    public void schrijfHighscores (List<Highscore> lijst, String bestand) throws IOException {
        String fileNaam = getClass().getResource(bestand).toString().replace("%20"," ").substring(6);
        try (FileOutputStream fileOutputStream = new FileOutputStream (fileNaam);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));){
            for (Highscore highscore: lijst) {
                writer.write(highscore.getNaamScore());
                writer.write(" ");
                writer.write(highscore.getNaamSpeler());
                writer.write(" ");
                writer.write(String.valueOf(highscore.getScore()));
                writer.write(" ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String date = highscore.getDatum().format(formatter);
                writer.write(date);
                writer.write(" ");
                writer.newLine();
            }
        } catch (IOException exc) {
            throw new IOException("Fout bij schrijven naar " + bestand);
        }
    }

    public List<Highscore> leesHighscores(InputStream inputStream) throws IOException{
        List<Highscore> highscores = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));){
            highscores = new ArrayList<>();
            String line = reader.readLine();
            while (line != null){
                String[] topscore = line.split(" ");
                String naamScore = topscore[0];
                String naamSpeler = topscore[1];
                int score = Integer.parseInt(topscore[2]);
                String stringDatum = topscore[3];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate datum = LocalDate.parse(stringDatum, formatter);
                highscores.add(new Highscore(naamScore, naamSpeler, score, datum));
                line = reader.readLine();
            } } catch (FileNotFoundException e) {
            throw new IOException(String.format("%s kan niet geopend worden!", inputStream));
        }
        return highscores;
    }


    public void addHighscores (String bestand) throws IOException {
        InputStream inputstream = getClass().getResourceAsStream(bestand);
        List<Highscore> scores = leesHighscores(inputstream);
        highscores.addAll(scores);
    }


    public void registreerHighscore(InputStream inputStream, String nieuweNaam, int nieuweScore, String bestand) throws IOException {
        List<Highscore> lijst = new ArrayList<>();
        Highscore nieuweTopscore = new Highscore("", nieuweNaam, nieuweScore, LocalDate.now());
        lijst.addAll(leesHighscores(inputStream));
        for(int i=0; i<10; i++){
            if (nieuweTopscore.getScore() > lijst.get(i).getScore()) {
                Highscore oudeScore = lijst.get(i);
                nieuweTopscore.setNaamScore("Highscore" + i);
                lijst.set(i, nieuweTopscore);
                nieuweTopscore = oudeScore;
            }
        }
        schrijfHighscores(lijst, bestand);
    }


    public String toonOplossing(Werelddeel wereldddeel, Type type, int i) {
        String oplossing = null;
        switch (type){
            case LANDEN: oplossing = wereldddeel.getLanden().get(i).getNaam();
                break;
            case HOOFDSTEDEN: oplossing = wereldddeel.getLanden().get(i).getHoofdstad();
                break;
            case VLAGGEN: oplossing = wereldddeel.getLanden().get(i).getNaam();
                break;
        }
        return oplossing;
    }

}



