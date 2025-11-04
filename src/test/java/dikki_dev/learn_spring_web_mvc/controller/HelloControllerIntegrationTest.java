package dikki_dev.learn_spring_web_mvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

// Kita tambahkan "webEnvironment" untuk menjalankan Unit Test lengkap dengan "Apache Tomcat" nya seperti server berjalan normal
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {

    // Ini adalah class untuk Unit Test terkait Rest Template MVC di Spring
    // Tidak perlu menggunakan "MockMvc" lagi, karena kita sudah masuk mode "Integration Test"
    @Autowired
    private TestRestTemplate testRestTemplate;

    // Untuk mengetahui Port berapa yang digunakan saat menjalankan "Integration Test"
    @LocalServerPort
    private Integer localServerPort;

    @Test
    void helloGuest(){
        String response = testRestTemplate.getForEntity("http://localhost:" + localServerPort + "/hello", String.class)
                .getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello Guest", response.trim());
    }

    @Test
    void helloName(){
        String response = testRestTemplate.getForEntity("http://localhost:" + localServerPort + "/hello" + "?name=Dikki", String.class)
                .getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello Dikki", response.trim());
    }
}
