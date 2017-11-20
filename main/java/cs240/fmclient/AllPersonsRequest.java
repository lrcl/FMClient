package cs240.fmclient;


class AllPersonsRequest extends Request {
    String authToken;
    public AllPersonsRequest(String authToken) {
        this.authToken = authToken;
    }
}
