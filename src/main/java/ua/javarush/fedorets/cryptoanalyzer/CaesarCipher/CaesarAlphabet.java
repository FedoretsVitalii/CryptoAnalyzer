package ua.javarush.fedorets.cryptoanalyzer.CaesarCipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    В данном классе создаю отдельный алфавит для дальнейшего использования в шифре.
 */
public class CaesarAlphabet {
    private static final List<Character> ALL_SYMBOLS = new ArrayList<>();

// Блок статической инициализации
    static {
        addAllSymbols(Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
                'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
                'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'ъ', 'ы', 'ь', 'э', 'ю', 'я'
        ));
        addAllSymbols(Arrays.asList(
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'
        ));
        addAllSymbols(Arrays.asList(
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
        ));
        addAllSymbols(Arrays.asList(
                ' ', '.', ',', '!', '?', ':', ';', '*', '<', '>',
                '@', '#', '№', '$', '^', '&', '(', ')', '_', '-',
                '+', '=', '\'', '|', '{', '}'
        ));
    }
    public static List<Character> getAllSymbols() {
        return new ArrayList<>(ALL_SYMBOLS);
    }
    private static void addAllSymbols(List<Character> symbols) {
        ALL_SYMBOLS.addAll(symbols);
    }
}
