package ua.javarush.fedorets.cryptoanalyzer.view;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import ua.javarush.fedorets.cryptoanalyzer.CaesarCipher.CaesarCipher;
import ua.javarush.fedorets.cryptoanalyzer.CaesarCipher.CaesarAlphabet;
import ua.javarush.fedorets.cryptoanalyzer.CaesarCipher.BruteForceDecoder;
import ua.javarush.fedorets.cryptoanalyzer.CaesarCipher.Coder;
import ua.javarush.fedorets.cryptoanalyzer.file.FileProcessor;

/*
В данном классе реализован процесс взаимодействия с пользователем через консоль.
 */
public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);
    private Coder coder;
    private FileProcessor fileProcessor;

    /**
     * Конструктор ConsoleView: инициализирует объекты для работы с кодированием.
     */
    public ConsoleView() {
        this.coder = new Coder();
    }

    // Метод start запускает основной цикл интерфейса пользователя.
    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nДобро пожаловать в CryptoAnalyzer!");
            System.out.println("Выберите операцию:");
            System.out.println("1: Шифрование файла");
            System.out.println("2: Дешифрование файла");
            System.out.println("3: Brute force дешифровка");
            System.out.println("4: Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистить буфер после чтения числа.

            switch (choice) {
                case 1:
                    encryptFile();
                    break;
                case 2:
                    decryptFile();
                    break;
                case 3:
                    bruteForceDecrypt();
                    break;
                case 4:
                    System.out.println("Программа завершена.");
                    running = false;
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, введите число от 1 до 4.");
                    break;
            }
        }
    }

    /**
     * Метод encryptFile выполняет процесс шифрования файла на основе пользовательского ввода.
     */
    private void encryptFile() {
        System.out.println("Введите путь к файлу для шифрования:");
        String inputPath = scanner.nextLine();
        System.out.println("Введите путь для сохранения зашифрованного файла:");
        String outputPath = scanner.nextLine();
        System.out.println("Введите ключ шифрования:");
        int key = scanner.nextInt();
        scanner.nextLine();

        coder.processFile(inputPath, outputPath, key, true);

        System.out.println("Шифрование выполнено успешно. Проверьте зашифрованный файл.");
        System.out.println("Возвращение в главное меню...");
    }

    /**
     * Метод decryptFile выполняет процесс дешифрования файла на основе пользовательского ввода.
     */
    private void decryptFile() {
        System.out.println("Введите путь к файлу для дешифрования:");
        String inputPath = scanner.nextLine();
        System.out.println("Введите путь для сохранения дешифрованного файла:");
        String outputPath = scanner.nextLine();
        System.out.println("Введите ключ дешифрования:");
        int key = scanner.nextInt();
        scanner.nextLine();

        coder.processFile(inputPath, outputPath, key, false);

        System.out.println("Дешифрование выполнено успешно. Проверьте дешифрованный файл.");
        System.out.println("Возвращение в главное меню...");
    }

    /**
     * Метод bruteForceDecrypt выполняет дешифрование методом brute force, пытаясь подобрать ключ.
     */
    private void bruteForceDecrypt() {

        System.out.println("Введите путь к файлу для расшифровки методом brute force:");
        String inputPath = scanner.nextLine();

        System.out.println("Введите путь для сохранения результатов дешифровки:");
        String outputPath = scanner.nextLine();

        try {
            String encryptedText = String.join("\n", fileProcessor.readFromFile(inputPath));

            BruteForceDecoder decoder = new BruteForceDecoder(new CaesarCipher(CaesarAlphabet.getAllSymbols()), BruteForceDecoder.createDefaultDictionary());

            String result = decoder.decode(encryptedText);

            System.out.println("Результат brute force дешифровки:");
            System.out.println(result);

            fileProcessor.writeToFile(outputPath, Arrays.asList(result.split("\n")));
            System.out.println("Расшифрованный текст успешно сохранен в: " + outputPath);
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }


}

