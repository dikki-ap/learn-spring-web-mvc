package dikki_dev.learn_spring_web_mvc.service;

import dikki_dev.learn_spring_web_mvc.services.HelloServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceImplTest {

    @Autowired
    private HelloServiceImpl helloService;

    @Test
    void testHello(){
        Assertions.assertEquals("Hello Guest", helloService.hello(null));
        Assertions.assertEquals("Hello Dikki", helloService.hello("Dikki"));
    }
}
