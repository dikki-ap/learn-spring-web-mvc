package dikki_dev.learn_spring_web_mvc.controller;

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
public class DateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetDateWithParam() throws Exception {
        mockMvc.perform(
                        get("/date").queryParam("date", "2025-10-17")
                )
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Date: 20251017"))
                );
    }
}
