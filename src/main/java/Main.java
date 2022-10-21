public class Main {
    public static void main(String[] args) {
        Writer consoleWriter = new ConsoleWriter();
        Reader consoleReader = new ConsoleReader(consoleWriter);
        Handler inputHandler = new InputHandler();
        boolean isBotRunning = true;
        while (isBotRunning) {
            Request data = consoleReader.read();
            isBotRunning = consoleWriter.consoleWrite(inputHandler.handleRequest(data));

        }
    }
}

