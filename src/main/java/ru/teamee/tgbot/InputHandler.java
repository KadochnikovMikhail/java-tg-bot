package ru.teamee.tgbot;

import ru.teamee.tgbot.IInputHandler;

public class InputHandler implements IInputHandler {
    public ResponseStructure takeData(RequestStructure obj) {
        ResponseStructure response = new ResponseStructure();       // Метод берет ru.teamee.tgbot.RequestStructure, проверяет пустая ли
        if (obj.requestString.equals("")) {                         // строка в нем и возвращает ru.teamee.tgbot.ResponseStructure
            response.ifError = true;                                // с соответсвующим флагом.
        }
        response.responseStroke = obj.requestString;
        return response;
    }
}
