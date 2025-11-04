package dikki_dev.learn_spring_web_mvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc // Mengizinkan Spring untuk membuat objek MockMvc secara otomatis
public class UploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testUploadProfile() throws Exception {
        mockMvc.perform(
                        multipart("/upload/profile") // Khusus untuk UploadFile untuk test menggunakan "multipart"
                                .file(new MockMultipartFile("profile", "profile.png", "image/png", getClass().getResourceAsStream("/images/profile.png"))) // Untuk file mock nya bisa di set menggunakan seperti ini ("name", "originalFileName.extension", "mimeType") lalu ambill input Stream ke yang mau dipload "/images/profile.png"
                                .param("name", "Dikki")
                                .contentType(MediaType.MULTIPART_FORM_DATA)
                )
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Success save profile: Dikki to upload/profile.png"))
                );
    }
}
