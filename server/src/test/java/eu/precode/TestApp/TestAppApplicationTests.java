package eu.precode.TestApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.codec.binary.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;


@SpringBootTest
public class TestAppApplicationTests {

    private RestTemplate restTemplate = new RestTemplate();


    @Test
    public void testOauthToken() {

        String plainCreds = "client:topsecret";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        ObjectMapper mapper = new ObjectMapper();


        OauthRequest oauthRequest = new OauthRequest("Lukas", "test123", "password");
        String json;

        try {
            json = mapper.writeValueAsString(oauthRequest);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
            headers.add("Content-Type", "application/json");
            HttpEntity<Object> reqData = new HttpEntity<>(json, headers);

            ResponseEntity<Object> entity = restTemplate.exchange("http://localhost:8080/oauth/token", HttpMethod.POST,
                    reqData,
                    Object.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}

