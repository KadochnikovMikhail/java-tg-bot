public class InputHandler implements Handler {
    private static final String EMPTY_STROKE = "";
    ResponseWithError EMPTY_INPUT_RESPONSE = new ResponseWithError("input can not be empty");

    public Response handleRequest(Request request) {
        // Check if stroke from console was empty then return Response
        String requestText = request.getMessage();
        return EMPTY_STROKE.equals(requestText) ? EMPTY_INPUT_RESPONSE : new Response(requestText);
    }
}
