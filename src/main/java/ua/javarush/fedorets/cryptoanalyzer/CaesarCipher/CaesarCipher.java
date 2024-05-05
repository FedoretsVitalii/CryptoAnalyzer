package ua.javarush.fedorets.cryptoanalyzer.CaesarCipher;


public class CaesarCipher {

    public static String encrypt(String text, int shift) {

        CaesarAlphabet.shiftAlphabet(shift); // Применяем динамический сдвиг алфавита

        StringBuilder encryptedText = new StringBuilder();

        text = text.toLowerCase();

        for (char symbol : text.toCharArray()) {

            int index = indexOf(symbol);

            if (index != -1) {

                int newIndex = (index + shift) % CaesarAlphabet.CaeserAlphabet.length;
                encryptedText.append(CaesarAlphabet.CaeserAlphabet[newIndex]);
            } else {
                encryptedText.append(symbol);
            }
        }
        return encryptedText.toString();
    }


    public static String decrypt(String encryptedText, int shift) {

        CaesarAlphabet.shiftAlphabet(shift);

        StringBuilder decryptedText = new StringBuilder();

        for (char symbol : encryptedText.toCharArray()) {

            int index = indexOf(symbol);

            if (index != -1) {

                int newIndex = (index - shift + CaesarAlphabet.CaeserAlphabet.length) % CaesarAlphabet.CaeserAlphabet.length;
                decryptedText.append(CaesarAlphabet.CaeserAlphabet[newIndex]);
            } else {

                decryptedText.append(symbol);
            }
        }

        return decryptedText.toString();
    }

// Метод для динамического сдвига алфавита Цезаря на определенное количество позиций.
    private static int indexOf(char symbol) {

        for (int i = 0; i < CaesarAlphabet.CaeserAlphabet.length; i++) {

            if (CaesarAlphabet.CaeserAlphabet[i] == symbol) {
                return i;
            }
        }
        return -1;
    }
}

