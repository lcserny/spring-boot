package com.cserny.test.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonardo on 13.03.2016.
 */
public class CsvParser
{
    private static final String DELIMITER = ";";

    public List<String> parseCsv()
    {
        List<String> csvArray = new ArrayList<String>();
        BufferedReader reader = null;

        try {
            String line;
            reader = new BufferedReader(new FileReader("src/main/resources/feed.csv"));

            while ((line = reader.readLine()) != null) {
                String rawLine = "Raw CSV data: " + line;
                String parsedLine = "Converted ArrayList data: " + convertCsvToArrayList(line) + "<br>";

                csvArray.add(rawLine);
                csvArray.add(parsedLine);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return csvArray;
    }

    public static List<String> convertCsvToArrayList(String csv)
    {
        List<String> csvResult = new ArrayList<String>();
        if (csv != null) {
            String[] splitData = csv.split("\\s*" + DELIMITER + "\\s*");
            for (int i = 0; i < splitData.length; i++) {
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    csvResult.add(splitData[i].trim());
                }
            }
        }
        return csvResult;
    }
}
