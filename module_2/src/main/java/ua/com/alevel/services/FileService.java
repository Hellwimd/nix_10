package ua.com.alevel.services;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileService {
    private FileService(){}

    public static String readFile(String filePath) {
        StringBuilder textFromFile = new StringBuilder();

        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;
            textFromFile = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                textFromFile.append(line).append("\n");
            }

            reader.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return textFromFile.toString();
    }

    static public void writeFile(String fileText, String way, String fileName) {
        try {
            FileWriter writer = new FileWriter(way + fileName, false);
            writer.write(fileText);
            writer.flush();
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }

    }
}
