package eu.precode.TestApp;

import org.apache.commons.codec.binary.Base64;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class TestAppApplicationTests {

    private RestTemplate restTemplate = new RestTemplate();


    @Test
    public void testOauthToken() {

        String plainCreds = "client:topsecret";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();

        formparams.add(new BasicNameValuePair("username", "Lukas"));
        formparams.add(new BasicNameValuePair("password","test123"));
        formparams.add(new BasicNameValuePair("grant_type", "password"));
        UrlEncodedFormEntity entity2 = new UrlEncodedFormEntity(formparams, StandardCharsets.UTF_8);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + base64Creds);
        HttpEntity<Object> reqData = new HttpEntity<>(entity2, headers);

        ResponseEntity<Object> entity = restTemplate.exchange("http://localhost:8080/oauth/token", HttpMethod.POST,
                reqData,
                Object.class);


    }
}

