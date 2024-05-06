package ua.javarush.fedorets.cryptoanalyzer.CaesarCipher;

import ua.javarush.fedorets.cryptoanalyzer.file.FileCheck;
import ua.javarush.fedorets.cryptoanalyzer.file.FileProcessor;
import ua.javarush.fedorets.cryptoanalyzer.CaesarCipher.CaesarCipher;
import ua.javarush.fedorets.cryptoanalyzer.CaesarCipher.CaesarAlphabet;

import java.util.List;

/*
В данном классе создаю отдельную бизнес логику в котором объединяю реализацию всех ранее написанных классов.
 */

// Основной класс для обработки файлов с использованием шифра Цезаря
public class Coder {

    //проверка файлов
    private FileCheck fileCheck = new FileCheck();
    //работа с файлами
    private FileProcessor fileProcessor = new FileProcessor();
    //шифрование и дешифрование текста
    private CaesarCipher caesarCipher;

    // Конструктор инициализирует шифр Цезаря с алфавитом, определенным в CaesarAlphabet
    public Coder() {
        List<Character> alphabet = CaesarAlphabet.getAllSymbols();
        this.caesarCipher = new CaesarCipher(alphabet);
    }

    public void processFile(String inputFilePath, String outputFilePath, int key, boolean encrypt) {

        if (!fileCheck.isReadable(inputFilePath) || !fileCheck.isWritable(outputFilePath)) {
            System.out.println("Файл не доступен для чтения или записи.");
            return;
        }

        if (fileCheck.isInSystemDirectory(inputFilePath) || fileCheck.isInSystemDirectory(outputFilePath)) {
            System.out.println("Операции в системных директориях запрещены.");
            return;
        }

        List<String> lines = fileProcessor.readFromFile(inputFilePath);
        StringBuilder processedText = new StringBuilder();

        for (String line : lines) {
            processedText.append(encrypt ? caesarCipher.encrypt(line, key) : caesarCipher.decrypt(line, key));
            processedText.append(System.lineSeparator());
        }

        fileProcessor.writeToFile(outputFilePath, List.of(processedText.toString()));
    }
}