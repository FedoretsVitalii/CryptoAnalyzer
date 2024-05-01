package ua.javarush.fedorets.cryptoanalyzer.CaesarCipher;

public class CaesarAlphabet {

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
            '@', '#', '№', '$', '^', '&', '(', ')', '_', '-', '+',
            '=', '\'', '|', '{', '}'
    };

    private static final char[] CeaserAlphabet = new char[ALPHABET_RU.length + Numbers.length + Punctuation.length];


}
