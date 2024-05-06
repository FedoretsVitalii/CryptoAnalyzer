package ua.javarush.fedorets.cryptoanalyzer.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileCheck {

    /*
         В данном классе проводиться проверка на правильность записи файла,
         для того что бы пользователь не записал файл в системные папки.
     */

/*
    Конструкция Arrays.asList(...) создает список на основе массива,
    которые передаются в качестве аргументов в эту функцию.
 */
    private static final List<String> SYSTEM_DIRECTORIES = Arrays.asList(
            "C:\\Windows",           // Стандартная системная папка Windows
            "C:\\Program Files",     // Стандартная папка для установленных программ Windows
            "/bin", "/sbin",         // Системные папки Unix/Linux для исполняемых файлов
            "/usr/bin", "/usr/sbin"  // Дополнительные системные папки Unix/Linux
    );

//метод fileExists проверяет, существует ли файл по указанному пути.
    public boolean fileExists(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }
    //метод isReadable проверяет, доступен ли файл для чтения
    public boolean isReadable(String filePath) {
        Path path = Paths.get(filePath);
        return Files.isReadable(path);
    }
    //метод isWritable проверяет, доступен ли файл для записывания
    public boolean isWritable(String filePath) {
        Path path = Paths.get(filePath);
        return Files.isWritable(path);
    }

    //В этом методе проходит проверка, находиться ли путь файла в одной из директорий
    public boolean isInSystemDirectory(String filePath) {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        String pathStr = path.toString();
        for (String systemDir : SYSTEM_DIRECTORIES) {
            if (pathStr.startsWith(systemDir)) {
                return true;
            }
        }
        return false;
    }
}


