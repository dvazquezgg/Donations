package mx.edu.greengates.cs.utils;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadCSV {

    private String fileName;
    private List<List<String>> records;
    public static final String COMMA_DELIMITER = ",";

    public ReadCSV(String fileName) {
        this.fileName = fileName;
        this.records = new ArrayList<>();
    }

    public List<List<String>> getRecords() {
        return records;
    }

    public void read() {
        System.out.println("Reading file: " + this.fileName);
        // Reading file: data.csv

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(this.fileName).getFile());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + this.fileName);
            System.out.println(e.getMessage());
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();

        // Regular expression to match either quoted or non-quoted fields
        Pattern pattern = Pattern.compile("(?:\"([^\"]*)\"|([^\",]*))" + Pattern.quote(COMMA_DELIMITER));
        Matcher matcher = pattern.matcher(line + COMMA_DELIMITER); // Adding COMMA_DELIMITER at the end to match the last field

        while (matcher.find()) {
            String value = matcher.group(1);
            if (value == null) {
                value = matcher.group(2);
            }
            values.add(value);
        }
        return values;
    }


}
