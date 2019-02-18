package eu.precode.TestApp;

import eu.precode.TestApp.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestAppApplication.class)
@WebMvcTest
public class TestAppApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;


	/*@Test
	public void testOauthToken(){
		OauthRequest reqData = new OauthRequest("Lukas", "test123", "password");
		HttpEntity<OauthRequest> req = new HttpEntity<>(reqData);
		ResponseEntity<Object> entity = this.restTemplate.postForEntity("http://localhost:8080/oauth/token", req, OauthRequest.class);



		Assert.assertEquals(200, entity.getStatusCodeValue());

	}*/

    @Test
    public void googleTest() {
    }


}

