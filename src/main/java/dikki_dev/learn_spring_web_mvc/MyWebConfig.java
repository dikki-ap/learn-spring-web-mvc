package dikki_dev.learn_spring_web_mvc;

import dikki_dev.learn_spring_web_mvc.interceptor.SessionInterceptor;
import dikki_dev.learn_spring_web_mvc.resolver.PartnerArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


// Jika ingin membuat custom configuration untuk Web MVC, harus implementasi WebMvcConfigurer dan jadikan classnya Bean
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    // Registrasikan melalui DI "Custom Interceptor" ke WebMvcConfigurer
    @Autowired
    private SessionInterceptor sessionInterceptor;

    // Registrasikan melalui DI "Custom Argument Resolver" ke WebMvcConfigurer
    @Autowired
    private PartnerArgumentResolver partnerArgumentResolver;

    // Registernya melalui method "addInterceptors()" dengan "InterceptorRegistry"
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/user/*"); // "addPathPatterns()" berfungsi untuk set Interceptor ini khusus di "path" itu saja, jika tidak di set akan implement ke semua path
    }

    // Registernya melalui method "addArgumentResolvers()" dengan "List<HandlerMethodArgumentResolver>"
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
        resolvers.add(partnerArgumentResolver); // Semua method di Controller dengan parameter "Partner.class" akan melalui ArgumentResolver ini
    }
}
