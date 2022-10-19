public class ConsoleWriter implements Writer {

    @Override
    public boolean consoleWrite(Response response){
        // Write message in console
        if (response instanceof ResponseWithError) {
            System.out.println("Error: " + response.getAnswer());
            return false;
        }
        System.out.println(response.getAnswer());
        return true;
    }
}