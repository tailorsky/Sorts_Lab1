package com.tlr.sorts;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader {
    public static List<double[]> readCSV(String filePath) {
        List<double[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean isHeader = true; 
            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                double[] values = new double[line.length];
                for (int i = 0; i < line.length; i++) {
                    try {
                        values[i] = Double.parseDouble(line[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка преобразования строки: " + line[i]);
                        values[i] = Double.NaN;
                    }
                }
                data.add(values);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return data;
    }
}
