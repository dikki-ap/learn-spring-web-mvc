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
public class TodoRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddTodoRestController() throws Exception {
        mockMvc.perform(
                        post("/todos")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .param("todo", "Dikki")
                )
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Dikki"))
                );
    }

    @Test
    void testGetTodoRestController() throws Exception {
        mockMvc.perform(
                        get("/todos")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Dikki"))
                );
    }
}
