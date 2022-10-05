package ru.teamee.tgbot;

import java.util.Scanner;
public class ConsoleReader implements IConsoleReader {

    ConsoleReader(){}

    public RequestStructure consoleRead(){
        RequestStructure data = new RequestStructure();     // Припомощи сканнера считываем строку и кладем ее в
        Scanner in = new Scanner(System.in);                // структуру ru.teamee.tgbot.RequestStructure.
        System.out.print("Input: ");                        // Сам же метод consoleRead возвращает эту структуру.
        data.requestString = in.nextLine();

        return data;
    }
}