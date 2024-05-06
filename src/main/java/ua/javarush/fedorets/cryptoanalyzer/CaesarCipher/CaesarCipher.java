package ua.javarush.fedorets.cryptoanalyzer.CaesarCipher;

import java.util.List;

/*
В данном классе создаю логику шифрования методом Цезаря при использовании ранее созданного алфавита.
 */
public class CaesarCipher {
    private final List<Character> alphabet;
    public CaesarCipher(List<Character> alphabet) {
        this.alphabet = alphabet;
    }
    public String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = Character.toLowerCase(text.charAt(i));
            int index = alphabet.indexOf(currentChar);
            if (index != -1) {
                int encryptedIndex = (index + key) % alphabet.size();
                char encryptedChar = alphabet.get(encryptedIndex);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(currentChar);
            }
        }
        return encryptedText.toString();
    }

    public String decrypt(String text, int key) {
        return encrypt(text, -key);
    }

    public int getAlphabetSize() {
        return alphabet.size(); // Возвращает размер алфавита
    }
}

