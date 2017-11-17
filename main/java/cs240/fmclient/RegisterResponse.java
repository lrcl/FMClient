package cs240.fmclient;

public class RegisterResponse extends Response {
    /** auth token */
    private String authToken;
    /** newly created username */
    private String username;
    /** newly assigned personID */
    private String personId;

    public String getAuthToken() {
        return authToken;
    }

    public String getUsername() {
        return username;
    }

    public String getPersonId() {
        return personId;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(authToken);
        sb.append(username);
        sb.append(personId);
        return sb.toString();
    }
    /** Constructor
     *
     * @param authToken
     * @param username
     * @param personId
     */

    public RegisterResponse(String authToken, String username, String personId) {
        this.authToken = authToken;
        this.username = username;
        this.personId = personId;
    }
    public RegisterResponse(){}
}
