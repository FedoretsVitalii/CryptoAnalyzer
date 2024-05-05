package ua.javarush.fedorets.cryptoanalyzer.file;

import java.io.*;
public class FileProcessor {


    private static final int BUFFER_SIZE = 8192;

    public static String readFile(String filePath) throws IOException {

        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            char[] buffer = new char[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = reader.read(buffer)) != -1) {
                content.append(buffer, 0, bytesRead);
            }
        }

        return content.toString();
    }

    public static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

}
