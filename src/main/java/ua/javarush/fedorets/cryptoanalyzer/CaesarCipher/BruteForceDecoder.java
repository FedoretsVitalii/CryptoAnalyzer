package ua.javarush.fedorets.cryptoanalyzer.CaesarCipher;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * класс в котором происходит взлом зашифрованного текста не имея ключа для дешифрования
 */
public class BruteForceDecoder {
    private CaesarCipher caesarCipher;
    private List<String> dictionary;

    /**
     * Конструктор класса BruteForceDecoder.
     */

    public BruteForceDecoder(CaesarCipher caesarCipher, List<String> dictionary) {
        this.caesarCipher = caesarCipher;
        this.dictionary = dictionary;
    }

    /**
     * Проверка, содержит ли текст достаточное количество знакомых слов из словаря.
     */
    private boolean isTextValid(String text) {
        String[] words = text.toLowerCase().split("\\W+");
        int matchingWords = 0;

        for (String word : words) {
            if (dictionary.contains(word)) {
                matchingWords++;
            }
        }
        // Проверка, соответствует ли количество найденных слов пороговому значению
        return matchingWords > (words.length * 0.3);
    }

    /**
     * Перебираются все возможные ключи и возвращает дешифрованный текст с предполагаемым правильным ключом.
     */
    public String decode(String encryptedText) {

        int alphabetSize = caesarCipher.getAlphabetSize();

        for (int key = 1; key < alphabetSize; key++) {

            String decryptedText = caesarCipher.decrypt(encryptedText, key);

            if (isTextValid(decryptedText)) {
                System.out.println("Предполагаемый ключ: " + key);
                return decryptedText;
            }
        }

        return "Не удалось найти подходящий ключ для расшифровки текста методом brute force.";
    }

    /**
     * Вспомогательный метод для создания словаря из часто встречающихся слов.
     *
     * @return List<String> Список знакомых слов, которые будут использоваться для проверки расшифрованного текста.
     */
    public static List<String> createDefaultDictionary() {
        return new ArrayList<>(Arrays.asList(
                "и", "в", "на", "что", "с", "он", "она", "они", "мы", "ты",
                "это", "как", "да", "нет", "не", "есть", "у", "его", "её", "их",
                "от", "по", "за", "из", "о", "к", "до", "через", "при"
        ));
    }
}

