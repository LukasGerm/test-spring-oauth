package eu.precode.TestApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
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
	public void testOauthToken(){

        String plainCreds = "client:topsecret";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        Object oauthRequest = new OauthRequest("Lukas", "test123", "password");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic "+ base64Creds);
		HttpEntity<Object> reqData = new HttpEntity<>(oauthRequest, headers);

		ResponseEntity<Object> entity  = restTemplate.exchange("http://localhost:8080/oauth/token", HttpMethod.POST,
                reqData,
                Object.class);

	}


}

