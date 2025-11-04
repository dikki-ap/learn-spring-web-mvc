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
public class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreatePerson() throws Exception {
        mockMvc.perform(
                        post("/create/person")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("firstName", "Dikki")
                                .param("lastName", "AP")
                                .param("email", "dikki.ap@gmail.com")
                                .param("phone", "+62")
                                .param("address.country", "Indonesia") // Jika nested ModelAttribute gunakan tanda "." untuk menyambung property nestednya
                                .param("address.province", "Jawa Barat") // Jika nested ModelAttribute gunakan tanda "." untuk menyambung property nestednya
                )
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Succcess create person Dikki AP dikki.ap@gmail.com +62 with address Indonesia Jawa Barat"))
                );
    }

}
