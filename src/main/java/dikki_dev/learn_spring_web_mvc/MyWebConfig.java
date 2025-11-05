package dikki_dev.learn_spring_web_mvc;

import dikki_dev.learn_spring_web_mvc.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// Jika ingin membuat custom configuration untuk Web MVC, harus implementasi WebMvcConfigurer dan jadikan classnya Bean
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    // Registrasikan melalui DI "Custom Interceptor" ke WebMvcConfigurer
    @Autowired
    private SessionInterceptor sessionInterceptor;

    // Registernya melalui method "addInterceptors()" dengan "InterceptorRegistry"
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/user/*"); // "addPathPatterns()" berfungsi untuk set Interceptor ini khusus di "path" itu saja, jika tidak di set akan implement ke semua path
    }
}
