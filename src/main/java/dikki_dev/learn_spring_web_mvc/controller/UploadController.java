package dikki_dev.learn_spring_web_mvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class UploadController {

    // Khusus untuk UploadFile bisa gunakan "consumes = MediaType.MULTIPART_FORM_DATA_VALUE"
    @PostMapping(path = "/upload/profile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String upload(
            @RequestParam(name = "name") String name,
            @RequestPart(name = "profile") MultipartFile profile // Khusus untuk handling file di Spring bisa gunakan Class MultipartFile dengan "@RequestPart" Annotation
    ) throws IOException{
        // Jika menerima file, akan memindahkan filenya ke dalam folder "/upload" dengan originalFileName nya
        // Pastikan folder "upload" ada
        Path uploadDir = Path.of("upload");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        // Simpan file ke upload/filename.ext
        Path filePath = uploadDir.resolve(profile.getOriginalFilename());

        profile.transferTo(filePath);

        return "Success save profile: " + name + " to upload/" + profile.getOriginalFilename();
    }
}
