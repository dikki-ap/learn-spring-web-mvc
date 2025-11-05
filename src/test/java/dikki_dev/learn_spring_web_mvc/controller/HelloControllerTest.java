package dikki_dev.learn_spring_web_mvc.controller;

import dikki_dev.learn_spring_web_mvc.services.HelloService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc // Mengizinkan Spring untuk membuat objek MockMvc secara otomatis
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Menggunakan @MockBean untuk membuat "Mock" dari Hello Service
    // Kita bisa mengubah Behaviour nya juga
    @MockBean
    private HelloService helloService;

    @BeforeEach
    void setUp(){
        // Mengubah Behaviour dari helloService, jika string apapun yang masuk maka jadi "Hello Guys"
        Mockito.when(helloService.hello(null))
                .thenReturn("Hello Guest");

        // Mengubah Behaviour dari helloService, jika string apapun yang masuk maka jadi "Hello Guys"
        Mockito.when(helloService.hello(Mockito.anyString()))
                .thenReturn("Hello Guys");
    }

    @Test
    void helloGuest() throws Exception {
        mockMvc.perform(get("/hello"))
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello Guest"))
                );
    }

    @Test
    void helloName() throws Exception {
        mockMvc.perform(
                get("/hello").queryParam("name", "Dikki")
        )
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello Guys"))
                );
    }

    @Test
    void testhelloGuest405NotAllowed() throws Exception {
        mockMvc.perform(post("/hello"))
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isMethodNotAllowed()
                );
    }

    @Test
    void testHelloWeb() throws Exception {
        mockMvc.perform(get("/web/hello")
                        .queryParam("name", "Dikki"))
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Belajar View")),
                        content().string(Matchers.containsString("Hello Dikki"))
                );
    }

    @Test
    void testHelloGuest() throws Exception {
        mockMvc.perform(get("/web/hello"))
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Belajar View")),
                        content().string(Matchers.containsString("Hello Guest"))
                );
    }
}
