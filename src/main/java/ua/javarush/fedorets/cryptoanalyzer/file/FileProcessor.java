package ua.javarush.fedorets.cryptoanalyzer.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileProcessor {

    /*
    В данном методе я реализовываю бизнес логику работы с файлами.
    Для этого использую Path для представления пути к файлу и Files для операций с файлом.
    readFromFile считывание файла который шифрую, а writeToFile записываю результат шифрования
    Также использую исключение  RuntimeException для предотвращения некорректной работы readFromFile и writeToFile.
     */
    public List<String> readFromFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать файл: " + filePath, e);
        }
    }

    public void writeToFile(String filePath, List<String> data) {
        Path path = Paths.get(filePath);

        try {
            Files.write(path, data);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось записать в файл: " + filePath, e);
        }
    }
}
