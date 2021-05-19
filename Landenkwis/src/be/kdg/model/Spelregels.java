package be.kdg.model;

import java.io.*;

/**
 * @author Lotte Vanhalst
 * @version 1.0 3/03/2019 0:59
 */
public class Spelregels {

    public String toonSpelregels() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/bestanden/spelregels.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));) {
            StringBuilder tekstRegels = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                tekstRegels.append("\t").append(line).append("\n");
                line = reader.readLine();
            }
            return tekstRegels.toString();
        } catch (FileNotFoundException e) {
            throw new IOException(String.format("%s kan niet geopend worden!", inputStream));
        }
    }
}