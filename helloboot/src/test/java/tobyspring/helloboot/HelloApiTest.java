package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {
    @Test
    void helloApi() {
        // http localhost:8080/hello?name=spring
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> responseEntity = rest.getForEntity(
                "http://localhost:8080/hello?name={name}",
                String.class,
                "Spring"
        );

        // status 200
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        // content-type header text/plain
        assertThat(responseEntity.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE))
                .startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hi Spring!
        assertThat(responseEntity.getBody()).isEqualTo("*Hi Spring!*");
    }

    @Test
    void failsHelloApi() {
        // http localhost:8080/hello?name=spring
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> responseEntity = rest.getForEntity(
                "http://localhost:8080/hello",
                String.class
        );

        // status 200
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
