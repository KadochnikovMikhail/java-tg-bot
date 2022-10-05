package ru.teamee.tgbot;

public class Main {
    public static void main(String[] args) {            // создаем экземпляры классов, с которыми работаем для чтения и
        ConsoleReader r1 = new ConsoleReader();         // написания в консоль
        ConsoleWriter w1 = new ConsoleWriter();
        InputHandler h1 = new InputHandler();
        boolean flag = true;
        while (flag) {
            RequestStructure data = r1.consoleRead();   // При помощи метода consoleRead класса  ru.teamee.tgbot.ConsoleReader читаем
            flag = w1.consoleWrite(h1.takeData(data));  // сообщение из консоли и передаем его в структуру
        }                                               // ru.teamee.tgbot.RequestStructure. Используем класс обработчик поступающей
    }                                                   // информации ru.teamee.tgbot.InputHandler и его метод takeData, который
}                                                       // возвращает структуру ru.teamee.tgbot.ResponseStructure. Потом метод
// consoleWrite класса ru.teamee.tgbot.ConsoleWriter достает из переданной ему
// структуры сообщение и выводит его на консоль.