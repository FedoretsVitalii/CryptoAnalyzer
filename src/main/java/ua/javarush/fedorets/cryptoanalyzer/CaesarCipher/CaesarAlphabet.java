package ua.javarush.fedorets.cryptoanalyzer.CaesarCipher;

public class CaesarAlphabet {

    /*
       private static final char[] ALPHABET_RU_GROSS = {
                'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
                'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р',
                'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
                'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',
        };

    */

        private static final char[] ALPHABET_RU = {
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
                'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
                'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'ъ', 'ы', 'ь', 'э', 'ю', 'я',
        };

        private static final char[] Numbers = {
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
        };

        private static final char[] Punctuation = {
                ' ', '.', ',', '!', '?', ':', ';', '*', '<', '>',
                '@', '#', '№', '$', '^', '&', '(', ')', '_', '-',
                '+', '=', '\'', '|', '{', '}',
        };

        public static final char[] CaeserAlphabet;

        static {
            int length = ALPHABET_RU.length + Numbers.length + Punctuation.length;
            CaeserAlphabet = new char[length];
            int index = 0;

            for (char ch : ALPHABET_RU) {
                CaeserAlphabet[index++] = ch;
            }

            for (char ch : Numbers) {
                CaeserAlphabet[index++] = ch;
            }

            for (char ch : Punctuation) {
                CaeserAlphabet[index++] = ch;
            }
        }

// Динамический сдвиг алфавита

    public static void shiftAlphabet(int shift) {
        char[] shiftedAlphabet = new char[CaeserAlphabet.length];
        for (int i = 0; i < CaeserAlphabet.length; i++) {
            int newIndex = (i + shift) % CaeserAlphabet.length;
            shiftedAlphabet[newIndex] = CaeserAlphabet[i];
        }
        System.arraycopy(shiftedAlphabet, 0, CaeserAlphabet, 0, CaeserAlphabet.length);
    }

}
