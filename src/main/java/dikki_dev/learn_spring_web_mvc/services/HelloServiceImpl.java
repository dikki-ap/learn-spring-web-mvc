package dikki_dev.learn_spring_web_mvc.services;

import org.springframework.stereotype.Service;

// Membuat Class yang menjadi "implementasi" dari Interface Service dan otomatis untuk register Bean di Spring
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        if(name == null){
            return "Hello Guest";
        }else{
            return "Hello " + name;
        }
    }
}
