public class ConsoleWriter implements IConsoleWriter{                       // Просто коммент для пуллреквеста
    public boolean consoleWrite(ResponseStructure response){
        if (response.ifError) {                                             // Метод consoleWrite принмает на вход уже
            System.out.println("Error");                                    // обработанную структуру, проверяет флаг
            return false;                                                   // ifError, который дает знать, что строка
        }                                                                   // пустая. Если пустая, то пишет в консоль
        else {                                                              // "Error" и возвращает false (что означает,
            System.out.println("Your text:" + response.responseStroke);     // прекращение цикла), если же не пустая,
            return true;                                                    // то выводит напечатанный текст и
        }                                                                   // возвращает true для продолжения цикла.
    }
}
