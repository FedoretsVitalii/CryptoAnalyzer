package ua.javarush.fedorets.cryptoanalyzer;

import ua.javarush.fedorets.cryptoanalyzer.view.ConsoleView;

public class ConsoleLaunchApp {
    public static void main(String[] args) {

    // Создание нового диалога с пользователем

        ConsoleView consoleView = new ConsoleView();

    // Запуск диалога с пользователем
        consoleView.start();


    }
}
/*
    Для класса ConsoleLaunchApp было принято оставить всего две команды.
    Попытка создать приложение по принципу SOLID.
 */