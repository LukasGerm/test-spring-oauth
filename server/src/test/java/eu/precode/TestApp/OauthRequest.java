package eu.precode.TestApp;

import lombok.Data;

@Data
public class OauthRequest {
    private String username;
    private String password;
    private String grant_type;

    public OauthRequest(String username, String password, String grant_type){
        this.username = username;
        this.password = password;
        this.grant_type = grant_type;
    }
}
