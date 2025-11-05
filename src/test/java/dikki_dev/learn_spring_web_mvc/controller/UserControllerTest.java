package dikki_dev.learn_spring_web_mvc.controller;

import dikki_dev.learn_spring_web_mvc.model.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc // Mengizinkan Spring untuk membuat objek MockMvc secara otomatis
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetCurrentUser() throws Exception {
        mockMvc.perform(
                        get("/user/current")
                                .sessionAttr("user", new User("Dikki")) // Set "Session" Secara Manual
                )
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello Dikki")) // Mengambil Data Session
                );
    }

    @Test
    void testGetUserInvalid() throws Exception {
        mockMvc.perform(
                        get("/user/current")
                )
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().is3xxRedirection()
                );
    }
}
