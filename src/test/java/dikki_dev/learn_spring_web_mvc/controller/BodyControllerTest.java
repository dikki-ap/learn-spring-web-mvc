package dikki_dev.learn_spring_web_mvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dikki_dev.learn_spring_web_mvc.model.HelloRequest;
import dikki_dev.learn_spring_web_mvc.model.HelloResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
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
public class BodyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testBodyHello() throws Exception {
        HelloRequest request = new HelloRequest();
        request.setName("Dikki");

        mockMvc.perform(
                        post("/body/hello")
                                .contentType(MediaType.APPLICATION_JSON_VALUE) // Set content-type for "consume"
                                .accept(MediaType.APPLICATION_JSON_VALUE)  // Set content-type for "produces"
                                .content(objectMapper.writeValueAsString(request)) // Ubah content dari request ke JSON
                )
                .andDo(print()) // Menampilkan hasil response di console saat test berjalan
                .andExpectAll(
                        status().isOk()
                ).andExpect(result -> {
                    // Mock Jsonnya ambil response
                    String responseBody = result.getResponse().getContentAsString(); // {"hello":"Hello Dikki"}

                    // Ubah dari JSON ke String
                    HelloResponse response = objectMapper.readValue(responseBody, HelloResponse.class);

                    Assertions.assertEquals("Hello Dikki", response.getHello());
                });
    }
}
