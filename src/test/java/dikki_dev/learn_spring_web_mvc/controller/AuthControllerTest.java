
package dikki_dev.learn_spring_web_mvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc // Mengizinkan Spring untuk membuat objek MockMvc secara otomatis
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testLoginSuccess() throws Exception {
        mockMvc.perform(
                        post("/auth/login")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("username", "Dikki")
                                .param("password", "123")
                )
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Authenticated"))
                );
    }

    @Test
    void testLoginFail() throws Exception {
        mockMvc.perform(
                        post("/auth/login")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("username", "Dikki")
                                .param("password", "324")
                )
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isUnauthorized(),
                        content().string(Matchers.containsString("Unauthorized"))
                );
    }
}
