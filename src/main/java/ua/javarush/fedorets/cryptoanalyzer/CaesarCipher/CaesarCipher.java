package ua.javarush.fedorets.cryptoanalyzer.CaesarCipher;


public class CaesarCipher {

    private static final int SHIFT = 3;
    public static String encrypt(String text) {

        StringBuilder encryptedText = new StringBuilder();

        text = text.toLowerCase();


        for (char symbol : text.toCharArray()) {

            int index = indexOf(symbol);

            if (index != -1) {
                int newIndex = (index + SHIFT) % CaesarAlphabet.CaeserAlphabet.length;
                encryptedText.append(CaesarAlphabet.CaeserAlphabet[newIndex]);
            } else {

                encryptedText.append(symbol);
            }
        }

        return encryptedText.toString();
    }

    private static int indexOf(char symbol) {
        for (int i = 0; i < CaesarAlphabet.CaeserAlphabet.length; i++) {
            if (CaesarAlphabet.CaeserAlphabet[i] == symbol) {
                return i;
            }
        }
        return -1;
    }
}

