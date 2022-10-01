public class InputHandler implements IInputHandler{
    public ResponseStructure takeData(RequestStructure obj) {
        ResponseStructure response = new ResponseStructure();       // Метод берет RequestStructure, проверяет пустая ли
        if (obj.requestString.equals("")) {                         // строка в нем и возвращает ResponseStructure
            response.ifError = true;                                // с соответсвующим флагом.
        }
        response.responseStroke = obj.requestString;
        return response;
    }
}
